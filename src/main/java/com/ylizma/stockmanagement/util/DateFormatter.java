package com.ylizma.stockmanagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateFormatter {

    public static Date getCurrentDate() throws ParseException {
        Date currentDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String managedDate = df.format(currentDate);
        return df.parse(managedDate);
    }
}
