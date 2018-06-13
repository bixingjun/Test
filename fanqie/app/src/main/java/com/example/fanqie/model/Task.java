package com.example.fanqie.model;
/*
 *  包名: com.example.fanqie.model
 * Created by ASUS on 2018/4/17.
 *  描述: TODO
 */

public class Task {

    private int type;
    private String content;
    private String desc;
    private int num;
    private String photo;

    public Task(int type, String content, String desc, int num,String photo) {
        this.type = type;
        this.content = content;
        this.desc = desc;
        this.num = num;
        this.photo=photo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
