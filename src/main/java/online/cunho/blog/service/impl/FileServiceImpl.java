package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbFileListMapper;
import online.cunho.blog.dto.TbFileListDto;
import online.cunho.blog.entity.TbFileList;
import online.cunho.blog.service.FileService;
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
public class FileServiceImpl implements FileService {

    @Resource
    private TbFileListMapper tbFileListMapper;

    @Transactional
    public Boolean insertTbFileList(TbFileList tbFileList) {
        int insertCount = tbFileListMapper.insertSelective(tbFileList);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbFileList(TbFileList tbFileList) {
        int updateCount = tbFileListMapper.updateByPrimaryKeySelective(tbFileList);
        return updateCount > 0;
    }

    public List<TbFileListDto> getAllTbFileList(TbFileListDto tbFileListDto) {
        return tbFileListMapper.getAllTbFileList(tbFileListDto);
    }

    public TbFileListDto getTbFileListInfoByFileId(Integer fileId) {
        return tbFileListMapper.getTbFileListInfoByFileId(fileId);
    }


}
