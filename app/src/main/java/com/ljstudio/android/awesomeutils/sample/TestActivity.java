package com.ljstudio.android.awesomeutils.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class TestActivity extends AppCompatActivity {

    private PinnedSectionListView pinnedSectionListView;

    private SimpleAdapter simpleAdapter;

    private ArrayList<MyMeetingData> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        pinnedSectionListView = (PinnedSectionListView) findViewById(R.id.id_test_list);

        initData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initData() {
        listData = new ArrayList<>();

        MyMeetingData myMeetingData1 = new MyMeetingData();
        MyMeetingData myMeetingData2 = new MyMeetingData();

        myMeetingData1.setId("PP12345678");
        myMeetingData1.setTitle("开会开会开会");
        myMeetingData1.setStarttime("2016-07-21 09:30");
        myMeetingData1.setEndtime("2016-07-21 16:30");
        myMeetingData1.setConference_name("暗部密室10001");
        myMeetingData1.setConference_id("A10001");

        myMeetingData2.setId("PP87654321");
        myMeetingData2.setTitle("不开会不开会不开会");
        myMeetingData2.setStarttime("2016-08-31 05:30");
        myMeetingData2.setEndtime("2016-07-25 22:30");
        myMeetingData2.setConference_name("大蛇丸基地10086");
        myMeetingData2.setConference_id("A10086");

        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);
        listData.add(myMeetingData1);

        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);
        listData.add(myMeetingData2);

        simpleAdapter = new SimpleAdapter(TestActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, listData);
        pinnedSectionListView.setAdapter(simpleAdapter);
    }

}