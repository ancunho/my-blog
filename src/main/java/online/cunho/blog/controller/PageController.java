package online.cunho.blog.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.annotation.PassLogin;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class PageController {

    @PassLogin
    @GetMapping(value = "/login")
    public String page_admin_login(HttpServletRequest request, Model model) {
        return "admin_login";
    }

    @GetMapping(value = "/no_session")
    @PassLogin
    public String page_no_session(HttpServletRequest request, Model model) {
        return "no_session";
    }

    @RequestMapping("/error_500")
    @ResponseBody
    @PassLogin
    public BaseResponse error_500() {
        return BaseResponse.valueOfFailureCodeMessage(ResponseCode.LOGIN_EXPIRED.getCode(),ResponseCode.LOGIN_EXPIRED.getDesc());
    }

    @GetMapping(value = "/")
    @PassLogin
    public String page_home(HttpServletRequest request, Model model) {
        return "index";
    }

    @GetMapping(value = "/intro")
    @PassLogin
    public String page_intro(HttpServletRequest request, Model model) {
        return "intro";
    }

    @GetMapping(value = "/manage")
    @PassLogin
    public String page_admin(HttpServletRequest request, Model model) {
        return "admin_index";
    }

}
