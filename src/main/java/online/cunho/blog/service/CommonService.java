package online.cunho.blog.service;

import online.cunho.blog.dto.TbCommonCodeDto;
import online.cunho.blog.entity.TbAccessHist;
import online.cunho.blog.entity.TbCommonCode;

import java.util.List;

public interface CommonService {

    public void insertTbAccessHist(TbAccessHist tbAccessHist);

    public Boolean insertTbCommonCode(TbCommonCode tbCommonCode);
    public Boolean updateTbCommonCode(TbCommonCode tbCommonCode);
    public List<TbCommonCodeDto> getAllTbCommonCodeList();
    public TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId);
    public List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType);

}
