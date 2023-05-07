package usts.pycro.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import usts.pycro.admin.interceptor.LoginInterceptor;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-02 10:22 AM
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer配置类的addInterceptors方法）
 * 3.指定拦截规则【如果拦截所有，静态资源也被拦截】
 * @EnableWebMvc 1.全面接管WebMvc配置
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    //@Override
    //public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //    // 访问"/aa/**"所有请求都去"classpath:/static/"路径下匹配
    //    registry.addResourceHandler("/aa/**")
    //            .addResourceLocations("classpath:/static/");
    //}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有的请求包括静态资源都被拦截
                .excludePathPatterns(
                        "/", "/login", "/css/**", "/fonts/**",
                        "/images/**", "/js/**","/aa/**",
                        "/sql"
                );
    }
}
