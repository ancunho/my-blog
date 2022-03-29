package online.cunho.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping(value = "/backend/page/")
public class PageController {

    @RequestMapping("/error_500")
    @ResponseBody
    public String error_500() {
        return "出错， 请联系管理员";
    }

    @GetMapping(value = "/")
    public String page_home(HttpServletRequest request, Model model) {
        return "index";
    }

    @GetMapping(value = "/intro")
    public String page_intro(HttpServletRequest request, Model model) {
        return "intro";
    }

    @GetMapping(value = "/management")
    public String page_admin(HttpServletRequest request, Model model) {
        return "admin_index";
    }

}
