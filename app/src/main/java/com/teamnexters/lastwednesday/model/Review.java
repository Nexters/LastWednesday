package com.teamnexters.lastwednesday.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by JY on 2018-01-16.
 */
/**
 * 리뷰 담을 클래스
 */
@Data(staticConstructor = "of")
public class Review {

    @NonNull private String title;
    @NonNull private String content;
    @NonNull private double star;
    @NonNull private Date writeDate;
}
