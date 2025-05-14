package com.co.kc.couponcode.provider.repository.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.co.kc.couponcode.provider.repository.enums.CouponCodeGeneratorStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@TableName("coupon_code")
public class CouponCodeEntity{

    @TableId(value = "coupon_code_id", type = IdType.AUTO)
    private Long couponCodeId;

    @TableField(value = "coupon_code")
    private String couponCode;

}
