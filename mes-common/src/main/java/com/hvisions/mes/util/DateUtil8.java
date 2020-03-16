package com.hvisions.mes.util;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * java1.8 的新特性，解决SimpleDateFormat的线程问题<br>
 * <li>Instant代替 Date，</li>
 * <li>LocalDateTime代替 Calendar，</li>
 * <li>DateTimeFormatter 代替 SimpleDateFormat.</li> 注意：如果是共享变量，则可能会出现线程问题。<br>
 *
 * @author Bruce 2019/07/17
 */
public class DateUtil8 {
    // 时间元素
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String WEEK = "week";
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";

    // 星期元素
    private static final String MONDAY = "MONDAY";// 星期一
    private static final String TUESDAY = "TUESDAY";// 星期二
    private static final String WEDNESDAY = "WEDNESDAY";// 星期三
    private static final String THURSDAY = "THURSDAY";// 星期四
    private static final String FRIDAY = "FRIDAY";// 星期五
    private static final String SATURDAY = "SATURDAY";// 星期六
    private static final String SUNDAY = "SUNDAY";// 星期日

    // 根据指定格式显示日期和时间
    /**
     * yyyy-MM
     */
    private static final DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
    /**
     * yyyy-MM-dd
     */
    private static final DateTimeFormatter yyyyMMdd_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * yyyy/MM/dd
     */
    private static final DateTimeFormatter yyyyMMdd_U = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    /**
     * yyyy/MM/dd
     */
    private static final DateTimeFormatter yyyyMMdd_U_HMS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * yyyy-MM-dd HH
     */
    private static final DateTimeFormatter yyyyMMddHH_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    /**
     * yyyy-MM-dd HH:mm
     */
    private static final DateTimeFormatter yyyyMMddHHmm_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter yyyyMMddHHmmss_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * HH:mm:ss
     */
    private static final DateTimeFormatter HHmmss_EN = DateTimeFormatter.ofPattern("HH:mm:ss");
    /**
     * yyyy年MM月dd日
     */
    private static final DateTimeFormatter yyyyMMdd_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    /**
     * yyyy年MM月dd日HH时
     */
    private static final DateTimeFormatter yyyyMMddHH_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时");
    /**
     * yyyy年MM月dd日HH时mm分
     */
    private static final DateTimeFormatter yyyyMMddHHmm_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分");
    /**
     * yyyy年MM月dd日HH时mm分ss秒
     */
    private static final DateTimeFormatter yyyyMMddHHmmss_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
    /**
     * HH时mm分ss秒
     */
    private static final DateTimeFormatter HHmmss_CN = DateTimeFormatter.ofPattern("HH时mm分ss秒");

