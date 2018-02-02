package com.teamnexters.lastwednesday.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by JY on 2018-01-16.
 */

/**
 * 리뷰 담을 클래스
 */
@Data
@AllArgsConstructor (staticName = "of")
public class Review {

    private String title;
    private String content;
    private double star;
    private Date writeDate;
}
