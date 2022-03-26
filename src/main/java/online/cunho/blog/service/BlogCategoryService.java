package online.cunho.blog.service;

import online.cunho.blog.dto.TbBlogCategoryDto;
import online.cunho.blog.entity.TbBlogCategory;

import java.util.List;
import java.util.Map;

public interface BlogCategoryService {

    public Boolean insertTbBlogCategory(TbBlogCategory tbBlogCategory);
    public Boolean updateTbBlogCategory(TbBlogCategory tbBlogCategory);
    public List<TbBlogCategoryDto> getAllTbBlogCategoryByTbBlogCategory(TbBlogCategoryDto tbBlogCategoryDto);
    public List<Map<String, Object>> lstDepthCategory(TbBlogCategoryDto tbBlogCategoryDto);

}
