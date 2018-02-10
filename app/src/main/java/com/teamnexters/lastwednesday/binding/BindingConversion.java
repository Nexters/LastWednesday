package com.teamnexters.lastwednesday.binding;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JY on 2018-01-12.
 */

public class BindingConversion {

    @android.databinding.BindingConversion
    public static String convertDateToString(Date date) { //날짜타입 변경 후 리턴
        return new SimpleDateFormat("yyyy년 MM월 dd일").format(date);
    }

    @android.databinding.BindingConversion
    public static String convertDoubletoPrice(double d) { //금액타입
        return new DecimalFormat("#,###").format(d) + "원";
    }
}
