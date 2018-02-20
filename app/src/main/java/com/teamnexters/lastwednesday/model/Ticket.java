package com.teamnexters.lastwednesday.model;

/**
 * Created by JY on 2018-01-12.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.teamnexters.lastwednesday.BR;

/**
 * 티켓 정보 담을 클래스
 */

public class Ticket extends BaseObservable {

    private String title;
    private String date;
    private String concertHall;

    private String genre;
    private String running;
    private String age;
    private String casts;
    private String crews;

    private boolean isLongClicked;

    @Bindable
    public boolean isLongClicked () {
        return isLongClicked;
    }

    public void setLongClicked ( boolean longClicked ) {
        isLongClicked = longClicked;
        notifyPropertyChanged(BR.longClicked);
    }

    public Ticket ( String title, String date, String concertHall, String genre, String running, String age, String casts, String crews, boolean isLongClicked ) {
        this.title = title;
        this.date = date;
        this.concertHall = concertHall;
        this.genre = genre;
        this.running = running;
        this.age = age;
        this.casts = casts;
        this.crews = crews;
        this.isLongClicked = isLongClicked;
    }

    public String getTitle () {
        return title;
    }

    public String getDate () {
        return date;
    }

    @Bindable
    public String getConcertHall () {
        return concertHall;
    }

    public String getGenre () {
        return genre;
    }

    public String getRunning () {
        return running;
    }

    public String getAge () {
        return age;
    }

    public String getCasts () {
        return casts;
    }

    public String getCrews () {
        return crews;
    }


}
