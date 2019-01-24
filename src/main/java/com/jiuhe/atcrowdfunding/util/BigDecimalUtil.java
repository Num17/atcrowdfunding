package com.jiuhe.atcrowdfunding.util;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BigDecimalUtil {

    private static final int DEFAULT_SCALE = 2;
    private static final int DEFAULT_ROUNG = BigDecimal.ROUND_HALF_UP;//四舍五入向上取整

    public static BigDecimal valueOf(@NotNull Double value) {
        return BigDecimal.valueOf(value);
    }

    /**
     * 加法
     *
     * @param addend 加数
     * @param augend 被加数
     * @return 和
     */
    public static Double add(Double addend, Double augend) {
        return add(addend, augend, DEFAULT_SCALE);
    }

    /**
     * 加法
     *
     * @param addend 加数
     * @param augend 被加数
     * @param scale  精度
     * @return 和
     */
    public static Double add(Double addend, Double augend, int scale) {
        return valueOf(addend).add(valueOf(augend)).setScale(scale, DEFAULT_ROUNG).doubleValue();
    }

    /**
     * 减法
     *
     * @param minuend   被减数
     * @param reduction 减数
     * @return 差
     */
    public static Double subtract(Double minuend, Double reduction) {
        return subtract(minuend, reduction, DEFAULT_SCALE);
    }

    /**
     * 减法
     *
     * @param minuend   被减数
     * @param reduction 减数
     * @param scale     精度
     * @return 差
     */
    public static Double subtract(Double minuend, Double reduction, int scale) {
        return valueOf(minuend).subtract(valueOf(reduction)).setScale(scale, DEFAULT_ROUNG).doubleValue();
    }

    /**
     * 乘法
     *
     * @param multiplier   乘数
     * @param multiplicand 被乘数
     * @return 积
     */
    public static Double multiply(Double multiplier, Double multiplicand) {
        return multiply(multiplier, multiplicand, DEFAULT_SCALE);
    }

    /**
     * 乘法
     *
     * @param multiplier   乘数
     * @param multiplicand 被乘数
     * @param scale        精度
     * @return 积
     */
    public static Double multiply(Double multiplier, Double multiplicand, int scale) {
        return valueOf(multiplier).multiply(valueOf(multiplicand)).setScale(scale, DEFAULT_ROUNG).doubleValue();
    }

    /**
     * 除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 余
     */
    public static Double divide(Double dividend, Double divisor) {
        return divide(dividend, divisor, DEFAULT_SCALE);
    }

    /**
     * 除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    精度
     * @return 余
     */
    public static Double divide(Double dividend, Double divisor, int scale) {
        return valueOf(dividend).divide(valueOf(divisor), scale, DEFAULT_ROUNG).doubleValue();
    }

}
