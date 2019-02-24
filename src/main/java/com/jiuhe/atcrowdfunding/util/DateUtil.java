package com.jiuhe.atcrowdfunding.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

    public static final Date EMPTY = null;
    public static final Date NOW = new Date();

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);

    public static Date parseDefaultDate(String date) {

        if (StringUtil.isEmpty(date)) {
            return EMPTY;
        }
        return localDateToDate(LocalDate.parse(date, DEFAULT_DATE_FORMATTER));
    }

    public static Date parseDefaultDateTime(String date) {

        if (StringUtil.isEmpty(date)) {
            return EMPTY;
        }
        return localDateToDate(LocalDate.parse(date, DEFAULT_DATETIME_FORMATTER));
    }

    public static Date parseDateTime(String date, String pattern) {

        if (StringUtil.isEmpty(date) || StringUtil.isEmpty(pattern)) {
            return EMPTY;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTimeToDate(LocalDateTime.parse(date, dateTimeFormatter));
    }

    public static Date parseDate(String date, String pattern) {

        if (StringUtil.isEmpty(date) || StringUtil.isEmpty(pattern)) {
            return EMPTY;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateToDate(LocalDate.parse(date, dateTimeFormatter));
    }

    /**
     * 将Date转换为LocalDate
     *
     * @param date Date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return LocalDate.from(zonedDateTime);
    }

    /**
     * 将Date转换为LocalDateTime
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.from(instant.atZone(ZoneId.systemDefault()));
    }

    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime 日期时间
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDate转换为Date
     *
     * @param localDate 日期
     * @return Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取两个日期相差天数
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 相差天数
     */
    public static Long getNumberTwoDates(Date start, Date end) {

//        if (start == null || end == null) {
        //抛出异常
//        }

        LocalDate localDateStart = dateToLocalDate(start);
        LocalDate localDateEnd = dateToLocalDate(end);

        return localDateStart.until(localDateEnd, ChronoUnit.DAYS);

    }

}
