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

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import com.ljstudio.android.awesomeutils.R;


class ToolTipsBackgroundConstructor {

    /**
     * Select which background will be assign to the tip view
     */
    static void setBackground(View tipView, ToolTips toolTips) {

        // show tool tip without arrow. no need to continue
        if (toolTips.hideArrow()) {
            setToolTipNoArrowBackground(tipView, toolTips.getBackgroundColor());
            return;
        }

        // show tool tip according to requested position
        switch (toolTips.getPosition()) {
            case ToolTips.POSITION_ABOVE:
                setToolTipAboveBackground(tipView, toolTips);
                break;
            case ToolTips.POSITION_BELOW:
                setToolTipBelowBackground(tipView, toolTips);
                break;
            case ToolTips.POSITION_LEFT_TO:
                setToolTipLeftToBackground(tipView, toolTips.getBackgroundColor());
                break;
            case ToolTips.POSITION_RIGHT_TO:
                setToolTipRightToBackground(tipView, toolTips.getBackgroundColor());
                break;
        }

    }

    private static void setToolTipAboveBackground(View tipView, ToolTips toolTips) {
        switch (toolTips.getAlign()) {
            case ToolTips.ALIGN_CENTER:
                setTipBackground(tipView, R.drawable.tooltip_arrow_down, toolTips.getBackgroundColor());
                break;
            case ToolTips.ALIGN_LEFT:
                setTipBackground(tipView,
                        !UIUtil.isRtl() ?
                                R.drawable.tooltip_arrow_down_left :
                                R.drawable.tooltip_arrow_down_right
                        , toolTips.getBackgroundColor());
                break;
            case ToolTips.ALIGN_RIGHT:
                setTipBackground(tipView,
                        !UIUtil.isRtl() ?
                                R.drawable.tooltip_arrow_down_right :
                                R.drawable.tooltip_arrow_down_left
                        , toolTips.getBackgroundColor());
                break;
        }
    }

    private static void setToolTipBelowBackground(View tipView, ToolTips toolTips) {

        switch (toolTips.getAlign()) {
            case ToolTips.ALIGN_CENTER:
                setTipBackground(tipView, R.drawable.tooltip_arrow_up, toolTips.getBackgroundColor());
                break;
            case ToolTips.ALIGN_LEFT:
                setTipBackground(tipView,
                        !UIUtil.isRtl() ?
                                R.drawable.tooltip_arrow_up_left :
                                R.drawable.tooltip_arrow_up_right
                        , toolTips.getBackgroundColor());
                break;
            case ToolTips.ALIGN_RIGHT:
                setTipBackground(tipView,
                        !UIUtil.isRtl() ?
                                R.drawable.tooltip_arrow_up_right :
                                R.drawable.tooltip_arrow_up_left
                        , toolTips.getBackgroundColor());
                break;
        }

    }

    private static void setToolTipLeftToBackground(View tipView, int color) {
        setTipBackground(tipView, !UIUtil.isRtl() ?
                        R.drawable.tooltip_arrow_right : R.drawable.tooltip_arrow_left,
                color);
    }

    private static void setToolTipRightToBackground(View tipView, int color) {
        setTipBackground(tipView, !UIUtil.isRtl() ?
                        R.drawable.tooltip_arrow_left : R.drawable.tooltip_arrow_right,
                color);
    }

    private static void setToolTipNoArrowBackground(View tipView, int color) {
        setTipBackground(tipView, R.drawable.tooltip_no_arrow, color);
    }

    private static void setTipBackground(View tipView, int drawableRes, int color){
        Drawable paintedDrawable = getTintedDrawable(tipView.getContext(),
                drawableRes, color);
        setViewBackground(tipView, paintedDrawable);
    }

    private static void setViewBackground(View view, Drawable drawable){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static Drawable getTintedDrawable(Context context, int drawableRes, int color){
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = context.getResources().getDrawable(drawableRes, null);
            if (drawable != null) {
                drawable.setTint(color);
            }
        } else {
            drawable = context.getResources().getDrawable(drawableRes);
            if (drawable != null) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }
        }

        return drawable;
    }

}
