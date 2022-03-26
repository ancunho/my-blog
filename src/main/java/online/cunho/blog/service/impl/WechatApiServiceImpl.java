package online.cunho.blog.service.impl;

import online.cunho.blog.dao.WechatApiMapper;
import online.cunho.blog.dto.WechatGoodsDto;
import online.cunho.blog.service.WechatApiService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class WechatApiServiceImpl implements WechatApiService {

    @Resource
    private WechatApiMapper wechatApiMapper;

    public List<WechatGoodsDto> getAllWechatGoods() {
        return wechatApiMapper.getAllWechatGoods();
    }
}
