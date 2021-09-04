package com.example.habitfinal;

import android.os.Parcel;
import android.os.Parcelable;

public class cHabitInfo implements Parcelable {

    String nameHabit,  text1;

    public cHabitInfo(){
    }

    public cHabitInfo(String nameHabit, String text1 )  {
        this.nameHabit = nameHabit;
        this.text1 = text1;
    }

    protected cHabitInfo(Parcel in) {
        nameHabit = in.readString();
        text1 = in.readString();
    }

    public static final Creator<cHabitInfo> CREATOR = new Creator<cHabitInfo>() {
        @Override
        public cHabitInfo createFromParcel(Parcel in) {
            return new cHabitInfo(in);
        }

        @Override
        public cHabitInfo[] newArray(int size) {
            return new cHabitInfo[size];
        }
    };

    public String getNameHabit() {
        return nameHabit;
    }

    public void setNameHabit(String nameHabit) {
        this.nameHabit = nameHabit;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameHabit);
        parcel.writeString(text1);
    }
}
