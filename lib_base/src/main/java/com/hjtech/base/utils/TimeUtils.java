package com.hjtech.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 项目名:    EasyPark
 * 包名       com.hjtech.easypark.common.utils
 * 文件名:    TimeUtils
 * 创建者:    ZJB
 * 创建时间:  2017/6/20 on 15:12
 * 描述:     TODO
 */
public class TimeUtils {

    /**
     * 将时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String yyyyMMdd(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String HHmmss(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String yyyyMMddHHmm(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String yyyyMMddHHmmss(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String MMddHHmm(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String MMddHHmmss(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date date = new Date(time);
        return format.format(date);
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    public static String slashyyyyMMdd(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(time);
        return format.format(date);
    }
}
