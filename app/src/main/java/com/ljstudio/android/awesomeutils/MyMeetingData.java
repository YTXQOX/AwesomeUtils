package com.ljstudio.android.awesomeutils;

/**
 * Created by guoxinyu on 2016/7/19.
 *
 */
public class MyMeetingData {

    private String id; // 预定记录id
    private String title; // 预定会议事由
    private String starttime; // 预定开始时间
    private String endtime; // 预定结束时间
    private String state;
    private String conference_name; // 预定会议室名称
    private String conference_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConference_name() {
        return conference_name;
    }

    public void setConference_name(String conference_name) {
        this.conference_name = conference_name;
    }

    public String getConference_id() {
        return conference_id;
    }

    public void setConference_id(String conference_id) {
        this.conference_id = conference_id;
    }
}
