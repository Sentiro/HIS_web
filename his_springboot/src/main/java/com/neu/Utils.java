package com.neu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String format(String time){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = sdf1.parse(time);//拿到Date对象
            String str = sdf2.format(date);//输出格式：2017-01-22 09:28:33
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
