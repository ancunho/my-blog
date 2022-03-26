package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbCommonCodeMapper;
import online.cunho.blog.dto.TbCommonCodeDto;
import online.cunho.blog.entity.TbCommonCode;
import online.cunho.blog.service.CommonService;
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
public class CommonServiceImpl implements CommonService {

    @Resource
    private TbCommonCodeMapper tbCommonCodeMapper;

    @Transactional
    public Boolean insertTbCommonCode(TbCommonCode tbCommonCode) {
        int insertCount = tbCommonCodeMapper.insertSelective(tbCommonCode);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbCommonCode(TbCommonCode tbCommonCode) {
        int updateCount = tbCommonCodeMapper.updateByPrimaryKeySelective(tbCommonCode);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbCommonCodeDto> getAllTbCommonCodeList() {
        return tbCommonCodeMapper.getAllTbCommonCodeList();
    }

    public TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId) {
        return tbCommonCodeMapper.getTbCommonCodeInfoByCodeId(codeId);
    }

    public List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType) {
        return tbCommonCodeMapper.lstTbCommonCodeByCodeType(codeType);
    }



}
