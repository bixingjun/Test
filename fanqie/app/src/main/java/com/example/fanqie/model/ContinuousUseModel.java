package com.example.fanqie.model;
/*
 *  包名: com.example.fanqie.model
 * Created by ASUS on 2018/4/22.
 *  描述: TODO
 */

public class ContinuousUseModel {

    private int rank;

    private String headurl;

    private String name;

    private int time;

    public ContinuousUseModel(int rank, String headurl, String name, int time) {
        this.rank = rank;
        this.headurl = headurl;
        this.name = name;
        this.time = time;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
