package com.teamnexters.lastwednesday.model;

import java.util.Date;

/**
 * Created by JY on 2018-01-12.
 */

/**
 * 티켓 정보 담을 클래스
 */
public class Ticket {

    private String title;
    private double price;
    private Date showTime;

    public Ticket(String title, double price, Date showTime) {
        this.title = title;
        this.price = price;
        this.showTime = showTime;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
