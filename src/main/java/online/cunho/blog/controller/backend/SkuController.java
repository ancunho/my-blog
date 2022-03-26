package online.cunho.blog.controller.backend;

import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.*;
import online.cunho.blog.entity.*;
import online.cunho.blog.service.SkuService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /********************************************************************
     * SPU
     ***************************************************************** */

    @PostMapping(value = "/spu/list")
    public BaseResponse lstTbSpuDto(BaseRequest baseRequest, @RequestBody TbSpuDto tbSpuDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSpuDto> returnData = skuService.lstTbSpu(tbSpuDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/spu/info")
    public BaseResponse getTbSpuInfoBySpuId(BaseRequest baseRequest, @RequestParam("spuId") Integer spuId) {
        if (spuId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbSpuDto tbSpuDto = skuService.getTbSpuInfoBySpuId(spuId);
        return BaseResponse.valueOfSuccess(tbSpuDto);
    }

    @PostMapping(value = "/spu/proc")
    public BaseResponse procTB_SPU(BaseRequest baseRequest, @RequestBody TbSpuDto tbSpuDto) {
        if (StringUtils.isEmpty(tbSpuDto.getSpuName())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbSpuDto.getSpuId() == null || "".equals(String.valueOf(tbSpuDto.getSpuId()))) {
                // insert new
                TbSpu tbSpu = new TbSpu();
                tbSpu.setClassificationId(tbSpuDto.getDepth01Id());
                tbSpu.setDepth01Id(tbSpuDto.getDepth01Id());
                tbSpu.setDepth02Id(tbSpuDto.getDepth02Id());
                tbSpu.setDepth03Id(tbSpuDto.getDepth03Id());
                tbSpu.setDepth01Name(tbSpuDto.getDepth01Name());
                tbSpu.setDepth02Name(tbSpuDto.getDepth02Name());
                tbSpu.setDepth03Name(tbSpuDto.getDepth03Name());
                tbSpu.setBrandId(tbSpuDto.getBrandId());
                tbSpu.setSpuName(tbSpuDto.getSpuName());
                tbSpu.setSpuType(tbSpuDto.getSpuType());
                tbSpu.setStatus(tbSpuDto.getStatus());
                tbSpu.setMainImage01(tbSpuDto.getMainImage01());
                tbSpu.setMainImage02(tbSpuDto.getMainImage02());
                tbSpu.setMainImage03(tbSpuDto.getMainImage03());
                tbSpu.setSubImage01(tbSpuDto.getSubImage01());
                tbSpu.setSubImage02(tbSpuDto.getSubImage02());
                tbSpu.setSubImage03(tbSpuDto.getSubImage03());
                tbSpu.setSubImage04(tbSpuDto.getSubImage04());
                tbSpu.setSubImage05(tbSpuDto.getSubImage05());
                tbSpu.setOption01(tbSpuDto.getOption01());
                tbSpu.setOption02(tbSpuDto.getOption02());
                tbSpu.setOption03(tbSpuDto.getOption03());
                tbSpu.setOption04(tbSpuDto.getOption04());
                tbSpu.setOption05(tbSpuDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbSpu(tbSpu);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbSpu tbSpu = new TbSpu();
                tbSpu.setSpuId(tbSpuDto.getSpuId());
                tbSpu.setClassificationId(tbSpuDto.getDepth01Id());
                tbSpu.setDepth01Id(tbSpuDto.getDepth01Id());
                tbSpu.setDepth02Id(tbSpuDto.getDepth02Id());
                tbSpu.setDepth03Id(tbSpuDto.getDepth03Id());
                tbSpu.setDepth01Name(tbSpuDto.getDepth01Name());
                tbSpu.setDepth02Name(tbSpuDto.getDepth02Name());
                tbSpu.setDepth03Name(tbSpuDto.getDepth03Name());
                tbSpu.setBrandId(tbSpuDto.getBrandId());
                tbSpu.setSpuName(tbSpuDto.getSpuName());
                tbSpu.setSpuType(tbSpuDto.getSpuType());
                tbSpu.setStatus(tbSpuDto.getStatus());
                tbSpu.setMainImage01(tbSpuDto.getMainImage01());
                tbSpu.setMainImage02(tbSpuDto.getMainImage02());
                tbSpu.setMainImage03(tbSpuDto.getMainImage03());
                tbSpu.setSubImage01(tbSpuDto.getSubImage01());
                tbSpu.setSubImage02(tbSpuDto.getSubImage02());
                tbSpu.setSubImage03(tbSpuDto.getSubImage03());
                tbSpu.setSubImage04(tbSpuDto.getSubImage04());
                tbSpu.setSubImage05(tbSpuDto.getSubImage05());
                tbSpu.setOption01(tbSpuDto.getOption01());
                tbSpu.setOption02(tbSpuDto.getOption02());
                tbSpu.setOption03(tbSpuDto.getOption03());
                tbSpu.setOption04(tbSpuDto.getOption04());
                tbSpu.setOption05(tbSpuDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbSpu(tbSpu);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.ERROR.getDesc());
        }
    }


    /********************************************************************
     * SKU
     ***************************************************************** */

    @PostMapping(value = "/sku/list")
    public BaseResponse lstTbSkuDto(BaseRequest baseRequest, @RequestBody TbSkuDto tbSkuDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSkuDto> returnData = skuService.lstTbSku(tbSkuDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/sku/info")
    public BaseResponse getTbSkuInfoBySkuId(BaseRequest baseRequest, @RequestParam("skuId") Integer skuId) {
        if (skuId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbSkuDto tbSkuDto = skuService.getTbSkuInfoBySkuId(skuId);
        List<TbSkuAttributeDto> lstSkuAttr = skuService.lstTbSkuAttributeBySkuId(skuId);
        tbSkuDto.setLstSkuAttr(lstSkuAttr);
        return BaseResponse.valueOfSuccess(tbSkuDto);
    }

    @GetMapping(value = "/sku/listBySpuId")
    public BaseResponse lstTbSkuBySpuId(BaseRequest baseRequest, @RequestParam("spuId") Integer spuId) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSkuDto> returnData = skuService.lstTbSkuBySpuId(spuId);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @PostMapping(value = "/sku/proc")
    public BaseResponse procTB_SKU(BaseRequest baseRequest, @RequestBody TbSkuDto tbSkuDto) {
        if (StringUtils.isEmpty(tbSkuDto.getSkuName()) || StringUtils.isEmpty(String.valueOf(tbSkuDto.getSpuId()))) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbSkuDto.getSkuId() == null || "".equals(String.valueOf(tbSkuDto.getSkuId()))) {
                // insert new
                TbSku tbSku = new TbSku();
                tbSku.setSpuId(tbSkuDto.getSpuId());
                tbSku.setSkuName(tbSkuDto.getSkuName());
                tbSku.setSkuIntro(tbSkuDto.getSkuIntro());
                tbSku.setSkuPrice(tbSkuDto.getSkuPrice());
                tbSku.setSkuCode(tbSkuDto.getSkuCode());
                tbSku.setSkuBarcode(tbSkuDto.getSkuBarcode());
                tbSku.setSkuStock(tbSkuDto.getSkuStock());
                tbSku.setSkuUnit(tbSkuDto.getSkuUnit());
                tbSku.setSkuUnitName(tbSkuDto.getSkuUnitName());
                tbSku.setPrice(tbSkuDto.getPrice());
                tbSku.setVipPrice(tbSkuDto.getVipPrice());
                tbSku.setStatus(tbSkuDto.getStatus());
                tbSku.setMainImage01(tbSkuDto.getMainImage01());
                tbSku.setMainImage02(tbSkuDto.getMainImage02());
                tbSku.setMainImage03(tbSkuDto.getMainImage03());
                tbSku.setSubImage01(tbSkuDto.getSubImage01());
                tbSku.setSubImage02(tbSkuDto.getSubImage02());
                tbSku.setSubImage03(tbSkuDto.getSubImage03());
                tbSku.setSubImage04(tbSkuDto.getSubImage04());
                tbSku.setSubImage05(tbSkuDto.getSubImage05());
                tbSku.setOption01(tbSkuDto.getOption01());
                tbSku.setOption02(tbSkuDto.getOption02());
                tbSku.setOption03(tbSkuDto.getOption03());
                tbSku.setOption04(tbSkuDto.getOption04());
                tbSku.setOption05(tbSkuDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbSku(tbSku);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbSku tbSku = new TbSku();
                tbSku.setSkuId(tbSkuDto.getSkuId());
                tbSku.setSpuId(tbSkuDto.getSpuId());
                tbSku.setSkuName(tbSkuDto.getSkuName());
                tbSku.setSkuIntro(tbSkuDto.getSkuIntro());
                tbSku.setSkuPrice(tbSkuDto.getSkuPrice());
                tbSku.setSkuCode(tbSkuDto.getSkuCode());
                tbSku.setSkuBarcode(tbSkuDto.getSkuBarcode());
                tbSku.setSkuStock(tbSkuDto.getSkuStock());
                tbSku.setSkuUnit(tbSkuDto.getSkuUnit());
                tbSku.setSkuUnitName(tbSkuDto.getSkuUnitName());
                tbSku.setPrice(tbSkuDto.getPrice());
                tbSku.setVipPrice(tbSkuDto.getVipPrice());
                tbSku.setStatus(tbSkuDto.getStatus());
                tbSku.setMainImage01(tbSkuDto.getMainImage01());
                tbSku.setMainImage02(tbSkuDto.getMainImage02());
                tbSku.setMainImage03(tbSkuDto.getMainImage03());
                tbSku.setSubImage01(tbSkuDto.getSubImage01());
                tbSku.setSubImage02(tbSkuDto.getSubImage02());
                tbSku.setSubImage03(tbSkuDto.getSubImage03());
                tbSku.setSubImage04(tbSkuDto.getSubImage04());
                tbSku.setSubImage05(tbSkuDto.getSubImage05());
                tbSku.setOption01(tbSkuDto.getOption01());
                tbSku.setOption02(tbSkuDto.getOption02());
                tbSku.setOption03(tbSkuDto.getOption03());
                tbSku.setOption04(tbSkuDto.getOption04());
                tbSku.setOption05(tbSkuDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbSku(tbSku);
                boolean isSuccessDeleteSkuAttr = skuService.deleteTbSkuAttributeBySkuId(tbSkuDto.getSkuId());

                boolean isSuccessInsertSkuAttr = false;
                if (tbSkuDto.getLstSkuAttr().size() > 0) {
                    for (int i = 0; i < tbSkuDto.getLstSkuAttr().size(); i++) {
                        TbSkuAttribute tbSkuAttribute = new TbSkuAttribute();
                        tbSkuAttribute.setSkuId(tbSkuDto.getLstSkuAttr().get(i).getSkuId());
                        tbSkuAttribute.setAttrId(tbSkuDto.getLstSkuAttr().get(i).getAttrId());
                        tbSkuAttribute.setAttrValueId(tbSkuDto.getLstSkuAttr().get(i).getAttrValueId());
                        tbSkuAttribute.setIsMust(tbSkuDto.getLstSkuAttr().get(i).getIsMust());
                        tbSkuAttribute.setIsDefault(tbSkuDto.getLstSkuAttr().get(i).getIsDefault());
                        tbSkuAttribute.setPricePlus(tbSkuDto.getLstSkuAttr().get(i).getPricePlus());
                        tbSkuAttribute.setStatus(tbSkuDto.getLstSkuAttr().get(i).getStatus());
                        tbSkuAttribute.setOption01(tbSkuDto.getLstSkuAttr().get(i).getOption01());
                        tbSkuAttribute.setOption02(tbSkuDto.getLstSkuAttr().get(i).getOption02());
                        tbSkuAttribute.setOption03(tbSkuDto.getLstSkuAttr().get(i).getOption03());
                        tbSkuAttribute.setOption04(tbSkuDto.getLstSkuAttr().get(i).getOption04());
                        tbSkuAttribute.setOption05(tbSkuDto.getLstSkuAttr().get(i).getOption05());

                        isSuccessInsertSkuAttr = skuService.insertTbSkuAttribute(tbSkuAttribute);
                    }
                }

                if (isSuccessUpdate && isSuccessDeleteSkuAttr && isSuccessInsertSkuAttr) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.ERROR.getDesc());
        }
    }

    /********************************************************************
     * SPU ATTRIBUTE
     ***************************************************************** */

    @PostMapping(value = "/spuAttr/list")
    public BaseResponse lstTbSpuAttribute(BaseRequest baseRequest, @RequestBody TbSpuAttributeDto tbSpuAttributeDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSpuAttributeDto> returnData = skuService.lstTbSpuAttribute(tbSpuAttributeDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/spuAttr/info")
    public BaseResponse getTbSpuAttributeInfoBySpuAttrId(BaseRequest baseRequest, @RequestParam("spuAttrId") Integer spuAttrId) {
        if (spuAttrId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbSpuAttributeDto tbSpuAttributeDto = skuService.getTbSpuAttributeInfoBySpuAttrId(spuAttrId);
        return BaseResponse.valueOfSuccess(tbSpuAttributeDto);
    }

    @GetMapping(value = "/spuAttr/listBySpuId")
    public BaseResponse lstTbSpuAttributeBySpuId(BaseRequest baseRequest, @RequestParam("spuId") Integer spuId) {
        if (spuId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSpuAttributeDto> returnData = skuService.lstTbSpuAttributeBySpuId(spuId);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/spuAttr/listByAttrId")
    public BaseResponse lstTbSpuAttributeByAttrId(BaseRequest baseRequest, @RequestParam("attrId") Integer attrId) {
        if (attrId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSpuAttributeDto> returnData = skuService.lstTbSpuAttributeByAttrId(attrId);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @PostMapping(value = "/spuAttr/proc")
    public BaseResponse procTB_SPU_ATTRIBUTE(BaseRequest baseRequest, @RequestBody TbSpuAttributeDto tbSpuAttributeDto) {
        try {
            if (tbSpuAttributeDto.getSpuAttrId() == null || "".equals(String.valueOf(tbSpuAttributeDto.getSpuAttrId()))) {
                // insert new
                TbSpuAttribute tbSpuAttribute = new TbSpuAttribute();
                tbSpuAttribute.setSpuId(tbSpuAttributeDto.getSpuId());
                tbSpuAttribute.setAttrId(tbSpuAttributeDto.getAttrId());
                tbSpuAttribute.setStatus(tbSpuAttributeDto.getStatus());
                tbSpuAttribute.setOption01(tbSpuAttributeDto.getOption01());
                tbSpuAttribute.setOption02(tbSpuAttributeDto.getOption02());
                tbSpuAttribute.setOption03(tbSpuAttributeDto.getOption03());
                tbSpuAttribute.setOption04(tbSpuAttributeDto.getOption04());
                tbSpuAttribute.setOption05(tbSpuAttributeDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbSpuAttribute(tbSpuAttribute);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbSpuAttribute tbSpuAttribute = new TbSpuAttribute();
                tbSpuAttribute.setSpuAttrId(tbSpuAttributeDto.getSpuAttrId());
                tbSpuAttribute.setSpuId(tbSpuAttributeDto.getSpuId());
                tbSpuAttribute.setAttrId(tbSpuAttributeDto.getAttrId());
                tbSpuAttribute.setStatus(tbSpuAttributeDto.getStatus());
                tbSpuAttribute.setOption01(tbSpuAttributeDto.getOption01());
                tbSpuAttribute.setOption02(tbSpuAttributeDto.getOption02());
                tbSpuAttribute.setOption03(tbSpuAttributeDto.getOption03());
                tbSpuAttribute.setOption04(tbSpuAttributeDto.getOption04());
                tbSpuAttribute.setOption05(tbSpuAttributeDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbSpuAttribute(tbSpuAttribute);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }


    /********************************************************************
     * SKU ATTRIBUTE
     ***************************************************************** */

    @PostMapping(value = "/skuAttr/list")
    public BaseResponse lstTbSkuAttribute(BaseRequest baseRequest, @RequestBody TbSkuAttributeDto tbSkuAttributeDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSkuAttributeDto> returnData = skuService.lstTbSkuAttribute(tbSkuAttributeDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/skuAttr/info")
    public BaseResponse getTbSkuAttributeBySkuAttrId(BaseRequest baseRequest, @RequestParam("skuAttrId") Integer skuAttrId) {
        if (skuAttrId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbSkuAttributeDto tbSkuAttributeDto = skuService.getTbSkuAttributeBySkuAttrId(skuAttrId);
        return BaseResponse.valueOfSuccess(tbSkuAttributeDto);
    }

    @GetMapping(value = "/skuAttr/listBySkuId")
    public BaseResponse lstTbSkuAttributeBySkuId(BaseRequest baseRequest, @RequestParam("skuId") Integer skuId) {
        if (skuId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSkuAttributeDto> lstTbSkuAttributeBySkuId = skuService.lstTbSkuAttributeBySkuId(skuId);
        return BaseResponse.valueOfSuccessList(lstTbSkuAttributeBySkuId);
    }

    @GetMapping(value = "/skuAttr/listByAttrValueId")
    public BaseResponse lstTbSkuAttributeByAttrValueId(BaseRequest baseRequest, @RequestParam("attrValueId") Integer attrValueId) {
        if (attrValueId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbSkuAttributeDto> lstTbSkuAttributeByAttrValueId = skuService.lstTbSkuAttributeByAttrValueId(attrValueId);
        return BaseResponse.valueOfSuccessList(lstTbSkuAttributeByAttrValueId);
    }

    @PostMapping(value = "/skuAttr/proc")
    public BaseResponse procTB_SKU_ATTRIBUTE(BaseRequest baseRequest, @RequestBody TbSkuAttributeDto tbSkuAttributeDto) {
        try {
            if (tbSkuAttributeDto.getSkuAttrId() == null || "".equals(String.valueOf(tbSkuAttributeDto.getSkuAttrId()))) {
                // insert new
                TbSkuAttribute tbSkuAttribute = new TbSkuAttribute();
                tbSkuAttribute.setSkuId(tbSkuAttributeDto.getSkuId());
                tbSkuAttribute.setAttrId(tbSkuAttributeDto.getAttrId());
                tbSkuAttribute.setAttrValueId(tbSkuAttributeDto.getAttrValueId());
                tbSkuAttribute.setIsMust(tbSkuAttributeDto.getIsMust());
                tbSkuAttribute.setIsDefault(tbSkuAttributeDto.getIsDefault());
                tbSkuAttribute.setPricePlus(tbSkuAttributeDto.getPricePlus());
                tbSkuAttribute.setStatus(tbSkuAttributeDto.getStatus());
                tbSkuAttribute.setOption01(tbSkuAttributeDto.getOption01());
                tbSkuAttribute.setOption02(tbSkuAttributeDto.getOption02());
                tbSkuAttribute.setOption03(tbSkuAttributeDto.getOption03());
                tbSkuAttribute.setOption04(tbSkuAttributeDto.getOption04());
                tbSkuAttribute.setOption05(tbSkuAttributeDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbSkuAttribute(tbSkuAttribute);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbSkuAttribute tbSkuAttribute = new TbSkuAttribute();
                tbSkuAttribute.setSkuAttrId(tbSkuAttributeDto.getSkuAttrId());
                tbSkuAttribute.setSkuId(tbSkuAttributeDto.getSkuId());
                tbSkuAttribute.setAttrId(tbSkuAttributeDto.getAttrId());
                tbSkuAttribute.setAttrValueId(tbSkuAttributeDto.getAttrValueId());
                tbSkuAttribute.setIsMust(tbSkuAttributeDto.getIsMust());
                tbSkuAttribute.setIsDefault(tbSkuAttributeDto.getIsDefault());
                tbSkuAttribute.setPricePlus(tbSkuAttributeDto.getPricePlus());
                tbSkuAttribute.setStatus(tbSkuAttributeDto.getStatus());
                tbSkuAttribute.setOption01(tbSkuAttributeDto.getOption01());
                tbSkuAttribute.setOption02(tbSkuAttributeDto.getOption02());
                tbSkuAttribute.setOption03(tbSkuAttributeDto.getOption03());
                tbSkuAttribute.setOption04(tbSkuAttributeDto.getOption04());
                tbSkuAttribute.setOption05(tbSkuAttributeDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbSkuAttribute(tbSkuAttribute);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }

    /********************************************************************
     * TB_ATTRIBUTE
     ***************************************************************** */

    @PostMapping(value = "/attr/list")
    public BaseResponse lstTbAttribute(BaseRequest baseRequest, @RequestBody TbAttributeDto tbAttributeDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbAttributeDto> returnData = skuService.lstTbAttribute(tbAttributeDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @PostMapping(value = "/attr/list/type/2")
    public BaseResponse lstTbAttributeType2(BaseRequest baseRequest, @RequestBody TbAttributeDto tbAttributeDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<Map<String, Object>> returnData = skuService.lstTbAttributeType2(tbAttributeDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/attr/info")
    public BaseResponse getTbAttributeInfoByAttrId(BaseRequest baseRequest, @RequestParam("attrId") Integer attrId) {
        if (attrId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbAttributeDto tbAttributeDto = skuService.getTbAttributeInfoByAttrId(attrId);
        return BaseResponse.valueOfSuccess(tbAttributeDto);
    }

    @PostMapping(value = "/attr/proc")
    public BaseResponse procTB_ATTRIBUTE(BaseRequest baseRequest, @RequestBody TbAttributeDto tbAttributeDto) {
        try {
            if (tbAttributeDto.getAttrId() == null || "".equals(String.valueOf(tbAttributeDto.getAttrId()))) {
                // insert new
                TbAttribute tbAttribute = new TbAttribute();
                tbAttribute.setAttrName(tbAttributeDto.getAttrName());
                tbAttribute.setAttrType(tbAttributeDto.getAttrType());
                tbAttribute.setStatus(tbAttributeDto.getStatus());
                tbAttribute.setAttrImage(tbAttributeDto.getAttrImage());
                tbAttribute.setOption01(tbAttributeDto.getOption01());
                tbAttribute.setOption02(tbAttributeDto.getOption02());
                tbAttribute.setOption03(tbAttributeDto.getOption03());
                tbAttribute.setOption04(tbAttributeDto.getOption04());
                tbAttribute.setOption05(tbAttributeDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbAttribute(tbAttribute);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbAttribute tbAttribute = new TbAttribute();
                tbAttribute.setAttrId(tbAttributeDto.getAttrId());
                tbAttribute.setAttrName(tbAttributeDto.getAttrName());
                tbAttribute.setAttrType(tbAttributeDto.getAttrType());
                tbAttribute.setStatus(tbAttributeDto.getStatus());
                tbAttribute.setAttrImage(tbAttributeDto.getAttrImage());
                tbAttribute.setOption01(tbAttributeDto.getOption01());
                tbAttribute.setOption02(tbAttributeDto.getOption02());
                tbAttribute.setOption03(tbAttributeDto.getOption03());
                tbAttribute.setOption04(tbAttributeDto.getOption04());
                tbAttribute.setOption05(tbAttributeDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbAttribute(tbAttribute);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }

    /********************************************************************
     * TB_ATTRIBUTE_VALUE
     ***************************************************************** */
    @PostMapping(value = "/attrValue/list")
    public BaseResponse lstTbAttributeValue(BaseRequest baseRequest, @RequestBody TbAttributeValueDto tbAttributeValueDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbAttributeValueDto> lstTbAttributeValue = skuService.lstTbAttributeValue(tbAttributeValueDto);
        return BaseResponse.valueOfSuccessList(lstTbAttributeValue);
    }

    @PostMapping(value = "/attrValue/listByAttrId")
    public BaseResponse lstTbAttributeValueByAttrId(BaseRequest baseRequest, @RequestBody TbAttributeValueDto tbAttributeValueDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbAttributeValueDto> lstTbAttributeValue = skuService.lstTbAttributeValueByAttrId(tbAttributeValueDto);
        return BaseResponse.valueOfSuccessList(lstTbAttributeValue);
    }


    @GetMapping(value = "/attrValue/info")
    public BaseResponse getTbAttributeValueInfoByAttrValueId(BaseRequest baseRequest, @RequestParam("attrValueId") Integer attrValueId) {
        if (attrValueId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbAttributeValueDto tbAttributeValueDto = skuService.getTbAttributeValueInfoByAttrValueId(attrValueId);
        return BaseResponse.valueOfSuccess(tbAttributeValueDto);
    }

    @PostMapping(value = "/attrValue/proc")
    public BaseResponse procTB_ATTRIBUTE_VALUE(BaseRequest baseRequest, @RequestBody TbAttributeValueDto tbAttributeValueDto) {
        try {
            if (tbAttributeValueDto.getAttrValueId() == null || "".equals(String.valueOf(tbAttributeValueDto.getAttrValueId()))) {
                TbAttributeValue tbAttributeValue = new TbAttributeValue();
                tbAttributeValue.setAttrId(tbAttributeValueDto.getAttrId());
                tbAttributeValue.setAttrValue(tbAttributeValueDto.getAttrValue());
                tbAttributeValue.setPrice(tbAttributeValueDto.getPrice());
                tbAttributeValue.setVipPrice(tbAttributeValueDto.getVipPrice());
                tbAttributeValue.setDeliveryPrice(tbAttributeValueDto.getDeliveryPrice());
                tbAttributeValue.setDeliveryType(tbAttributeValueDto.getDeliveryType());
                tbAttributeValue.setStatus(tbAttributeValueDto.getStatus());
                tbAttributeValue.setAttrValueImage(tbAttributeValueDto.getAttrValueImage());
                tbAttributeValue.setOption01(tbAttributeValueDto.getOption01());
                tbAttributeValue.setOption02(tbAttributeValueDto.getOption02());
                tbAttributeValue.setOption03(tbAttributeValueDto.getOption03());
                tbAttributeValue.setOption04(tbAttributeValueDto.getOption04());
                tbAttributeValue.setOption05(tbAttributeValueDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbAttributeValue(tbAttributeValue);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                TbAttributeValue tbAttributeValue = new TbAttributeValue();
                tbAttributeValue.setAttrValueId(tbAttributeValueDto.getAttrValueId());
                tbAttributeValue.setAttrId(tbAttributeValueDto.getAttrId());
                tbAttributeValue.setAttrValue(tbAttributeValueDto.getAttrValue());
                tbAttributeValue.setPrice(tbAttributeValueDto.getPrice());
                tbAttributeValue.setVipPrice(tbAttributeValueDto.getVipPrice());
                tbAttributeValue.setDeliveryPrice(tbAttributeValueDto.getDeliveryPrice());
                tbAttributeValue.setDeliveryType(tbAttributeValueDto.getDeliveryType());
                tbAttributeValue.setStatus(tbAttributeValueDto.getStatus());
                tbAttributeValue.setAttrValueImage(tbAttributeValueDto.getAttrValueImage());
                tbAttributeValue.setOption01(tbAttributeValueDto.getOption01());
                tbAttributeValue.setOption02(tbAttributeValueDto.getOption02());
                tbAttributeValue.setOption03(tbAttributeValueDto.getOption03());
                tbAttributeValue.setOption04(tbAttributeValueDto.getOption04());
                tbAttributeValue.setOption05(tbAttributeValueDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbAttributeValue(tbAttributeValue);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }

    @DeleteMapping(value = "/attrValue/deleteByAttrValueId")
    public BaseResponse deleteTB_ATTRIBUTE_VALUEByAttrValueId(BaseRequest baseRequest, @RequestParam("attrValueId") Integer attrValueId) {
        if (attrValueId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            boolean isSuccessDelete = skuService.deleteTbAttributeValueByAttrValueId(attrValueId);
            if (isSuccessDelete) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage("删除错误！");
        }
    }
    /********************************************************************
     * TB_CLASSIFICATION
     ***************************************************************** */
    @PostMapping(value = "/classification/list")
    public BaseResponse lstTbClassification(BaseRequest baseRequest, @RequestBody TbClassificationDto tbClassificationDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbClassificationDto> lstTbClassification = skuService.lstTbClassification(tbClassificationDto);
        return BaseResponse.valueOfSuccessList(lstTbClassification);
    }

    @PostMapping(value = "/classification/info")
    public BaseResponse getTbClassificationInfoByClassificationId(BaseRequest baseRequest, @RequestParam("classificationId") Integer classificationId) {
        if (classificationId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbClassificationDto tbClassificationDto = skuService.getTbClassificationInfoByClassificationId(classificationId);
        return BaseResponse.valueOfSuccess(tbClassificationDto);
    }

    @PostMapping(value = "/classification/proc")
    public BaseResponse procTB_CLASSIFICATION(BaseRequest baseRequest, @RequestBody TbClassificationDto tbClassificationDto) {
        try {
            if (tbClassificationDto.getClassificationId() == null || "".equals(String.valueOf(tbClassificationDto.getClassificationId()))) {
                // insert new
                TbClassification tbClassification = new TbClassification();
                tbClassification.setClassificationName(tbClassificationDto.getClassificationName());
                tbClassification.setClassificationType(tbClassificationDto.getClassificationType());
                tbClassification.setParentClassificationId((tbClassificationDto.getParentClassificationId() == null || "".equals(String.valueOf(tbClassificationDto.getParentClassificationId())) ) ? 0 : tbClassificationDto.getParentClassificationId());
                tbClassification.setClassificationType(tbClassificationDto.getClassificationType());
                tbClassification.setClassificationImage(tbClassificationDto.getClassificationImage());
                tbClassification.setSortOrder(tbClassificationDto.getSortOrder());
                tbClassification.setDepthNum(tbClassificationDto.getDepthNum());
                tbClassification.setStatus(tbClassificationDto.getStatus());
                tbClassification.setOption01(tbClassificationDto.getOption01());
                tbClassification.setOption02(tbClassificationDto.getOption02());
                tbClassification.setOption03(tbClassificationDto.getOption03());
                tbClassification.setOption04(tbClassificationDto.getOption04());
                tbClassification.setOption05(tbClassificationDto.getOption05());

                boolean isSuccessInsert = skuService.insertTbClassification(tbClassification);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbClassification tbClassification = new TbClassification();
                tbClassification.setClassificationId(tbClassificationDto.getClassificationId());
                tbClassification.setClassificationName(tbClassificationDto.getClassificationName());
                tbClassification.setClassificationType(tbClassificationDto.getClassificationType());
                tbClassification.setParentClassificationId((tbClassificationDto.getParentClassificationId() == null || "".equals(String.valueOf(tbClassificationDto.getParentClassificationId())) ) ? 0 : tbClassificationDto.getParentClassificationId());
                tbClassification.setClassificationType(tbClassificationDto.getClassificationType());
                tbClassification.setClassificationImage(tbClassificationDto.getClassificationImage());
                tbClassification.setSortOrder(tbClassificationDto.getSortOrder());
                tbClassification.setDepthNum(tbClassificationDto.getDepthNum());
                tbClassification.setStatus(tbClassificationDto.getStatus());
                tbClassification.setOption01(tbClassificationDto.getOption01());
                tbClassification.setOption02(tbClassificationDto.getOption02());
                tbClassification.setOption03(tbClassificationDto.getOption03());
                tbClassification.setOption04(tbClassificationDto.getOption04());
                tbClassification.setOption05(tbClassificationDto.getOption05());

                boolean isSuccessUpdate = skuService.updateTbClassification(tbClassification);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }

    @PostMapping(value = "/classification/list/byParentClassificationId")
    public BaseResponse lstTbClassificationByParentClassificationId(BaseRequest baseRequest, @RequestParam(value = "parentClassificationId", defaultValue = "0") Integer parentClassificationId) {
        if (parentClassificationId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<TbClassificationDto> lstTbClassificationByParentClassificationIdData = skuService.getTbClassificationInfoByParentClassificationId(parentClassificationId);
        return BaseResponse.valueOfSuccess(lstTbClassificationByParentClassificationIdData);
    }

}
