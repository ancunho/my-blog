package online.cunho.blog.service;

import online.cunho.blog.dto.TbFileListDto;
import online.cunho.blog.entity.TbFileList;

import java.util.List;

public interface FileService {

    public Boolean insertTbFileList(TbFileList tbFileList);
    public Boolean updateTbFileList(TbFileList tbFileList);
    public List<TbFileListDto> getAllTbFileList(TbFileListDto tbFileListDto);
    public TbFileListDto getTbFileListInfoByFileId(Integer fileId);
}
