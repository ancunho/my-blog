package online.cunho.blog.controller.backend;

import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/api/seckill")
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @RequestMapping("/info")
    public BaseResponse selectByPrimaryKey() {
        return BaseResponse.valueOfSuccess(seckillService.selectByPrimaryKey(1000L));
    }

}
