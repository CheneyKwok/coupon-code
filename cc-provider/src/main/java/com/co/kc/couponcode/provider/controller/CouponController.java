package com.co.kc.couponcode.provider.controller;

import com.co.kc.couponcode.core.CouponCodePool;
import com.co.kc.couponcode.provider.model.Result;
import com.co.kc.couponcode.provider.repository.CouponCodeService;
import com.co.kc.couponcode.provider.repository.entities.CouponCodeEntity;
import com.co.kc.couponcode.provider.repository.mapper.CouponCodeMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author kc
 */
@RestController
@Api(tags = "券码路由")
@RequestMapping(value = "/coupon")
public class CouponController {

    @Autowired
    private CouponCodePool couponCodePool;

    @Autowired
    private CouponCodeService couponCodeService;

    @ApiOperation(value = "生成券码")
    @GetMapping(value = "/v1/code/next")
    public Result<String> next() {
        try {
            int cap = 10000 * 10000;
//            Set<String> set = new HashSet<>(cap);
            System.out.println("开始生成券码");
            List<CouponCodeEntity> couponCodeEntities = new ArrayList<>(10000);
            for (int i = 0; i < cap; i++) {
                CouponCodeEntity couponCodeEntity = new CouponCodeEntity();
                long start = System.currentTimeMillis();
                if ((System.currentTimeMillis() - start) > 2000) {
                    System.out.println("5000条数据保存耗时：" + (System.currentTimeMillis() - start));
                }
                String code = couponCodePool.next();
                couponCodeEntity.setCouponCode(code);
                couponCodeEntities.add(couponCodeEntity);
                // 5000 一批提交
                if (couponCodeEntities.size() >= 10000) {
//                    long start = System.currentTimeMillis();
                    couponCodeService.saveBatch(couponCodeEntities, 10000);
//                    System.out.println("5000条数据保存耗时：" + (System.currentTimeMillis() - start));
                    couponCodeEntities = new ArrayList<>(10000);
                }
            }
            // 输出 20 个样例
//            int count = 1;
//            Iterator<String> iterator = set.iterator();
//            while (iterator.hasNext() && count <= 20) {
//                count++;
//                System.out.println(iterator.next());
//            }

            System.out.println("生成券码结束");
            return Result.success("ok");
        } catch (InterruptedException e) {
            return Result.error();
        }
    }
}
