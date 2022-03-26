package online.cunho.blog.service.impl;

import online.cunho.blog.dao.*;
import online.cunho.blog.dto.*;
import online.cunho.blog.entity.*;
import online.cunho.blog.service.SkuService;
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
public class SkuServiceImpl implements SkuService {

    @Resource
    private TbSpuMapper tbSpuMapper;

    @Resource
    private TbSpuAttributeMapper tbSpuAttributeMapper;

    @Resource
    private TbAttributeMapper tbAttributeMapper;

    @Resource
    private TbAttributeValueMapper tbAttributeValueMapper;

    @Resource
    private TbSkuMapper tbSkuMapper;

    @Resource
    private TbClassificationMapper tbClassificationMapper;

    @Resource
    private TbSkuAttributeMapper tbSkuAttributeMapper;

    @Resource
    private TbBrandMapper tbBrandMapper;

    public List<TbSpuDto> lstTbSpu(TbSpuDto tbSpuDto) {
        return tbSpuMapper.lstTbSpu(tbSpuDto);
    }

    public TbSpuDto getTbSpuInfoBySpuId(Integer spuId) {
        return tbSpuMapper.getTbSpuInfoBySpuId(spuId);
    }

    @Transactional
    public Boolean insertTbSpu(TbSpu tbSpu) {
        int insertCount = tbSpuMapper.insertSelective(tbSpu);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbSpu(TbSpu tbSpu) {
        int updateCount = tbSpuMapper.updateByPrimaryKeySelective(tbSpu);
        return updateCount > 0;
    }

    public List<TbSkuDto> lstTbSku(TbSkuDto tbSkuDto) {
        return tbSkuMapper.lstTbSku(tbSkuDto);
    }

    public TbSkuDto getTbSkuInfoBySkuId(Integer skuId) {
        return tbSkuMapper.getTbSkuInfoBySkuId(skuId);
    }

    public List<TbSkuDto> lstTbSkuBySpuId(Integer spuId) {
        return tbSkuMapper.lstTbSkuBySpuId(spuId);
    }

    @Transactional
    public Boolean insertTbSku(TbSku tbSku) {
        int insertCount = tbSkuMapper.insertSelective(tbSku);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbSku(TbSku tbSku) {
        int updateCount = tbSkuMapper.updateByPrimaryKeySelective(tbSku);
        return updateCount > 0;
    }

    public List<TbSpuAttributeDto> lstTbSpuAttribute(TbSpuAttributeDto tbSpuAttributeDto) {
        return tbSpuAttributeMapper.lstTbSpuAttribute(tbSpuAttributeDto);
    }

    public TbSpuAttributeDto getTbSpuAttributeInfoBySpuAttrId(Integer spuAttrId) {
        return tbSpuAttributeMapper.getTbSpuAttributeInfoBySpuAttrId(spuAttrId);
    }

    public List<TbSpuAttributeDto> lstTbSpuAttributeBySpuId(Integer spuId) {
        return tbSpuAttributeMapper.lstTbSpuAttributeBySpuId(spuId);
    }

    public List<TbSpuAttributeDto> lstTbSpuAttributeByAttrId(Integer attrId) {
        return tbSpuAttributeMapper.lstTbSpuAttributeByAttrId(attrId);
    }

    @Transactional
    public Boolean insertTbSpuAttribute(TbSpuAttribute tbSpuAttribute) {
        int insertCount = tbSpuAttributeMapper.insertSelective(tbSpuAttribute);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbSpuAttribute(TbSpuAttribute tbSpuAttribute) {
        int updateCount = tbSpuAttributeMapper.updateByPrimaryKeySelective(tbSpuAttribute);
        return updateCount > 0;
    }

    public List<TbSkuAttributeDto> lstTbSkuAttribute(TbSkuAttributeDto tbSkuAttributeDto) {
        return tbSkuAttributeMapper.lstTbSkuAttribute(tbSkuAttributeDto);
    }

    public TbSkuAttributeDto getTbSkuAttributeBySkuAttrId(Integer skuAttrId) {
        return tbSkuAttributeMapper.getTbSkuAttributeBySkuAttrId(skuAttrId);
    }

    public List<TbSkuAttributeDto> lstTbSkuAttributeBySkuId(Integer skuId) {
        return tbSkuAttributeMapper.lstTbSkuAttributeBySkuId(skuId);
    }

    public List<TbSkuAttributeDto> lstTbSkuAttributeByAttrValueId(Integer attrValueId) {
        return tbSkuAttributeMapper.lstTbSkuAttributeBySkuId(attrValueId);
    }

    @Transactional
    public Boolean insertTbSkuAttribute(TbSkuAttribute tbSkuAttribute) {
        int insertCount = tbSkuAttributeMapper.insertSelective(tbSkuAttribute);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbSkuAttribute(TbSkuAttribute tbSkuAttribute) {
        int updateCount = tbSkuAttributeMapper.updateByPrimaryKeySelective(tbSkuAttribute);
        return updateCount > 0;
    }

    @Transactional
    public Boolean deleteTbSkuAttributeBySkuId(Integer skuId) {
        int deleteCount = tbSkuAttributeMapper.deleteTbSkuAttributeBySkuId(skuId);
        return deleteCount > 0;
    }

    public List<TbAttributeDto> lstTbAttribute(TbAttributeDto tbAttributeDto) {
        return tbAttributeMapper.lstTbAttribute(tbAttributeDto);
    }

    public List<Map<String, Object>> lstTbAttributeType2(TbAttributeDto tbAttributeDto) {
        return tbAttributeMapper.lstTbAttributeType2(tbAttributeDto);
    }

    public TbAttributeDto getTbAttributeInfoByAttrId(Integer attrId) {
        return tbAttributeMapper.getTbAttributeInfoByAttrId(attrId);
    }

    @Transactional
    public Boolean insertTbAttribute(TbAttribute tbAttribute) {
        int insertCount = tbAttributeMapper.insertSelective(tbAttribute);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbAttribute(TbAttribute tbAttribute) {
        int updateCount = tbAttributeMapper.updateByPrimaryKeySelective(tbAttribute);
        return updateCount > 0;
    }

    public List<TbAttributeValueDto> lstTbAttributeValue(TbAttributeValueDto tbAttributeValueDto) {
        return tbAttributeValueMapper.lstTbAttributeValue(tbAttributeValueDto);
    }

    public List<TbAttributeValueDto> lstTbAttributeValueByAttrId(TbAttributeValueDto tbAttributeValueDto) {
        return tbAttributeValueMapper.lstTbAttributeValueByAttrId(tbAttributeValueDto);
    }

    public TbAttributeValueDto getTbAttributeValueInfoByAttrValueId(Integer attrValueId) {
        return tbAttributeValueMapper.getTbAttributeValueInfoByAttrValueId(attrValueId);
    }

    @Transactional
    public Boolean insertTbAttributeValue(TbAttributeValue tbAttributeValue) {
        int insertCount = tbAttributeValueMapper.insertSelective(tbAttributeValue);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbAttributeValue(TbAttributeValue tbAttributeValue) {
        int updateCount = tbAttributeValueMapper.updateByPrimaryKeySelective(tbAttributeValue);
        return updateCount > 0;
    }

    @Transactional
    public Boolean deleteTbAttributeValueByAttrValueId(Integer attrValueId) {
        int deleteCount = tbAttributeValueMapper.deleteByPrimaryKey(attrValueId);
        return deleteCount > 0;
    }

    public List<TbClassificationDto> lstTbClassification(TbClassificationDto tbClassificationDto) {
        return tbClassificationMapper.lstTbClassification(tbClassificationDto);
    }

    public TbClassificationDto getTbClassificationInfoByClassificationId(Integer classificationId) {
        return tbClassificationMapper.getTbClassificationInfoByClassificationId(classificationId);
    }

    public List<TbClassificationDto> getTbClassificationInfoByParentClassificationId(Integer parentClassificationId) {
        return tbClassificationMapper.lstTbClassificationByParentClassificationId(parentClassificationId);
    }

    @Transactional
    public Boolean insertTbClassification(TbClassification tbClassification) {
        int insertCount = tbClassificationMapper.insertSelective(tbClassification);
        return insertCount > 0;
    }

    @Transactional
    public Boolean updateTbClassification(TbClassification tbClassification) {
        int updateCount = tbClassificationMapper.updateByPrimaryKeySelective(tbClassification);
        return updateCount > 0;
    }
}
