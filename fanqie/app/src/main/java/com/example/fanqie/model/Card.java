package com.example.fanqie.model;
/*
 *  包名: com.example.fanqie.model
 * Created by ASUS on 2018/4/26.
 *  描述: TODO
 */

public class Card {

    private int type;
    private int fanqienum;
    private float hour;
    private String desc;
    private float finishhour;


    public Card(int type, int fanqienum, long hour, String desc, float finishhour) {
        this.type = type;
        this.fanqienum = fanqienum;
        this.hour = hour;
        this.desc = desc;
        this.finishhour = finishhour;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFanqienum() {
        return fanqienum;
    }

    public void setFanqienum(int fanqienum) {
        this.fanqienum = fanqienum;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public float getFinishhour() {
        return finishhour;
    }

    public void setFinishhour(float finishhour) {
        this.finishhour = finishhour;
    }
}
