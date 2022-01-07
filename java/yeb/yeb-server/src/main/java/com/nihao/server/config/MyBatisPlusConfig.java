package com.nihao.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis分页配置
 *
 * @author chenziran
 * @since 2022/1/6
 */
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInnerInterceptor(){
        return new PaginationInterceptor();
    }

}
