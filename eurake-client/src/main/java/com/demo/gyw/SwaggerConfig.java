package com.demo.gyw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * 访问网址：http://ip:端口/api
 */
@Configuration
@EnableSwagger2 //使swagger生效
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Value("${swagger.basePackage:com.yizhiyixing.controller}")
    private String basePackage;

    @Value("${swagger.title:feign-demo}")
    private String title;

    @Value("${swagger.description:v1.0}")
    private String description;

    @Value("${swagger.contact:v1.0}")
    private String contact;

    @Value("${swagger.version:1}")
    private String version;

    /**
     * 函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
     * 并且对所有路径进行监控
     * @return
     */
    @Bean
    public Docket createRedisApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build();
    }

    /**
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * title // 大标题
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title)
                .description(description).contact(contact).version(version).build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs");
        // 添加api url
        registry.addRedirectViewController("/api", "/swagger-ui.html");
    }
}