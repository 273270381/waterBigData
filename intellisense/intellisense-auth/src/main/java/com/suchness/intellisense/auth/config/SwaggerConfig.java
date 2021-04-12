package com.suchness.intellisense.auth.config;

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
                .apiBasePackage("com.suchness.intellisense.auth.controller")
                .title("认证中心")
                .description("认证中心相关接口文档")
                .contactName("rushi")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
