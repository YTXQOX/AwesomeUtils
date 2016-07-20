package com.ljstudio.android.awesomeutils;

/**
 * Created by tianguorui on 2016/7/20.
 */
public class ItemType {

    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final String text;

    public int sectionPosition;
    public int listPosition;

    public ItemType(int type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}

