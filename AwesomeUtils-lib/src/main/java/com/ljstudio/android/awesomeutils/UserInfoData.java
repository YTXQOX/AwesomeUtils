package com.ljstudio.android.awesomeutils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tianguorui on 2016/7/22.
 */
public class UserInfoData implements Parcelable {

    private String sortLetters;  //显示数据拼音的首字母


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sortLetters);
    }

    public UserInfoData() {
    }

    protected UserInfoData(Parcel in) {
        this.sortLetters = in.readString();
    }

    public static final Creator<UserInfoData> CREATOR = new Creator<UserInfoData>() {
        @Override
        public UserInfoData createFromParcel(Parcel source) {
            return new UserInfoData(source);
        }

        @Override
        public UserInfoData[] newArray(int size) {
            return new UserInfoData[size];
        }
    };

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}
