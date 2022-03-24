package online.cunho.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.common.BaseRequest;
import online.cunho.blog.common.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @GetMapping("/list")
    public BaseResponse getAllUser(BaseRequest baseRequest) {
        return BaseResponse.valueOfSuccessMessage("asdfsadfsadf");
    }

}
