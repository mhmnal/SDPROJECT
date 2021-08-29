package com.example.habitfinal;

public class cHabitInfo {

    String nameHabit,  text1;

    public cHabitInfo(){
    }

    public cHabitInfo(String nameHabit, String text1 )  {
        this.nameHabit = nameHabit;
        this.text1 = text1;
    }

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
}
