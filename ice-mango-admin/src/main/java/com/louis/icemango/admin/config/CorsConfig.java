package com.louis.icemango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 问题记录：
     *    此处“允许跨域访问的源”使用的  ".allowedOrigins",
     *    启动报错：
     *    org.springframework.beans.factory.BeanCreationException:
     *    Error creating bean with name 'requestMappingHandlerMapping'
     *    defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: When allowCredentials is true, allowedOrigins cannot contain the special value "*"since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
     *
     *    修改为“.allowedOriginPatterns后正常”，
     *    原因为前者不能包含特殊字符 “*”
     */

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  //允许跨域访问的路径
                .allowedOriginPatterns("*")   //允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")  //允许请求方法
                .maxAge(168000)  //预检间隔时间
                .allowedHeaders("*")   //允许头部设置
                .allowCredentials(true);   //是否发送cookie
    }
}
