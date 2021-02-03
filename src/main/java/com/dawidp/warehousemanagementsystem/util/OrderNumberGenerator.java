package com.dawidp.warehousemanagementsystem.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderNumberGenerator {

    public static String generator(){
        String generatedString = getCurrentDateInString() + "/" + randomStringGenerator(4);
        return generatedString;
    }
    public static String getCurrentDateInString() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String randomStringGenerator(int length){
        String randomString = RandomStringUtils.random(length);
        return randomString;
    }

}
