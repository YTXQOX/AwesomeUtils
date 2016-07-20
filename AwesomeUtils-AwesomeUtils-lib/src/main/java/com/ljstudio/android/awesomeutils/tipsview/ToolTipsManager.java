/*
Copyright 2016 Tomer Goldstein

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.ljstudio.android.awesomeutils.tipsview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ToolTipsManager {

    private static final String TAG = ToolTipsManager.class.getSimpleName();

    private static final int DEFAULT_ANIM_DURATION = 400;

    // Parameter for managing tip creation or reuse
    private Map<Integer, View> mTipsMap = new HashMap<>();

    private int mAnimationDuration;
    private TipListener mListener;

    public interface TipListener {
        void onTipDismissed(View view, boolean byUser);
    }

    public ToolTipsManager(){
        mAnimationDuration = DEFAULT_ANIM_DURATION;
    }

    public ToolTipsManager(TipListener listener){
        mAnimationDuration = DEFAULT_ANIM_DURATION;;
        mListener = listener;
    }

    public View show(ToolTips toolTips) {
        View tipView = create(toolTips);
        if (tipView == null) {
            return null;
        }

        // animate tip visibility
        AnimationUtil.popup(tipView, mAnimationDuration).start();

        return tipView;
    }

    private View create(ToolTips toolTips) {

        if (toolTips.getAnchorView() == null) {
            Log.e(TAG, "Unable to create a tip, anchor view is null");
            return null;
        }

        if (toolTips.getRootView() == null) {
            Log.e(TAG, "Unable to create a tip, root layout is null");
            return null;
        }

        // only one tip is allowed near an anchor view at the same time, thus
        // reuse tip if already exist
        if (mTipsMap.containsKey(toolTips.getAnchorView().hashCode())) {
            return mTipsMap.get(toolTips.getAnchorView().hashCode());
        }

        // init tip view parameters
        TextView tipView = createTipView(toolTips);

        // on RTL languages replace sides
        if (UIUtil.isRtl()) {
            switchToolTipSidePosition(toolTips);
        }

        // set tool tip background / shape
        ToolTipsBackgroundConstructor.setBackground(tipView, toolTips);

        // add tip to root layout
        toolTips.getRootView().addView(tipView);

        // find where to position the tool tip
        Point p = ToolTipsCoordinatesFinder.getCoordinates(tipView, toolTips);

        // move tip view to correct position
        moveTipToCorrectPosition(tipView, p);

        // set dismiss on click
        tipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss(view, true);
            }
        });

        // store anchorView hashcode with tipView
        int hashCode = toolTips.getAnchorView().hashCode();
        tipView.setTag(hashCode);

        // enter tip to map by 'anchorView' hash code
        mTipsMap.put(hashCode, tipView);

        return tipView;

    }

    private void moveTipToCorrectPosition(TextView tipView, Point p) {
        Coordinates tipViewCoordinates = new Coordinates(tipView);
        int translationX = p.x - tipViewCoordinates.left;
        int translationY = p.y - tipViewCoordinates.top;
        tipView.setTranslationX(!UIUtil.isRtl() ? translationX : -translationX);
        tipView.setTranslationY(translationY);
    }

    @NonNull
    private TextView createTipView(ToolTips toolTips) {
        TextView tipView = new TextView(toolTips.getContext());
        tipView.setTextColor(toolTips.getTextColor());
        tipView.setText(toolTips.getMessage());
        tipView.setVisibility(View.INVISIBLE);
        tipView.setGravity(toolTips.getTextGravity());
        setTipViewElevation(tipView, toolTips);
        return tipView;
    }

    private void setTipViewElevation(TextView tipView, ToolTips toolTips) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (toolTips.getElevation() > 0) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
                    @SuppressLint("NewApi")
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setEmpty();
                    }
                };
                tipView.setOutlineProvider(viewOutlineProvider);
                tipView.setElevation(toolTips.getElevation());
            }
        }
    }

    private void switchToolTipSidePosition(ToolTips toolTips) {
        if (toolTips.positionedLeftTo()) {
            toolTips.setPosition(ToolTips.POSITION_RIGHT_TO);
        } else if (toolTips.positionedRightTo()) {
            toolTips.setPosition(ToolTips.POSITION_LEFT_TO);
        }
    }

    public void setAnimationDuration(int duration){
        mAnimationDuration = duration;
    }

    public boolean dismiss(View tipView, boolean byUser) {
        if (tipView != null && isVisible(tipView)) {
            int key = (int) tipView.getTag();
            mTipsMap.remove(key);
            animateDismiss(tipView, byUser);
            return true;
        }
        return false;
    }

    public boolean dismiss(Integer key) {
        return mTipsMap.containsKey(key) && dismiss(mTipsMap.get(key), false);
    }

    public View find(Integer key) {
        if (mTipsMap.containsKey(key)) {
            return mTipsMap.get(key);
        }
        return null;
    }

    public boolean findAndDismiss(final View anchorView) {
        View view = find(anchorView.hashCode());
        return view != null && dismiss(view, false);
    }

    public void clear() {
        if (!mTipsMap.isEmpty()) {
            for (Map.Entry<Integer, View> entry : mTipsMap.entrySet()) {
                dismiss(entry.getValue(), false);
            }
        }
        mTipsMap.clear();
    }

    private void animateDismiss(final View view, final boolean byUser) {
        AnimationUtil.popout(view, mAnimationDuration, new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (mListener != null){
                    mListener.onTipDismissed(view, byUser);
                }
            }
        }).start();
    }

    public boolean isVisible(View tipView) {
        return tipView.getVisibility() == View.VISIBLE;
    }

}
