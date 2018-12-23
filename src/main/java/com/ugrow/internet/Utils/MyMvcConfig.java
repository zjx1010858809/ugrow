package com.ugrow.internet.Utils;

import com.ugrow.internet.Component.LoginHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyMvcConfig.class);
    @Autowired
    LoginHandlerInterceptor  interceptor;
    @Value("${web.upload.path}")
    private String uploadPath;
    @Value("${ueditor.path}")
    private String ueditorPath;
    @Value("${web.fileupload.path}")
    private String fileUploadPath;
    @Value("${web.sorftupload.path}")
    private String sorftUploadPath;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor=registry.addInterceptor(interceptor);
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/static/**");
        addInterceptor.excludePathPatterns("/userLogin");
        addInterceptor.excludePathPatterns("/front/**");
        addInterceptor.excludePathPatterns("/image/**");
        addInterceptor.excludePathPatterns(getPath(fileUploadPath)+"**");
        addInterceptor.excludePathPatterns("/ueditor/**");
        addInterceptor.excludePathPatterns(getPath(sorftUploadPath)+"**");
    }
    @Override
    //
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations(
                "file:"+uploadPath);
        registry.addResourceHandler("/ueditor/**").addResourceLocations(
                "file:"+ueditorPath);
        registry.addResourceHandler(getPath(fileUploadPath)+"**").addResourceLocations(
                "file:"+fileUploadPath);
        registry.addResourceHandler(getPath(sorftUploadPath)+"**").addResourceLocations(
                "file:"+sorftUploadPath);
        String[] urls = {"classpath:/META-INF/resources/","classpath:/static/"};
        registry.addResourceHandler("/static/**").addResourceLocations(urls);
        LOGGER.info("自定义静态资源目录、此处功能用于文件映射");
        LOGGER.info("自定义静态资源目录、"+getPath(fileUploadPath));
    }
    private static  String getPath(String path){
        String[] arr;
        arr=path.split(":");
        return arr[1];
    }
}
