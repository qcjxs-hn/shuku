package com.shuku.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timeconversion {
    public static String timeconversion(String timestring){
        //格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //取出前端时间，并剔除时分秒，转为时间戳
        String newdate =timestring.substring(0, timestring.length() - 14);
        Date zdate = null;
        try {
            //字符串转化为日期格式
            zdate = dateFormat.parse(newdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取时间戳
        long ts = zdate.getTime();
        //加一天
        long yitian = 86400000;//一天的时间戳
        long newsj = ts + yitian;
        //将时间戳转换为日期
        Date time2=new Date(newsj);
        String lastnewdate=dateFormat.format(time2);//格式化
        //System.out.print(lastnewdate);
        return lastnewdate;
    }
}
