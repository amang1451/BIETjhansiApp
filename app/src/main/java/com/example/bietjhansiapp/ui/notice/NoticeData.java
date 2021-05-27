package com.example.bietjhansiapp.ui.notice;

public class NoticeData {

    String title,date,image,key,time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public NoticeData() {
    }

    public NoticeData(String title, String date, String image, String key, String time) {
        this.title = title;
        this.date = date;
        this.image = image;
        this.key = key;
        this.time = time;
    }
}
