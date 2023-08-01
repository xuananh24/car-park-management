package com.example.car_park_management.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Time stringToTime(String time) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = simpleDateFormat.parse(time);
            return new Time(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
