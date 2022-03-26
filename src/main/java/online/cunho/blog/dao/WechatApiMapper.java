package online.cunho.blog.dao;

import online.cunho.blog.dto.WechatGoodsDto;

import java.util.List;

public interface WechatApiMapper {

    List<WechatGoodsDto> getAllWechatGoods();

}
