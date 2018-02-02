package com.teamnexters.lastwednesday.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by JY on 2018-01-31.
 * 통신 테스트를 위한 임시클래스 입니다.
 */
@Data
@AllArgsConstructor (staticName = "of")
public class Tag {
    String name;
    String fullName;
}
