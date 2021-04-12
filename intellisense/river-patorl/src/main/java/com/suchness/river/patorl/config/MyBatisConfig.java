package com.suchness.river.patorl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 *  author: rushi
 *  create_time : 2020/11/2511:12
 *******/
@Configuration
@EnableTransactionManagement
@MapperScan({"com.suchness.intellisense.mapper","com.suchness.river.patorl.dao"})
public class MyBatisConfig {
}
