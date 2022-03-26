package online.cunho.blog.controller.backend;

import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.Const;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbCommonCodeDto;
import online.cunho.blog.entity.TbCommonCode;
import online.cunho.blog.service.CommonService;
import online.cunho.blog.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    public RedisUtil redisUtil;

    @Autowired
    private Producer producer;

    @Autowired
    private CommonService commonService;

    @GetMapping("/captcha")
    public BaseResponse captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String captchaCode = producer.createText();
        String captchaKey = UUID.randomUUID().toString();

        // For Test
//        code = "code111";
//        captchaKey="key111";

        BufferedImage image = producer.createImage(captchaCode);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());

        // Redis에 저장
        redisUtil.hset(Const.CAPTCHA_KEY, captchaKey, captchaCode, 120);
        log.info("验证码 -- {} - {}", captchaKey, captchaCode);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("captchaCode", captchaCode);
        returnMap.put("captchaKey", captchaKey);
        returnMap.put("base64Img", base64Img);

        return BaseResponse.valueOfSuccess(returnMap);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/code/proc")
    public BaseResponse modifyTbCommonCode(HttpServletRequest request, @RequestBody TbCommonCodeDto tbCommonCodeDto) {
        if (StringUtils.isEmpty(tbCommonCodeDto.getCodeName())
            || StringUtils.isEmpty(tbCommonCodeDto.getCodeCd())
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbCommonCodeDto.getCodeId() == null || String.valueOf(tbCommonCodeDto.getCodeId()) == "") {
                // insert New
                TbCommonCode tbCommonCode = new TbCommonCode();
                tbCommonCode.setCodeType(tbCommonCodeDto.getCodeType());
                tbCommonCode.setCodeCd(tbCommonCodeDto.getCodeCd());
                tbCommonCode.setCodeName(tbCommonCodeDto.getCodeName());
                tbCommonCode.setUseYn(tbCommonCodeDto.getStatus());
                tbCommonCode.setRemark(tbCommonCodeDto.getRemark());
                tbCommonCode.setOption01(tbCommonCodeDto.getOption01());
                tbCommonCode.setOption02(tbCommonCodeDto.getOption02());
                tbCommonCode.setOption03(tbCommonCodeDto.getOption03());
                tbCommonCode.setOption04(tbCommonCodeDto.getOption04());
                tbCommonCode.setOption05(tbCommonCodeDto.getOption05());

                boolean isSuccessInsert = commonService.insertTbCommonCode(tbCommonCode);

                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbCommonCode tbCommonCode = new TbCommonCode();
                tbCommonCode.setCodeId(tbCommonCodeDto.getCodeId());
                tbCommonCode.setCodeType(tbCommonCodeDto.getCodeType());
                tbCommonCode.setCodeCd(tbCommonCodeDto.getCodeCd());
                tbCommonCode.setCodeName(tbCommonCodeDto.getCodeName());
                tbCommonCode.setUseYn(tbCommonCodeDto.getStatus());
                tbCommonCode.setRemark(tbCommonCodeDto.getRemark());
                tbCommonCode.setOption01(tbCommonCodeDto.getOption01());
                tbCommonCode.setOption02(tbCommonCodeDto.getOption02());
                tbCommonCode.setOption03(tbCommonCodeDto.getOption03());
                tbCommonCode.setOption04(tbCommonCodeDto.getOption04());
                tbCommonCode.setOption05(tbCommonCodeDto.getOption05());

                boolean isSuccessUpdate = commonService.updateTbCommonCode(tbCommonCode);

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

    @GetMapping(value = "/code/list")
    public BaseResponse getAllTbCommonCodeList(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbCommonCodeDto> returnData = commonService.getAllTbCommonCodeList();
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @GetMapping(value = "/code/info")
    public BaseResponse getTbCommonCodeInfoByCodeId(@RequestParam("codeId") Integer codeId) {
        if (codeId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbCommonCodeDto tbCommonCodeDto = commonService.getTbCommonCodeInfoByCodeId(codeId);
        return BaseResponse.valueOfSuccess(tbCommonCodeDto);
    }

    @GetMapping(value = "/code/type/list")
    public BaseResponse lstTbCommonCodeByCodeType(@RequestParam("codeType") String codeType) {
        if (codeType == null || StringUtils.isEmpty(codeType)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<TbCommonCodeDto> lstTbCommonCodeByCodeType = commonService.lstTbCommonCodeByCodeType(codeType);
        return BaseResponse.valueOfSuccess(lstTbCommonCodeByCodeType);
    }




}
