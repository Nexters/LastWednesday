package com.teamnexters.lastwednesday.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JY on 2018-01-12.
 */

/**
 * 티켓 정보 담을 클래스
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
public class Ticket {

    private String title;
    private String date;
    private String concertHall;

    private String genre;
    private String running;
    private String age;
    private String casts;
    private String crews;

}
