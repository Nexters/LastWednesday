package com.teamnexters.lastwednesday.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import java.io.Serializable;

/**
 * Created by JY on 2018-02-23.
 */


public class Play  extends BaseObservable implements Serializable{

    private String title;
    private String date;
    private String concertHall;

    private String genre;
    private String running;
    private String age;
    private String casts;
    private String crews;

    private int poster;
    private boolean isWish;

    public Play(String title, String date, String concertHall, String genre, String running, String age, String casts, String crews, int poster, boolean isWish) {
        this.title = title;
        this.date = date;
        this.concertHall = concertHall;
        this.genre = genre;
        this.running = running;
        this.age = age;
        this.casts = casts;
        this.crews = crews;
        this.poster = poster;
        this.isWish = isWish;
    }

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

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        this.concertHall = concertHall;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public String getCrews() {
        return crews;
    }

    public void setCrews(String crews) {
        this.crews = crews;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Bindable
    public boolean isWish() {
        return isWish;
    }

    public void setWish(boolean wish) {
        isWish = wish;
        notifyPropertyChanged(BR.wish);
    }
}
