package com.fanhehe.user.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 17:28
 */
public final class OrderUtil {
    public static String makeOrder() {
        OrderRandom orderRandom = OrderRandomUtil.getNextRandom(new Date(), new OrderRandom());
        String nextRandom = String.format("%04d", orderRandom.getRandom());
        String key = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(orderRandom.getDate());
        return key + nextRandom;
    }
}