    // 本地时间显示格式：区分中文和外文显示
    private static final DateTimeFormatter shotDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    private static final DateTimeFormatter fullDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private static final DateTimeFormatter longDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    private static final DateTimeFormatter mediumDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);



    public static String strToStr(String str){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime parse = LocalDateTime.parse(str, dtf);
        DateTimeFormatter abc = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = abc.format(parse);
        return  format;
    }





    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd
     * @author zero 2019/03/30
     */
    public static String getNowDate_EN() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong() {
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        return second;
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToMillions() {
        LocalDateTime now = LocalDateTime.now();
        return now.atZone(ZoneId.of("+8")).toInstant().toEpochMilli();
    }

    public static String convertCurDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate now = instant.atZone(zoneId).toLocalDate();
        return now.format(yyyyMMdd_EN);
    }

    /**
     * 获取当前日期
     *
     * @return 字符串yyyy-MM-dd HH:mm:ss
     * @author zero 2019/03/30
     */
    public static String getNowTime_EN() {
        return LocalDateTime.now().format(yyyyMMddHHmmss_EN);
    }


    /**
     * 获取当前日期
     *
     * @return 字符串yyyy-MM-dd HH:mm:ss
     * @author zero 2019/03/30
     */
    public static String getNowTime_U() {
        return LocalDateTime.now().format(yyyyMMdd_U);
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH）
     */
    public static String getNowTime_EN_yMdH() {
        return LocalDateTime.now().format(yyyyMMddHH_EN);
    }

    /**
     * 获取当前时间（yyyy年MM月dd日）
     */
    public static String getNowTime_CN_yMdH() {
        return LocalDateTime.now().format(yyyyMMddHH_CN);
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm）
     */
    public static String getNowTime_EN_yMdHm() {
        return LocalDateTime.now().format(yyyyMMddHHmm_EN);
    }

    /**
     * 获取当前时间（yyyy年MM月dd日HH时mm分）
     */
    public static String getNowTime_CN_yMdHm() {
        return LocalDateTime.now().format(yyyyMMddHHmm_CN);
    }

    /**
     * 获取当前时间（HH时mm分ss秒）
     */
    public static String getNowTime_CN_HHmmss() {
        return LocalDateTime.now().format(HHmmss_CN);
    }

    /**
     * 根据日期格式，获取当前时间
     *
     * @param formatStr 日期格式<br>
     *                  <li>yyyy</li>
     *                  <li>yyyy-MM-dd</li>
     *                  <li>yyyy-MM-dd HH:mm:ss</li>
     *                  <li>HH:mm:ss</li>
     * @return
     * @author zero 2019/03/30
     */
    public static String getTime(String formatStr) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 获取中文的当前日期
     *
     * @return yyyy年mm月dd日
     * @author zero 2019/03/30
     */
    public static String getNowDate_CN() {
        return LocalDate.now().format(yyyyMMdd_CN);
    }

    /**
     * 获取中文当前时间
     *
     * @return yyyy年MM月dd日HH时mm分ss秒
     * @author zero 2019/03/30
     */
    public static String getNowTime_CN() {
        return LocalDateTime.now().format(yyyyMMddHHmmss_CN);
    }

    /**
     * 简写本地当前日期：yy-M-dd<br>
     * 例如：19-3-30为2019年3月30日
     *
     * @return 字符串yy-M-dd
     * @author zero 2019/03/30
     */
    public static String getNowLocalTime_shot() {
        return LocalDateTime.now().format(shotDate);
    }

    /**
     * 根据当地日期显示格式：yyyy年M月dd日 星期？（中国）
     *
     * @return 形如：2019年3月30日 星期六
     * @author zero 2019/03/30
     */
    public static String getNowLocalTime_full() {
        return LocalDateTime.now().format(fullDate);
    }

    /**
     * 根据当地显示日期格式：yyyy年M月dd日（中国）
     *
     * @return 形如 2019年3月30日
     * @author zero 2019/03/30
     */
    public static String getNowLocalTime_long() {
        return LocalDateTime.now().format(longDate);
    }

    /**
     * 根据当地显示日期格式：yyyy-M-dd（中国）
     *
     * @return 形如：2019-3-30
     * @author zero 2019/03/30
     */
    public static String getNowLocalTime_medium() {
        return LocalDateTime.now().format(mediumDate);
    }

    /**
     * 获取当前日期的节点时间（年，月，周，日，时，分，秒）
     *
     * @param node 日期中的节点元素（年，月，周，日，时，分，秒）
     * @return 节点数字，如创建此方法的时间：年 2019，月 3，日 30，周 6
     * @author zero 2019/03/30 星期六
     */
    public static Integer getNodeTime(String node) {
        LocalDateTime today = LocalDateTime.now();
        Integer resultNode = null;
        switch (node) {
            case YEAR:
                resultNode = today.getYear();
                break;
            case MONTH:
                resultNode = today.getMonthValue();
                break;
            case WEEK:
                resultNode = transformWeekEN2Num(String.valueOf(today.getDayOfWeek()));
                break;
            case DAY:
                resultNode = today.getDayOfMonth();
                break;
            case HOUR:
                resultNode = today.getHour();
                break;
            case MINUTE:
                resultNode = today.getMinute();
                break;
            case SECOND:
                resultNode = today.getSecond();
                break;
            default:
                // 当前日期是当前年的第几天。例如：2019/1/3是2019年的第三天
                resultNode = today.getDayOfYear();
                break;
        }
        return resultNode;
    }

    /**
     * 将英文星期转换成数字
     *
     * @param enWeek 英文星期
     * @return int，如果数字小于0，则检查，看是否输入错误 or 入参为null
     * @author zero 2019/03/30
     */
    public static int transformWeekEN2Num(String enWeek) {
        if (MONDAY.equals(enWeek)) {
            return 1;
        } else if (TUESDAY.equals(enWeek)) {
            return 2;
        } else if (WEDNESDAY.equals(enWeek)) {
            return 3;
        } else if (THURSDAY.equals(enWeek)) {
            return 4;
        } else if (FRIDAY.equals(enWeek)) {
            return 5;
        } else if (SATURDAY.equals(enWeek)) {
            return 6;
        } else if (SUNDAY.equals(enWeek)) {
            return 7;
        } else {
            return -1;
        }
    }

    /**
     * 获取当前日期之后（之后）的节点事件<br>
     * <ul>
     * 比如当前时间为：2019-03-30 10:20:30
     * </ul>
     * <li>node="hour",num=5L:2019-03-30 15:20:30</li>
     * <li>node="day",num=1L:2019-03-31 10:20:30</li>
     * <li>node="year",num=1L:2020-03-30 10:20:30</li>
     *
     * @param node 节点元素（“year”,"month","week","day","huor","minute","second"）
     * @param num  第几天（+：之后，-：之前）
     * @return 之后或之后的日期
     * @author zero 2019/03/30
     */
    public static String getAfterOrPreNowTime(String node, Long num) {
        LocalDateTime now = LocalDateTime.now();
        if (HOUR.equals(node)) {
            return now.plusHours(num).format(yyyyMMddHHmmss_EN);
        } else if (DAY.equals(node)) {
            return now.plusDays(num).format(yyyyMMddHHmmss_EN);
        } else if (WEEK.equals(node)) {
            return now.plusWeeks(num).format(yyyyMMddHHmmss_EN);
        } else if (MONTH.equals(node)) {
            return now.plusMonths(num).format(yyyyMMddHHmmss_EN);
        } else if (YEAR.equals(node)) {
            return now.plusYears(num).format(yyyyMMddHHmmss_EN);
        } else if (MINUTE.equals(node)) {
            return now.plusMinutes(num).format(yyyyMMddHHmmss_EN);
        } else if (SECOND.equals(node)) {
            return now.plusSeconds(num).format(yyyyMMddHHmmss_EN);
        } else {
            return "Node is Error!";
        }
    }

    /**
     * 获取与当前日期相距num个之后（之前）的日期<br>
     * <ul>
     * 比如当前时间为：2019-03-30 10:20:30的格式日期
     * <li>node="hour",num=5L:2019-03-30 15:20:30</li>
     * <li>node="day",num=1L:2019-03-31 10:20:30</li>
     * <li>node="year",num=1L:2020-03-30 10:20:30</li>
     * </ul>
     *
     * @param dtf  格式化当前时间格式（dtf = yyyyMMddHHmmss_EN）
     * @param node 节点元素（“year”,"month","week","day","huor","minute","second"）
     * @param num  （+：之后，-：之前）
     * @return 之后之前的日期
     * @author zero 2019/03/30
     */
    public static String getAfterOrPreNowTimePlus(DateTimeFormatter dtf, String node, Long num) {
        LocalDateTime now = LocalDateTime.now();
        if (HOUR.equals(node)) {
            return now.plusHours(num).format(dtf);
        } else if (DAY.equals(node)) {
            return now.plusDays(num).format(dtf);
        } else if (WEEK.equals(node)) {
            return now.plusWeeks(num).format(dtf);
        } else if (MONTH.equals(node)) {
            return now.plusMonths(num).format(dtf);
        } else if (YEAR.equals(node)) {
            return now.plusYears(num).format(dtf);
        } else if (MINUTE.equals(node)) {
            return now.plusMinutes(num).format(dtf);
        } else if (SECOND.equals(node)) {
            return now.plusSeconds(num).format(dtf);
        } else {
            return "Node is Error!";
        }
    }

    /**
     * 当前时间的hour，minute，second之后（之前）的时刻
     *
     * @param node 时间节点元素（hour，minute，second）
     * @param num  之后（之后）多久时，分，秒（+：之后，-：之前）
     * @return HH:mm:ss 字符串
     * @author zero 2019/03/30
     */
    public static String getAfterOrPreNowTimeSimp(String node, Long num) {
        LocalTime now = LocalTime.now();
        if (HOUR.equals(node)) {
            return now.plusHours(num).format(HHmmss_EN);
        } else if (MINUTE.equals(node)) {
            return now.plusMinutes(num).format(HHmmss_EN);
        } else if (SECOND.equals(node)) {
            return now.plusSeconds(num).format(HHmmss_EN);
        } else {
            return "Node is Error!";
        }
    }

    /**
     * 检查重复事件，比如生日。TODO This is a example.
     *
     * @param
     * @return
     * @author zero 2019/03/31
     */
    public static boolean isBirthday(int month, int dayOfMonth) {
        MonthDay birthDay = MonthDay.of(month, dayOfMonth);
        MonthDay curMonthDay = MonthDay.from(LocalDate.now());// MonthDay只存储了月、日。
        if (birthDay.equals(curMonthDay)) {
            return true;
        }
        return false;
    }

    /**
     * 获取当前日期第index日之后(之前)的日期（yyyy-MM-dd）
     *
     * @param index 第index天
     * @return 日期字符串：yyyy-MM-dd
     * @author zero 2019/03/31
     */
    public static String getAfterOrPreDayDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.DAYS).format(yyyyMMdd_EN);
    }

    /**
     * 获取当前日期第index周之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index周（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author zero 2019/03/31
     */
    public static String getAfterOrPreWeekDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.WEEKS).format(yyyyMMdd_EN);
    }

    /**
     * 获取当前日期第index月之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index月（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author zero 2019/03/31
     */
    public static String getAfterOrPreMonthDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.MONTHS).format(yyyyMMdd_EN);
    }

    /**
     * 获取当前日期第index年之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index年（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author zero 2019/03/31
     */
    public static String getAfterOrPreYearDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.YEARS).format(yyyyMMdd_EN);
    }

    /**
     * 获取当前日期的上一个月的日期
     * @param date 日期（yyyy-MM-dd）
     * @return 处理结果
     */
    public static String getLastMonthDate(String date) {
        LocalDate dateTime = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        dateTime = dateTime.minusMonths(1);
        return DateTimeFormatter.ISO_LOCAL_DATE.format(dateTime);
    }

    /**
     * 获取指定日期之前之后的第index的日，周，月，年的日期
     *
     * @param date  指定日期格式：yyyy-MM-dd
     * @param node  时间节点元素（日周月年）
     * @param index 之前之后第index个日期
     * @return yyyy-MM-dd 日期字符串
     * @author zero 2019/03/31
     */
    public static String getAfterOrPreDate(String date, String node, int index) {
        date = date.trim();
        if (DAY.equals(node)) {
            return LocalDate.parse(date).plus(index, ChronoUnit.DAYS).format(yyyyMMdd_EN);
        } else if (WEEK.equals(node)) {
            return LocalDate.parse(date).plus(index, ChronoUnit.WEEKS).format(yyyyMMdd_EN);
        } else if (MONTH.equals(node)) {
            return LocalDate.parse(date).plus(index, ChronoUnit.MONTHS).format(yyyyMMdd_EN);
        } else if (YEAR.equals(node)) {
            return LocalDate.parse(date).plus(index, ChronoUnit.YEARS).format(yyyyMMdd_EN);
        } else {
            return "Wrong date format!";
        }
    }

    /**
     * 检测：输入年份是否是闰年？
     *
     * @param date 日期格式：yyyy-MM-dd
     * @return true：闰年，false：平年
     * @author zero 2019/03/31
     */
    public static boolean isLeapYear(String date) {
        return LocalDate.parse(date.trim()).isLeapYear();
    }

    /**
     * 计算两个日期字符串之间相差多少个周期（天，月，年）
     *
     * @param date1 yyyy-MM-dd
     * @param date2 yyyy-MM-dd
     * @param node  三者之一:(day，month,year)
     * @return 相差多少周期
     * @author zero 2019/03/31
     */
    public static int peridCount(String date1, String date2, String node) {
        date1 = date1.trim();
        date2 = date2.trim();
        if (DAY.equals(node)) {
            return Period.between(LocalDate.parse(date1), LocalDate.parse(date2)).getDays();
        } else if (MONTH.equals(node)) {
            return Period.between(LocalDate.parse(date1), LocalDate.parse(date2)).getMonths();
        } else if (YEAR.equals(node)) {
            return Period.between(LocalDate.parse(date1), LocalDate.parse(date2)).getYears();
        } else {
            return 0;
        }
    }

    /**
     * 切割日期。按照周期切割成小段日期段。例如： <br>
     *
     * @param startDate 开始日期（yyyy-MM-dd）
     * @param endDate   结束日期（yyyy-MM-dd）
     * @param period    周期（天，周，月，年）
     * @return 切割之后的日期集合
     * @author zero 2019/04/02
     * @example <li>startDate="2019-02-28",endDate="2019-03-05",period="day"</li>
     * <li>结果为：[2019-02-28, 2019-03-01, 2019-03-02, 2019-03-03, 2019-03-04, 2019-03-05]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-03-25",period="week"</li>
     * <li>结果为：[2019-02-28,2019-03-06, 2019-03-07,2019-03-13, 2019-03-14,2019-03-20,
     * 2019-03-21,2019-03-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-05-25",period="month"</li>
     * <li>结果为：[2019-02-28,2019-02-28, 2019-03-01,2019-03-31, 2019-04-01,2019-04-30,
     * 2019-05-01,2019-05-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2020-05-25",period="year"</li>
     * <li>结果为：[2019-02-28,2019-12-31, 2020-01-01,2020-05-25]</li><br>
     */
    public static List<String> getPieDateRange(String startDate, String endDate, String period) {
        List<String> result = Lists.newArrayList();
        LocalDate end = LocalDate.parse(endDate, yyyyMMdd_EN);
        LocalDate start = LocalDate.parse(startDate, yyyyMMdd_EN);
        LocalDate tmp = start;
        switch (period) {
            case DAY:
                while (start.isBefore(end) || start.isEqual(end)) {
                    result.add(start.toString());
                    start = start.plusDays(1);
                }
                break;
            case WEEK:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    if (tmp.plusDays(6).isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + tmp.plusDays(6));
                    }
                    tmp = tmp.plusDays(7);
                }
                break;
            case MONTH:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfMonth = tmp.with(TemporalAdjusters.lastDayOfMonth());
                    if (lastDayOfMonth.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfMonth);
                    }
                    tmp = lastDayOfMonth.plusDays(1);
                }
                break;
            case YEAR:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfYear = tmp.with(TemporalAdjusters.lastDayOfYear());
                    if (lastDayOfYear.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfYear);
                    }
                    tmp = lastDayOfYear.plusDays(1);
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 指定日期月的最后一天（yyyy-MM-dd）
     *
     * @param curDate     日期格式（yyyy-MM-dd）
     * @param firstOrLast true：第一天，false：最后一天
     * @return
     * @author zero 2019/04/13
     */
    public static String getLastDayOfMonth(String curDate, boolean firstOrLast) {
        if (firstOrLast) {
            return LocalDate.parse(curDate, yyyyMMdd_EN).with(TemporalAdjusters.firstDayOfMonth()).toString();
        } else {
            return LocalDate.parse(curDate, yyyyMMdd_EN).with(TemporalAdjusters.lastDayOfMonth()).toString();
        }
    }

    /**
     * 指定日期年的最后一天（yyyy-MM-dd）
     *
     * @param curDate     指定日期（格式：yyyy-MM-dd）
     * @param firstOrLast true:第一天，false:最后一天
     * @return
     * @author zero 2019/04/13
     */
    public static String getLastDayOfYear(String curDate, boolean firstOrLast) {
        if (firstOrLast) {
            return LocalDate.parse(curDate, yyyyMMdd_EN).with(TemporalAdjusters.firstDayOfYear()).toString();
        } else {
            return LocalDate.parse(curDate, yyyyMMdd_EN).with(TemporalAdjusters.lastDayOfYear()).toString();
        }
    }

    /**
     * 获取下一个星期的日期
     *
     * @param curDay          yyyy-MM-dd
     * @param dayOfWeek       monday:1~sunday:7
     * @param isContainCurDay 是否包含当天，true：是，false：不包含
     * @return 日期（yyyy-MM-dd）
     * @author zero 2019/04/02
     */
    public static String getNextWeekDate(String curDay, int dayOfWeek, boolean isContainCurDay) {
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (isContainCurDay) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.next(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

    /**
     * 获取上一个星期的日期
     *
     * @param curDay    指定日期（yyyy-MM-dd）
     * @param dayOfWeek 数字范围（monday:1~sunday:7）
     * @param isCurDay  是否包含当天，true：是，false：不包含
     * @return 日期（yyyy-MM-dd）
     * @author zero 2019/04/02
     */
    public static String getPreWeekDate(String curDay, int dayOfWeek, boolean isCurDay) {
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (isCurDay) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.previousOrSame(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.previous(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

    /**
     * 获取指定日期当月的最后或第一个星期日期
     *
     * @param curDay      指定日期（yyyy-MM-dd）
     * @param dayOfWeek   周几（1~7）
     * @param lastOrFirst true：最后一个，false本月第一个
     * @return 日期（yyyy-MM-dd）
     * @author zero 2019/04/02
     */
    public static String getFirstOrLastWeekDate(String curDay, int dayOfWeek, boolean lastOrFirst) {
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (lastOrFirst) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.lastInMonth(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.firstInMonth(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

    public static long getMillsByDateString(String strDate) {
        Calendar cal = Calendar.getInstance();
        if ((strDate != null) && (strDate.trim().length() > 9)) {
            strDate = strDate.trim();
            try {
                int year = Integer.parseInt(strDate.substring(0, 4));
                int month = Integer.parseInt(strDate.substring(5, 7)) - 1;
                int date = Integer.parseInt(strDate.substring(8, 10));
                cal.set(year, month, date, 0, 0, 0);
                String str = String.valueOf(cal.getTimeInMillis());
                return Long.parseLong(str.substring(0, str.length() - 3) + "000");
            } catch (Exception e) {
            }

        }
        return 0L;
    }

    public static long getMillsByTime(String strTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            if ((strTime.length() != 19) && (strTime.length() != 10)) {
                Date date = dateFormat.parse(strTime);
                strTime = dateFormat.format(date);
            }

            int year = Integer.parseInt(strTime.substring(0, 4));
            int month = Integer.parseInt(strTime.substring(5, 7)) - 1;
            int day = Integer.parseInt(strTime.substring(8, 10));

            if ((year < 1000) || (year > 3000)) {
                throw new Exception("the year is wrong.");
            }

            if ((month < 0) || (month > 12)) {
                throw new Exception("the month is wrong.");
            }

            if ((day < 1) || (day > 31)) {
                throw new Exception("the day is wrong");
            }

            Calendar ca = Calendar.getInstance();
            if (strTime.length() == 19) {
                int hour = Integer.parseInt(strTime.substring(11, 13));
                int minute = Integer.parseInt(strTime.substring(14, 16));
                int second = Integer.parseInt(strTime.substring(17, 19));

                if ((hour < 0) || (hour > 24)) {
                    throw new Exception("the hour is wrong.");
                }

                if ((minute < 0) || (minute > 60)) {
                    throw new Exception("the minute is wrong.");
                }

                if ((second < 0) || (second > 60)) {
                    throw new Exception("the second is wrong.");
                }

                ca.set(year, month, day, hour, minute, second);
            } else if (strTime.length() == 10) {
                ca.set(year, month, day, 0, 0, 0);
            }
            return ca.getTimeInMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public static String getNextDays(String date, int days) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(date));
        cal.add(5, days);
        Date resultDate = cal.getTime();
        return format.format(resultDate);
    }


    /**
     * 获取当前时间 之前的分钟
     * @param length 长度
     * @return
     */
    public static String getPreMin(int length){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusMinutes(length);
        String localTime = yyyyMMddHHmmss_EN.format(localDateTime);
        return localTime;
    }


    private static final long ONE_MINUTE = 60000L;

    private static final long ONE_HOUR = 3600000L;

    private static final long ONE_DAY = 86400000L;

    private static final long ONE_WEEK = 604800000L;



    private static final String ONE_SECOND_AGO = "刚刚";

    private static final String ONE_MINUTE_AGO = "分钟前";

    private static final String ONE_HOUR_AGO = "小时前";

    private static final String ONE_DAY_AGO = "天前";

    private static final String ONE_MONTH_AGO = "月前";

    private static final String ONE_YEAR_AGO = "年前";

    public static String format(Date date) {

        long delta = System.currentTimeMillis() - date.getTime();

        if (delta < 1L * ONE_MINUTE) {

            long seconds = toSeconds(delta);

            return  ONE_SECOND_AGO;

        }

        if (delta < 1L * ONE_HOUR) {

            long minutes = toMinutes(delta);

            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;

        }

        if (delta < 24L * ONE_HOUR) {

            long hours = toHours(delta);

            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;

        }

        //if (delta < 168L * ONE_HOUR) {

         //   return "昨天";

        //}

        if (delta < 7L * ONE_DAY) {

            long days = toDays(delta);

            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;

        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");


            return format.format(date);


       /* if (delta < 12L * 4L * ONE_WEEK) {

            long months = toMonths(delta);

            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;

        } else {

            long years = toYears(delta);

            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;

        }*/

    }



    private static long toSeconds(long date) {

        return date / 1000L;

    }



    private static long toMinutes(long date) {

        return toSeconds(date) / 60L;

    }



    private static long toHours(long date) {

        return toMinutes(date) / 60L;

    }



    private static long toDays(long date) {

        return toHours(date) / 24L;

    }



    private static long toMonths(long date) {

        return toDays(date) / 30L;

    }



    private static long toYears(long date) {

        return toMonths(date) / 365L;

    }

    public static  Date strToDate(String str){
        Date date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

             date = format.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static  Date strToDateYYYYMMdd(String str){
        Date date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            date = format.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
    public static Date strToDateFormat(String str,String format){
        Date newDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            newDate = sdf.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return newDate;
    }
	
	
	 public static void main(String[] args)  {

        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:m:s");
//
//            Date date = format.parse("2019/07/23 07:48:46");

            System.out.println(getNowDate_EN());
//            System.out.println(getNowDate_EN().substring(0, getNowDate_EN().lastIndexOf("-")));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
