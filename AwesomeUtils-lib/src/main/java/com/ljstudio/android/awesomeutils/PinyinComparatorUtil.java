package com.ljstudio.android.awesomeutils;

import java.util.Comparator;


public class PinyinComparatorUtil implements Comparator<UserInfoData> {

    public int compare(UserInfoData o1, UserInfoData o2) {
        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }

}
