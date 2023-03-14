package com.example.ex01.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputVO {
    private String name;

    public static String getNow() {
        Date nowDate = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        String strNowDate = simpleDateFormat.format(nowDate);

        return strNowDate;
    }
}
