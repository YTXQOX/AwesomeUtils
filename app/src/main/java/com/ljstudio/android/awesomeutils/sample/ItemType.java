package com.ljstudio.android.awesomeutils.sample;

/**
 * Created by tianguorui on 2016/7/20.
 */
public class ItemType {

    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final String textType;
    public final MyMeetingData myMeetingData;

    public int sectionPosition;
    public int listPosition;


    public ItemType(int type, String textType, MyMeetingData myMeetingData) {
        this.type = type;
        this.textType = textType;
        this.myMeetingData = myMeetingData;
    }

    @Override
    public String toString() {
        return textType;
    }

}

