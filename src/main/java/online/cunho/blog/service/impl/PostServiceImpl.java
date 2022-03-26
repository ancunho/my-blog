package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbPostMapper;
import online.cunho.blog.dto.TbPostDto;
import online.cunho.blog.entity.TbPost;
import online.cunho.blog.service.PostService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    @Resource
    private TbPostMapper tbPostMapper;

    @Transactional
    public Boolean insertTbPost(TbPost tbPost) {
        int insertCount = tbPostMapper.insertSelective(tbPost);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbPost(TbPost tbPost) {
        int updateCount = tbPostMapper.updateByPrimaryKeySelective(tbPost);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto) {
        return tbPostMapper.getAllTbPostListByTbPost(tbPostDto);
    }

    public TbPostDto getTbPostByPostId(Integer postId) {
        return tbPostMapper.getTbPostByPostId(postId);
    }


}
