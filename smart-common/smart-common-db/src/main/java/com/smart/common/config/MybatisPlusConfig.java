package com.smart.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//com.smart.order.mapper
//com.smart.member.mapper

/**
 * 扫描所有的mapper接口
 */
@Configuration
@MapperScan("com.smart.**.mapper")
public class MybatisPlusConfig {
    /**
     * 1. 核心插件
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor plusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor, OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor) {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        /**
         * 注册分页
         */
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        // 注册乐观锁
        mybatisPlusInterceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
        return mybatisPlusInterceptor;

    }

    /**
     * 分页插件注册
     *
     * @return
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置分页插件最大的返回条数
        paginationInnerInterceptor.setMaxLimit(100L);
        //溢出总页数后是否进行处理  默认是false 不处理 抛异常
        paginationInnerInterceptor.setOverflow(true);
        return paginationInnerInterceptor;
    }

    /**
     * 乐观锁插件注册
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }
}
