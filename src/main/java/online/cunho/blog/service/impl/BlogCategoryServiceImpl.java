package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbBlogCategoryMapper;
import online.cunho.blog.dto.TbBlogCategoryDto;
import online.cunho.blog.entity.TbBlogCategory;
import online.cunho.blog.service.BlogCategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Resource
    private TbBlogCategoryMapper tbBlogCategoryMapper;

    @Transactional
    public Boolean insertTbBlogCategory(TbBlogCategory tbBlogCategory) {
        int insertCount = tbBlogCategoryMapper.insertSelective(tbBlogCategory);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbBlogCategory(TbBlogCategory tbBlogCategory) {
        int updateCount = tbBlogCategoryMapper.updateByPrimaryKeySelective(tbBlogCategory);
        return updateCount > 0;
    }

    public List<TbBlogCategoryDto> getAllTbBlogCategoryByTbBlogCategory(TbBlogCategoryDto tbBlogCategoryDto) {
        return tbBlogCategoryMapper.getAllTbBlogCategoryByTbBlogCategory(tbBlogCategoryDto);
    }

    public List<Map<String, Object>> lstDepthCategory(TbBlogCategoryDto tbBlogCategoryDto) {
        return tbBlogCategoryMapper.lstDepthCategory(tbBlogCategoryDto);
    }
}
