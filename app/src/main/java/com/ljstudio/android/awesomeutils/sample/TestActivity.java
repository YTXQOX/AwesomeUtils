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
        listData1 = new ArrayList<>();
        listData2 = new ArrayList<>();
        listData3 = new ArrayList<>();

        //    did 域名id
        //    domain 域名
        //    passwd 域名密码
        //    enddate 到期时间
        for (int i = 0; i < 8; i++) {
            MyMeetingData myMeetingData1 = new MyMeetingData();
            myMeetingData1.setDid("822463");
            myMeetingData1.setDomain("www.meizu.com");
            myMeetingData1.setPasswd("123456");
            myMeetingData1.setEnddate("2017-07-21 16:30:30");
            myMeetingData1.setType("DOMAIN");

            listData1.add(myMeetingData1);
        }

        //    tid 虚机id
        //    domain 绑定域名
        //    enddate 到期日期
        //    stype 虚机类型
        //    typename 类型名称
        for (int i = 0; i < 6; i++) {
            MyMeetingData myMeetingData2 = new MyMeetingData();

            myMeetingData2.setTid("822462");
            myMeetingData2.setDomain("www.meizu.com");
            myMeetingData2.setEnddate("2017-08-31 05:30:00");
            myMeetingData2.setStype("H890");
            myMeetingData2.setTypename("大蛇丸基地");
            myMeetingData2.setType("VM");

            listData2.add(myMeetingData2);
        }

//    Tid 数据库id
//    osystem 系统名称
//    IP 数据库IP
//    passwd 数据库密码
//    dbuser 数据库名
//    enddate 到期时间
        for (int i = 0; i < 10; i++) {
            MyMeetingData myMeetingData3 = new MyMeetingData();

            myMeetingData3.setTid("822461");
            myMeetingData3.setOsystem("MYSQL");
            myMeetingData3.setIP("2016-08-31 05:30");
            myMeetingData3.setPasswd("2016-07-25 22:30");
            myMeetingData3.setDbuser("大蛇丸");
            myMeetingData3.setEnddate("2016-07-25 22:30");
            myMeetingData3.setType("DB");

            listData3.add(myMeetingData3);
        }

        listData.addAll(listData1);
        listData.addAll(listData2);
        listData.addAll(listData3);

        simpleAdapter = new SimpleAdapter(TestActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, listData);
        pinnedSectionListView.setAdapter(simpleAdapter);
    }

}