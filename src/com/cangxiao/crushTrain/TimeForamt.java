package com.cangxiao.crushTrain;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 编写一个函数将评论时间戳（Unix时间戳，精确到毫秒）格式化，格式化要求如下所示（按照顺序优先匹配处理）。
 * (1) 如果时间戳距离当前时间戳T小于1分钟，则显示“刚刚发布”。
 * (2) 如果时间戳距离当前时间戳T小于1小时，则显示“xx分钟前发布”，忽略多出来的秒钟等。
 * (3) 如果时间戳距离当前时间戳T小于1天，则显示“xx小时前发布”，忽略多出来的分钟和秒钟等。
 * (4) 如果时间戳距离当前时间戳T小于30天，则显示“xx天前发布”，忽略多出来的小时、分钟、秒钟等。
 * (5) 如果时间戳距离当前时间戳T小于1年（365天），则显示“xx个月前发布”，注：一个月按照30天算，忽略多出来的天、小时、分钟、秒钟等。
 * (6) 如果时间戳距离当前时间戳T大于1年（365天），则显示“xx年前发布”，注：一年按照365天算，忽略多出来的年、天、小时、分钟、秒钟等。
 * 为了方便判定，固定当前时间戳为：1707838655485
 */
public class TimeForamt {

    public String formatTime(long timestamp) {
        long currentTime = 1707838655485L;
        long diff = (currentTime - timestamp)/(60 * 1000);

        if (diff == 0) {
            return "刚刚发布";
        }
        if (diff < 60){
            return diff+"分钟前发布";
        }
        diff = diff/60;
        if (diff < 24) {
            return diff+"小时前发布";
        }
        diff = diff/24;
        if (diff < 30) {
            return diff+"天前发布";
        }
        diff = diff/30;
        if (diff < 12) {
            return diff+"个月前发布";
        }
        diff = diff/12;
        return diff+"年前发布";
    }

    public static void main(String[] args) {
        System.out.println(new Date(1707838655485L));
        System.out.println(new Date(1676302655485L));
        System.out.println(new TimeForamt().formatTime(1676302655485L));
        System.out.println(new TimeForamt().formatTime(1676302655485L));
    }
}
