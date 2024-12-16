package com.exploreX.config;

import com.exploreX.trigger.apis.hotPool.service.HotPoolService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/12/16 下午4:53
 **/
@Configuration
public class HotPoolConfig {
    @Bean
    public HotPoolService hotPool() {
        return new HotPoolService(50);
    }
}
