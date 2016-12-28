package com.ljstudio.android.awesomeutils.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class TestActivity extends AppCompatActivity {

    private PinnedSectionListView pinnedSectionListView;

    private SimpleAdapter simpleAdapter;

    private ArrayList<MyMeetingData> listData;
    private ArrayList<MyMeetingData> listData1;
    private ArrayList<MyMeetingData> listData2;
    private ArrayList<MyMeetingData> listData3;


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
        MyMeetingData myMeetingData3 = new MyMeetingData();


//    did 域名id
//    domain 域名
//    passwd 域名密码
//    enddate 到期时间
        myMeetingData1.setDid("822463");
        myMeetingData1.setDomain("开会开会开会");
        myMeetingData1.setPasswd("123456");
        myMeetingData1.setEnddate("2017-07-21 16:30:30");
        myMeetingData1.setType("DOMAIN");

//    tid 虚机id
//    domain 绑定域名
//    enddate 到期日期
//    stype 虚机类型
//    typename 类型名称
        myMeetingData2.setTid("822462");
        myMeetingData2.setDomain("不开会不开会不开会");
        myMeetingData2.setEnddate("2017-08-31 05:30:00");
        myMeetingData2.setStype("H890");
        myMeetingData2.setTypename("大蛇丸基地10086");
        myMeetingData2.setType("VM");

//    Tid 数据库id
//    osystem 系统名称
//    IP 数据库IP
//    passwd 数据库密码
//    dbuser 数据库名
//    enddate 到期时间
        myMeetingData3.setTid("822461");
        myMeetingData3.setOsystem("不开会不开会不开会");
        myMeetingData3.setIP("2016-08-31 05:30");
        myMeetingData3.setPasswd("2016-07-25 22:30");
        myMeetingData3.setDbuser("大蛇丸基地10086");
        myMeetingData3.setEnddate("A10086");
        myMeetingData3.setType("DB");

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

        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);
        listData.add(myMeetingData3);

        simpleAdapter = new SimpleAdapter(TestActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, listData);
        pinnedSectionListView.setAdapter(simpleAdapter);
    }

}