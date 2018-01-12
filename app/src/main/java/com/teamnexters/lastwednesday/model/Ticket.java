package com.teamnexters.lastwednesday.model;

import java.util.Date;

import lombok.Data;

/**
 * Created by JY on 2018-01-12.
 */

/**
 * 티켓 정보 담을 클래스
 */
@Data
public class Ticket {

    private String title;
    private double price;
    private Date showTime;

    public Ticket(String title, double price, Date showTime) {
        this.title = title;
        this.price = price;
        this.showTime = showTime;
    }


}
