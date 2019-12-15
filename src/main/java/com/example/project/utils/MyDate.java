package com.example.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private Calendar calendar = Calendar.getInstance();
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private Date currentDate = new Date();

    /*
        需要主要考虑这种模式:
        yyyy-MM-dd HH:mm:ss
        其他可选模式
        yyyy/MM/dd HH:mm:ss
        yyyy/MM/dd
     */

    // 默认的模式是 yyyy-MM-dd HH:mm:ss

    public MyDate() {
        super();
    }

    /**
     * 将Date转换为String
     *
     * @param date
     * @param pattern
     * @return 转换结果
     */
    public static String convertToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setLenient(false);

        if (pattern == null || "".equals(pattern.trim())) {
            pattern = DEFAULT_PATTERN;
        }

        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static String convertToString(Date date) {
        return convertToString(date, null);
    }

    /**
     * 将String转换为Date
     *
     * @param datetime
     * @param pattern
     * @return
     * @throws
     */
    public static Date parseDatetime(String datetime, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setLenient(false);

        if (pattern == null) {
            pattern = DEFAULT_PATTERN;
        }
        sdf.applyPattern(pattern);
        return sdf.parse(datetime);
    }

    public static Date parseDatetime(String datetime) throws ParseException {
        return parseDatetime(datetime, null);
    }

    /**
     * 判断传入时间是否比此类中的一个成员currentDate晚
     *
     * @param datetime
     * @return
     */
    public boolean laterThan(Date datetime) {
        return currentDate.after(datetime);
    }

    public boolean laterThan(String datetimeString) {
        try {
            return currentDate.after(parseDatetime(datetimeString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断传入时间是否比此类中的一个成员currentDate早
     *
     * @param datetime
     * @return
     */
    public boolean beforeThan(Date datetime) {
        return currentDate.before(datetime);
    }

    public boolean beforeThan(String datetimeString) {
        try {
            return currentDate.before(parseDatetime(datetimeString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断传入时间是否比过去24h晚
     *
     * @param datetime
     * @return
     */
    public boolean isIn24Hours(Date datetime) {
        this.calendar.add(Calendar.HOUR, -24);
        Date datetime2 = calendar.getTime();
        return datetime.after(datetime2);
    }


    /**
     * 判断传入日期是否比当前晚
     *
     * @param datetime
     * @return
     */
    public static boolean isLaterThanNow(Date datetime) {
        Date date = new Date();
        return datetime.after(date);

    }

    public static boolean isLaterThanNow(String datetime) {
        try {
            return isLaterThanNow(parseDatetime(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isStarted(Date datetime) {
        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR, -24);
        Date date = calendar.getTime();
        return datetime.after(date);
    }

    public static boolean isStarted(String datetime) {
        try {
            return isStarted(parseDatetime(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(currentDate);
    }
}
