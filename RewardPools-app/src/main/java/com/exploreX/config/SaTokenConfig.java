//package com.exploreX.config;
//
//import cn.dev33.satoken.interceptor.SaInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class SaTokenConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SaInterceptor(handle -> {
//            // 放行登录接口
//            SaRouter.match("/login", () -> {
//                // 放行
//            });
//
//            // 检查其他接口是否已登录
//            if (StpUtil.isLogin()) {
//                // 已登录，放行
//            } else {
//                // 未登录，返回错误信息
//                handle.error("未登录");
//            }
//        })).addPathPatterns("/**");
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        // 可以在这里添加自定义的参数解析器
//    }
//}