package com.ljstudio.android.awesomeutils;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class TestActivity extends AppCompatActivity {

    private PinnedSectionListView pinnedSectionListView;

    private SimpleAdapter simpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        pinnedSectionListView = (PinnedSectionListView) findViewById(R.id.id_test_list);

        simpleAdapter = new SimpleAdapter(TestActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1);
        pinnedSectionListView.setAdapter(simpleAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * SimpleAdapter
     */
    public static class SimpleAdapter extends ArrayAdapter<Item> implements PinnedSectionListView.PinnedSectionListAdapter {

        private Context mContext;

        public SimpleAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);

            this.mContext = context;

            generateDataSet('A', 'Z', false);
        }

        public void generateDataSet(char from, char to, boolean clear) {

            if (clear) {
                clear();
            }

            String[] strSection = {"今天", "以后"};
            final int sectionsNumber = to - from + 1;
            prepareSections(sectionsNumber);

            int sectionPosition = 0;
            int listPosition = 0;
            int mSection = strSection.length;
            for (char i = 0; i < mSection; i++) {
                Item section = new Item(Item.SECTION, strSection[i]);
                section.sectionPosition = sectionPosition;
                section.listPosition = listPosition++;
                onSectionAdded(section, sectionPosition);
                add(section);

                final int itemsNumber = (int) Math.abs((Math.cos(2f * Math.PI / 3f * sectionsNumber / (i + 1f)) * 25f));
                for (int j = 0; j < itemsNumber; j++) {
                    Item item = new Item(Item.ITEM, section.text.toUpperCase(Locale.ENGLISH) + " - " + j);
                    item.sectionPosition = sectionPosition;
                    item.listPosition = listPosition++;
                    add(item);
                }

                sectionPosition++;
            }
        }

        protected void prepareSections(int sectionsNumber) {
        }

        protected void onSectionAdded(Item section, int sectionPosition) {
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setTextColor(Color.DKGRAY);
            view.setTag("" + position);
            final Item item = getItem(position);
            if (item.type == Item.SECTION) {
                view.setBackgroundColor(parent.getResources().getColor(R.color.gray_light));
            }

            final int p = position;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Item " + p + ": " + item.text, Toast.LENGTH_SHORT).show();
                }
            });

            return view;
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
            return viewType == Item.SECTION;
        }

    }

    public static class Item {

        public static final int ITEM = 0;
        public static final int SECTION = 1;

        public final int type;
        public final String text;

        public int sectionPosition;
        public int listPosition;

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

    }

}