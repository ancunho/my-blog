package online.cunho.blog.dao;

import online.cunho.blog.dto.TbFileListDto;
import online.cunho.blog.entity.TbFileList;

import java.util.List;

public interface TbFileListMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(TbFileList record);

    int insertSelective(TbFileList record);

    TbFileList selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(TbFileList record);

    int updateByPrimaryKey(TbFileList record);

    List<TbFileListDto> getAllTbFileList(TbFileListDto tbFileListDto);

    TbFileListDto getTbFileListInfoByFileId(Integer fileId);
}