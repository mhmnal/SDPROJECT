package com.example.habitfinal;

public class cHabitInfo {

    String nameHabit, motiv;

    public cHabitInfo(){
    }

    public cHabitInfo(String nameHabit, String motiv )  {
        this.nameHabit = nameHabit;
        this.motiv = motiv;
    }

    public String getNameHabit() {
        return nameHabit;
    }

    public void setNameHabit(String nameHabit) {
        this.nameHabit = nameHabit;
    }

    public String getMotiv() {
        return motiv;
    }

    public void setMotiv(String motiv) {
        this.motiv = motiv;
    }
}
