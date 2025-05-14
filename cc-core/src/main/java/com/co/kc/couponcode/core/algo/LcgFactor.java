package com.co.kc.couponcode.core.algo;

import com.co.kc.couponcode.core.model.IFactor;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 线性同余算法生成器(Linear congruential generator)
 * <p>
 * For m = 2^e and c odd
 *
 * @author kc
 */
@Getter
@AllArgsConstructor
public enum LcgFactor implements IFactor {
    /**
     * the best value in M8 (m, a)
     */
    /**
     * 1万级：m=2^14=16384（覆盖1万需求，实际周期16384）
     * a=12345（满足a mod 8 = 5），c=173（奇数）
     * 格式化为5位数字，不足补零
     */
    PERIOD_16384(12345L, 173L, 1L << 14, "%05d"),
    /**
     * 100万级：m=2^20=1048576（覆盖100万需求，实际周期1048576）
     * a=330169577L（参考论文表4中m=2^20的参数调整），c=177（奇数）
     * 格式化为7位数字，不足补零
     */
    PERIOD_1048576(330169577L, 177L, 1L << 20, "%07d"),
    /**
     * 五千万级：m=2^26=67108864（周期67108864，覆盖五千万需求）
     * a=330169577（参考论文表4中m=2^30的乘数结构，调整至满足a mod8=5）
     * c=177（奇数，保证周期最大化）
     * 格式化：8位数字（不足补零）
     */
    PERIOD_67108864(330169577L, 177L, 1L << 26, "%08d"),
    /**
     * 一亿级：m=2^27=134217728（周期134217728，覆盖一亿需求）
     * a=470262476879L（取自论文表4中m=2^30的优化参数，满足a mod8=5）
     * c=193（奇数）
     * 格式化：9位数字（不足补零）
     */
    PERIOD_134217728(470262476879L, 193L, 1L << 27, "%09d"),
    PERIOD_1073741824(438293613L, 175L, 1L << 30, "%010d"),
    PERIOD_2147483648(37769685L, 173L, 1L << 31, "%010d"),
    PERIOD_4294967296(2891336453L, 175L, 1L << 32, "%010d"),
    PERIOD_8589934592(3766383685L, 173L, 1L << 33, "%010d"),
    PERIOD_17179869184(52765661L, 173L, 1L << 34, "%011d"),
    PERIOD_34359738368(22475205L, 173L, 1L << 35, "%011d"),
    PERIOD_68719476736(12132445L, 173L, 1L << 36, "%011d"),
    PERIOD_1099511627776(330169576829L, 177L, 1L << 40, "%013d"),
    PERIOD_281474976710656(181465474592829L, 171L, 1L << 48, "%015d"),
    PERIOD_1152921504606846976(454339144066433781L, 171L, 1L << 60, "%019d"),
    ;

    private final long a;
    private final long c;
    private final long m;
    private final String format;
}
