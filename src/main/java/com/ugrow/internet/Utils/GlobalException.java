package com.ugrow.internet.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
        //根据异常做跳转
        if(e instanceof Exception){
            mv.setViewName("error");
        }
        mv.addObject("error",e.toString());
        return mv;
    }
}
