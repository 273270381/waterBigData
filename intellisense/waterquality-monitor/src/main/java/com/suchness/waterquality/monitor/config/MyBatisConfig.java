package com.suchness.waterquality.monitor.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 *  author: rushi
 *  create_time : 2020/11/2511:12
 *******/
@Configuration
@EnableTransactionManagement
@MapperScan({"com.suchness.intellisense.mapper","com.suchness.waterquality.monitor.dao"})
public class MyBatisConfig {
}
