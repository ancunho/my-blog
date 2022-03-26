package online.cunho.blog.dao;

import online.cunho.blog.dto.TbBlogCategoryDto;
import online.cunho.blog.entity.TbBlogCategory;

import java.util.List;
import java.util.Map;

public interface TbBlogCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(TbBlogCategory record);

    int insertSelective(TbBlogCategory record);

    TbBlogCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(TbBlogCategory record);

    int updateByPrimaryKey(TbBlogCategory record);

    List<TbBlogCategoryDto> getAllTbBlogCategoryByTbBlogCategory(TbBlogCategoryDto tbBlogCategoryDto);

    List<Map<String, Object>> lstDepthCategory(TbBlogCategoryDto tbBlogCategoryDto);
}