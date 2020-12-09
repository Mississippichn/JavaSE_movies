package edu.liu.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private int mid;
    private String name;
    private String type;
    private String actor;
    private Date date;//上映时间
    private String director;
    private int clickRate;//点击率 默认值为0
    private int recoRate;//推荐率 默认值为0

    private int index;//临时存储

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Movie() {
    }

    public Movie(int mid, String name, String type, String actor, Date date, String director, int clickRate, int recoRate) {
        this.mid = mid;
        this.name = name;
        this.type = type;
        this.actor = actor;
        this.date = date;
        this.director = director;
        this.clickRate = clickRate;
        this.recoRate = recoRate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Date getDate() {
        return date;
    }

    public String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }

    public int getRecoRate() {
        return recoRate;
    }

    public void setRecoRate(int recoRate) {
        this.recoRate = recoRate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return mid +"\t"+name + "\t"+ type + "\t" + actor +"\t"+ sdf.format(date) +"\t"
                + director +"\t  " + clickRate +"\t\t  " + recoRate+"\t";
    }
}
