package com.ljstudio.android.awesomeutils.sample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by tianguorui on 2016/7/20.
 */
public class SimpleAdapter extends ArrayAdapter<ItemType> implements PinnedSectionListView.PinnedSectionListAdapter {

    private Context mContext;
    private ArrayList<MyMeetingData> listData;


    public SimpleAdapter(Context context, int resource, int textViewResourceId, ArrayList<MyMeetingData> listData) {
        super(context, resource, textViewResourceId);

        this.mContext = context;
        this.listData = listData;

        generateDataSet(context, listData, false);
    }

    public void generateDataSet(Context context, ArrayList<MyMeetingData> listData, boolean clear) {

        if (clear) {
            clear();
        }

        String[] strSection = {"域名", "虚拟机", "数据库"}; //DOMAIN VM DB
        final int sectionsNumber = strSection.length;
        prepareSections(sectionsNumber);

        int sectionPosition = 0;
        int listPosition = 0;
        for (int i = 0; i < sectionsNumber; i++) {
            ItemType section = new ItemType(ItemType.SECTION, strSection[i], null);
            section.sectionPosition = sectionPosition;
            section.listPosition = listPosition++;
            onSectionAdded(section, sectionPosition);
            add(section);

//            final int itemsNumber = (int) Math.abs((Math.cos(2f * Math.PI / 3f * sectionsNumber / (i + 1f)) * 25f));
//            for (int j = 0; j < itemsNumber; j++) {
//                ItemType item = new ItemType(ItemType.ITEM, section.text.toUpperCase(Locale.ENGLISH) + " - " + j);
//                item.sectionPosition = sectionPosition;
//                item.listPosition = listPosition++;
//                add(item);
//            }

            for (int j = 0; j < listData.size(); j++) {
                String strType = listData.get(j).getType();

                if (((0 == i) && strType.equals("DOMAIN")) ||
                        ((1 == i) && strType.equals("VM")) ||
                        ((2 == i) && strType.equals("DB"))) {
                    ItemType item = new ItemType(ItemType.ITEM, section.textType.toUpperCase(Locale.ENGLISH) + " - " + j, listData.get(j));
                    item.sectionPosition = sectionPosition;
                    item.listPosition = listPosition++;
                    add(item);
                }
            }

            sectionPosition++;
        }
    }

    protected void prepareSections(int sectionsNumber) {
    }

    protected void onSectionAdded(ItemType section, int sectionPosition) {
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder myViewHolder;

        if (convertView == null) {
            myViewHolder = new ViewHolder();

            if (getItem(position).type == ItemType.SECTION) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.pinned_layout, null);

                myViewHolder.textViewPinned = (TextView) convertView.findViewById(R.id.id_item_pinned);
            } else {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, null);

                myViewHolder.itemLayout = (RelativeLayout) convertView.findViewById(R.id.id_item_layout);
                myViewHolder.textViewSubject = (TextView) convertView.findViewById(R.id.id_item_subject);
                myViewHolder.textViewDate = (TextView) convertView.findViewById(R.id.id_item_date);
            }

            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ViewHolder) convertView.getTag();
        }

        final int p = position;
        final ItemType item = getItem(position);

        if (item.type == ItemType.SECTION) {
            myViewHolder.textViewPinned.setTextColor(Color.DKGRAY);
            myViewHolder.textViewPinned.setText(item.textType);

            myViewHolder.textViewPinned.setBackgroundColor(parent.getResources().getColor(R.color.gray_light));
        } else {
            if (item.myMeetingData.getType().equals("DOMAIN")){
                myViewHolder.textViewSubject.setText(item.myMeetingData.getDomain());
                myViewHolder.textViewDate.setText(item.myMeetingData.getEnddate());

            } else if (item.myMeetingData.getType().equals("VM")) {
                myViewHolder.textViewSubject.setText(item.myMeetingData.getTypename());
                myViewHolder.textViewDate.setText(item.myMeetingData.getEnddate());
            } else if (item.myMeetingData.getType().equals("DB")) {
                myViewHolder.textViewSubject.setText(item.myMeetingData.getDbuser());
                myViewHolder.textViewDate.setText(item.myMeetingData.getOsystem());
            }

            myViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "ItemType " + p + ": " + item.textType, Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).type;
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == ItemType.SECTION;
    }

    class ViewHolder {
        TextView textViewPinned;

        RelativeLayout itemLayout;
        TextView textViewSubject;
        TextView textViewDate;
    }
}

