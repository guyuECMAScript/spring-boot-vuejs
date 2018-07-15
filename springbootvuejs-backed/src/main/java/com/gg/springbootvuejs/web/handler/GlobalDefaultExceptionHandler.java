package com.gg.springbootvuejs.web.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常捕捉处理器,Controller 增强器 注解@ControllerAdivce 标识当前类为异常处理类,可配置作用域
 * 
 * @author guoxp
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler
        extends ResponseEntityExceptionHandler
{
    private static final Logger logger = LoggerFactory
            .getLogger(GlobalDefaultExceptionHandler.class);


    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
    }


    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * 
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Joker");
    }


    /**
     * @ExceptionHandler 定义需要处理的异常 返回参数有两种，String|Json,需要添加注解 @ResponseBody
     *                   ，或者返回ModelAndview
     * @param request 请求对象
     * @param e 捕获的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandle(HttpServletRequest request,
            Exception e)
    {
        logger.info("catch Exception :\n", e);
        return "对不起，系统繁忙，请稍后再试";
    }


    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandle(HttpServletRequest request,
            Exception e)
    {
        logger.info("catch RuntimeException :\n", e);

        return new ModelAndView("error/500");
    }
}
