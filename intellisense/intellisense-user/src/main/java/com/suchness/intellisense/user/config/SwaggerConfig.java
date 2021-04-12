package com.suchness.intellisense.user.config;

import com.suchness.intellisense.common.config.BaseSwaggerConfig;
import com.suchness.intellisense.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.suchness.intellisense.user")
                .title("数据采集与分析后台系统")
                .description("后台相关接口文档")
                .contactName("suchness")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
