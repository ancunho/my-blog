package online.cunho.blog.service;

import online.cunho.blog.dto.TbPostDto;
import online.cunho.blog.entity.TbPost;

import java.util.List;

public interface PostService {

    public Boolean insertTbPost(TbPost tbPost);
    public Boolean updateTbPost(TbPost tbPost);
    public List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto);
    public TbPostDto getTbPostByPostId(Integer postId);

}
