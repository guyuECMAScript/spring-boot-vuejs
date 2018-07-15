package com.gg.springbootvuejs.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 等于 @Controller @ResponseBody的混合体，可以这样理解）
 * Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
 * 如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
 *
 * @author guoxp
 */
@RestController
@RequestMapping(value = "/api")
public class HelloController extends BaseController {
    private static final Logger logger  = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("test")
    public String hello() {
        return "success";
    }

    @RequestMapping("index")
    public ModelAndView iudex() {
        return new ModelAndView("index.html");
    }
}
