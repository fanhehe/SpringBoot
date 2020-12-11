package com.fanhehe.user.business.doll.wave.pojo.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 16:43
 */
public final class WaveConfig {
    /**
     * 电波最长有效时间为30 * 60s
     */
    public static final int WAVE_VALID_TIME = 30 * 60;

    /**
     * 电波最多人均最多5次
     */
    public static final int WAVE_DAILY_PERSONAL_LIMIT = 5;

    /**
     * 两个电波间，至少隔多少秒
     */
    public static final int WAVE_CYCLE_BETWEEN = 4 * 60 * 60;

    /**
     * 随机电波，出现电波的概率为1.5%
     */
    public static final double WAVE_CYCLE_RATIO = 50;

    /**
     * 电波间隔为10s
     */
    public static final long WAVE_CYCLE_BETWEEN_MILLISECOND = 10 * 1000L;

    /**
     * 高能电波，每天每人最多两次
     */
    public static final long WAVE_HIGH_WAVE_LIMIT = 2;

    /**
     * 每次开启高能电波，所需要的能量数量
     */
    public static final int WAVE_HIGH_ENERGY_AMOUNT = 300;

    /**
     * 高能电波，最多在接下来多少秒出现
     */
    public static final int WAVE_HIGH_ENERGY_SHOW = 60;

    /**
     * 高能电波记录最多在5分钟内可以兑换为电波
     */
    public static final long WAVE_HIGH_ENERGY_ALIVE = 5 * 60 * 1000L;

    /**
     * 高能电波，最少隔5秒才能再试召唤
     */
    public static final long WAVE_HIGH_ENERGY_LAST_ALIVE = 5 * 1000L;

    /**
     * 隐藏电波出现的商品的level
     */
    public static final int WAVE_HIDDEN_LEVEL = 10;

    /**
     * 邀请新人，相当于三个人
     */
    public static final int WAVE_INVITE_NEW = 3;
    /**
     * 邀请老人，相当于1个人
     */
    public static final int WAVE_INVITE_OLD = 1;

    public static final List<Long> WAVE_SPECIAL_TIME = new ArrayList<>();

    static {
        WAVE_SPECIAL_TIME.add(30 * 60 * 1000L);
        WAVE_SPECIAL_TIME.add(9 * 60 * 60 * 1000L);
        WAVE_SPECIAL_TIME.add(12 * 60 * 60 * 1000L);
    }

    /**
     * WAVE_SPECIAL_TIME内，3 分钟之内必出电波
     */
    public static final long WAVE_NEAR_SPECIAL_TIME_MILLISECONDS = 3 * 60 * 1000L;

    /**
     * 邀请一个老人相当于100能量
     */
    public static final int WAVE_INVITE_OLD_TO_ENERGY = 100;

    /**
     * 一小时的毫秒数
     */
    public static final long ONE_HOUR = 60 * 60 * 1000L;

    /**
     * 一秒的毫秒数
     */
    public static final long ONE_SECOND = 1000L;
}
