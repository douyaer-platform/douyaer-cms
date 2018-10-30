package com.douyaer.cms.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

public class CommonUtil {

    /**
     * 获取日期最早时间，如传入2010-12-26，返回2010-12-26 0:00:00 000
     * @param dateStr
     * @return
     */
    public static Date getDateStart(String dateStr){
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis((date.getTime() / 1000) * 1000);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            date = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取日期最晚时间，如传入2010-12-26，返回2010-12-26 23:59:59 999
     * @param dateStr
     * @return
     */
    public static Date getDateEnd(String dateStr){
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(((date.getTime() / 1000) * 1000) + 999);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            date = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}