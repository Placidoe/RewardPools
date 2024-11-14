package com.exploreX.domain.sign.service.impl;

import com.exploreX.domain.sign.service.SignService;
import com.exploreX.domain.user.model.UserInfo;
import com.exploreX.types.common.SignConstans;
import com.exploreX.types.model.pojo.Result;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午7:03
 **/
public class SignServiceImpl implements SignService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Override
    public Result sign(HttpServletRequest request) {
        //1：获取当前登录用户签到信息id
        String sessionId = request.getHeader("authorization");
        UserInfo userInfo =(UserInfo) redisTemplate.opsForValue().get(SignConstans.SIGN_KEY + sessionId);
        String signId = userInfo.getSignId();
        //2：获取当前日期。
        LocalDateTime now = LocalDateTime.now();
        //2.1获取当前日期中的  年和月
        String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
        //3：拼接key
        String key = SignConstans.SIGN_COUNT_KEY + signId + keySuffix;
        //4：获取今天是当月的第几天
        int dayOfMonth = now.getDayOfMonth();
        redisTemplate.opsForValue().setBit(key, dayOfMonth-1,true);
        return Result.success();
    }

    @Override
    public Result signCount(HttpServletRequest request) {
        //1：获取当前登录用户签到信息id
        String sessionId = request.getHeader("authorization");
        UserInfo userInfo =(UserInfo) redisTemplate.opsForValue().get(SignConstans.SIGN_KEY + sessionId);
        String signId = userInfo.getSignId();
        //2：获取当前日期。
        LocalDateTime now = LocalDateTime.now();
        //2.1获取当前日期中的  年和月
        String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
        //3：拼接key
        String key = SignConstans.SIGN_COUNT_KEY + signId + keySuffix;
        // 4.获取今天是本月的第几天
        int dayOfMonth = now.getDayOfMonth();
        // 5.获取本月截止今天为止的所有的签到记录，返回的是一个十进制的数字 BITFIELD sign:5:202203 GET u14 0
        List<Long> result = redisTemplate.opsForValue().bitField(
                key,
                BitFieldSubCommands.create()
                        .get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth)).valueAt(0)
        );
        if (result == null || result.isEmpty()) {
            // 没有任何签到结果
            return Result.success(0);
        }
        Long num = result.get(0);
        if (num == null || num == 0) {
            return Result.success(0);
        }
        // 6.循环遍历
        int count = 0;
        while (true) {
            // 6.1.让这个数字与1做与运算，得到数字的最后一个bit位  // 判断这个bit位是否为0
            if ((num & 1) == 0) {
                // 如果为0，说明未签到，结束
                break;
            }else {
                // 如果不为0，说明已签到，计数器+1
                count++;
            }
            // 把数字右移一位，抛弃最后一个bit位，继续下一个bit位
            num >>>= 1;
        }
        return Result.success(count);
    }

    @Override
    public Result signCountReward() {
        //查询满足天数的礼包
        //TODO 用zset来记录礼包 , key-礼包 value-天数 score-礼包id
        //

        //返回礼包列表
        return null;
    }
}
