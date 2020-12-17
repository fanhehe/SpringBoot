package com.fanhehe.user.common.util;

import java.util.Date;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 17:30
 */
public final class OrderRandomUtil {
    private static int SEQUENCE = 0;
    private static long LAST_TIMESTAMP = timeGen();
    private static final int SEQUENCE_MASK = ((int) Math.pow(2, 13) - 1);

    /**
     * 获取系统时间戳
     *
     * @return 结果
     */
    private static long timeGen() {
        return timeGen(System.currentTimeMillis());
    }

    /**
     * 获取系统时间戳
     *
     * @return 结果
     */
    private static long timeGen(Date date) {
        return timeGen(date.getTime());
    }

    /**
     * 获取系统时间戳
     *
     * @return 结果
     */
    private static long timeGen(long timestamp) {
        return timestamp / 1000L;
    }

    /**
     * 停止直到下一个时间戳
     *
     * @param lastTimestamp 上一个时间戳
     * @return 结果
     */
    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    public static synchronized OrderRandom getNextRandom(Date date, OrderRandom orderRandom) {

        int step = 1;
        long timestamp = timeGen(date);

        if (LAST_TIMESTAMP == timestamp) {
            SEQUENCE = (SEQUENCE + step) & SEQUENCE_MASK;
            if (SEQUENCE == 0) {
                timestamp = tilNextMillis(LAST_TIMESTAMP);
            }
        } else {
            SEQUENCE = 0;
        }

        LAST_TIMESTAMP = timestamp;

        orderRandom.setRandom(SEQUENCE);
        orderRandom.setDate(timestamp == timeGen(date) ? date : new Date(timestamp * 1000L));

        return orderRandom;
    }
}
