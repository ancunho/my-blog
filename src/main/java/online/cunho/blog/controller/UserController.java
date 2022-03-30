package online.cunho.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.annotation.PassLogin;
import online.cunho.blog.common.BaseRequest;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.SysUserDto;
import online.cunho.blog.service.RoleMenuService;
import online.cunho.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/backend/user")
public class UserController {

    @Autowired
    private RoleMenuService roleMenuService;

    @GetMapping("/list")
    public BaseResponse getAllUser(BaseRequest baseRequest) {
        return BaseResponse.valueOfSuccessMessage("asdfsadfsadf");
    }

    @PassLogin
    @PostMapping(value = "/login")
    public BaseResponse api_login(BaseRequest baseRequest, HttpServletRequest request, @RequestBody SysUserDto sysUserDto) {
        HttpSession session = request.getSession();
        if(sysUserDto == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        sysUserDto.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
        SysUserDto loginUser = roleMenuService.getSysUserByUsernameAndPassword(sysUserDto);
        if (loginUser != null) {
            request.getSession(true).setAttribute("LOGIN_USER", loginUser);
            return BaseResponse.valueOfSuccess(sysUserDto);
        }
        return BaseResponse.valueOfFailureMessage("登录失败，请确认用户密码");
    }

}
