package com.co.kc.couponcode.provider.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.co.kc.couponcode.provider.repository.entities.CouponCodeEntity;
import com.co.kc.couponcode.provider.repository.entities.CouponCodeGenerator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author kc
 */
@Mapper
public interface CouponCodeMapper extends BaseMapper<CouponCodeEntity> {
}
