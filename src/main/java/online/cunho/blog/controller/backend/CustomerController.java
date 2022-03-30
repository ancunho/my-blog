package online.cunho.blog.controller.backend;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbCustomerDto;
import online.cunho.blog.dto.TbCustomerShopDto;
import online.cunho.blog.entity.TbCustomer;
import online.cunho.blog.entity.TbCustomerShop;
import online.cunho.blog.service.CustomerService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/backend/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 회원추가 혹은 편집
     * @param baseRequest
     * @param tbCustomerDto
     * @return
     */
    @AdminUserLogin
    @PostMapping(value = "/proc")
    public BaseResponse procTB_CUSTOMER(BaseRequest baseRequest, @RequestBody TbCustomerDto tbCustomerDto) {
        if (StringUtils.isEmpty(tbCustomerDto.getMobileNo())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbCustomerDto.getCustomerId() == null) {
                Map<String, Object> mapParams = new HashMap<>();
                mapParams.put("mobileNo", tbCustomerDto.getMobileNo());
                boolean isExistMobileNo = customerService.isExistMobileNo(mapParams);
                if (isExistMobileNo) {
                    return BaseResponse.valueOfFailureMessage("此手机号已注册");
                }

                TbCustomer tbCustomer = new TbCustomer();
                tbCustomer.setUsername(tbCustomerDto.getUsername());
                if (StringUtils.isEmpty(tbCustomerDto.getPassword())) {
                    tbCustomer.setPassword(MD5Util.MD5EncodeUtf8("g12345678"));
                } else {
                    tbCustomer.setPassword(MD5Util.MD5EncodeUtf8(tbCustomerDto.getPassword()));
                }
                tbCustomer.setMobileNo(tbCustomerDto.getMobileNo());
                tbCustomer.setRealname(tbCustomerDto.getRealname());
                tbCustomer.setWeixinOpenId(tbCustomerDto.getWeixinOpenId());
                tbCustomer.setWeixinUnionId(tbCustomerDto.getWeixinUnionId());
                tbCustomer.setNickname(tbCustomerDto.getNickname());
                tbCustomer.setCountry(tbCustomerDto.getCountry());
                tbCustomer.setCity(tbCustomerDto.getCity());
                tbCustomer.setAddress(tbCustomerDto.getAddress());
                tbCustomer.setBirthday(tbCustomerDto.getBirthday());
                tbCustomer.setEmail(tbCustomerDto.getEmail());
                tbCustomer.setCustomerType(tbCustomerDto.getCustomerType());
                tbCustomer.setGrade(tbCustomerDto.getGrade());
                tbCustomer.setSex(tbCustomerDto.getSex());
                tbCustomer.setStatus(tbCustomerDto.getStatus());
                tbCustomer.setOption01(tbCustomerDto.getOption01());
                tbCustomer.setOption02(tbCustomerDto.getOption02());
                tbCustomer.setOption03(tbCustomerDto.getOption03());
                tbCustomer.setOption04(tbCustomerDto.getOption04());
                tbCustomer.setOption05(tbCustomerDto.getOption05());

                // 1. tb_customer insert하고 customerId반환 (tbCustomer오브젝트)
                boolean isSuccessInsert = customerService.insertTbCustomer(tbCustomer);

                // 해당고객이 속한 매장과 매핑
                // 2. 1에서 반환한 customerId를 tbCustomerShop의 customerId에 세팅 및 insert
                if (tbCustomerDto.getShopId() != null && tbCustomerDto.getShopId().length() > 0) {
                    List<String> shopIds = Arrays.asList(tbCustomerDto.getShopId().split(","));
                    for (int i = 0; i < shopIds.size(); i++) {
                        TbCustomerShop tbCustomerShop = new TbCustomerShop();
                        tbCustomerShop.setCustomerId(tbCustomer.getCustomerId());
                        tbCustomerShop.setShopId(Integer.valueOf(shopIds.get(i)));
                        customerService.insertTbCustomerShop(tbCustomerShop);
                    }
                }

                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                Map<String, Object> mapParams = new HashMap<>();
                mapParams.put("customerId", tbCustomerDto.getCustomerId());
                mapParams.put("mobileNo", tbCustomerDto.getMobileNo());
                boolean isExistMobileNo = customerService.isExistMobileNo(mapParams);
                if (isExistMobileNo) {
                    return BaseResponse.valueOfFailureMessage("此手机号已注册");
                }

                TbCustomer tbCustomer = new TbCustomer();
                tbCustomer.setCustomerId(tbCustomerDto.getCustomerId());
                tbCustomer.setUsername(tbCustomerDto.getUsername());
                if (StringUtils.isEmpty(tbCustomerDto.getPassword())) {
                    tbCustomer.setPassword(MD5Util.MD5EncodeUtf8("g12345678"));
                } else {
                    tbCustomer.setPassword(MD5Util.MD5EncodeUtf8(tbCustomerDto.getPassword()));
                }
                tbCustomer.setMobileNo(tbCustomerDto.getMobileNo());
                tbCustomer.setRealname(tbCustomerDto.getRealname());
                tbCustomer.setWeixinOpenId(tbCustomerDto.getWeixinOpenId());
                tbCustomer.setWeixinUnionId(tbCustomerDto.getWeixinUnionId());
                tbCustomer.setNickname(tbCustomerDto.getNickname());
                tbCustomer.setCountry(tbCustomerDto.getCountry());
                tbCustomer.setCity(tbCustomerDto.getCity());
                tbCustomer.setAddress(tbCustomerDto.getAddress());
                tbCustomer.setBirthday(tbCustomerDto.getBirthday());
                tbCustomer.setEmail(tbCustomerDto.getEmail());
                tbCustomer.setCustomerType(tbCustomerDto.getCustomerType());
                tbCustomer.setGrade(tbCustomerDto.getGrade());
                tbCustomer.setSex(tbCustomerDto.getSex());
                tbCustomer.setStatus(tbCustomerDto.getStatus());
                tbCustomer.setOption01(tbCustomerDto.getOption01());
                tbCustomer.setOption02(tbCustomerDto.getOption02());
                tbCustomer.setOption03(tbCustomerDto.getOption03());
                tbCustomer.setOption04(tbCustomerDto.getOption04());
                tbCustomer.setOption05(tbCustomerDto.getOption05());

                boolean isSuccessUpdate = customerService.updateTbCustomer(tbCustomer);

                //1. 해당고객이 속한 매장데이타 삭제
                customerService.deleteTbCustomerShopByCustomerId(tbCustomer.getCustomerId());
                if (tbCustomerDto.getShopId().length() > 0) {
                    List<String> shopIds = Arrays.asList(tbCustomerDto.getShopId().split(","));
                    for (int i = 0; i < shopIds.size(); i++) {
                        TbCustomerShop tbCustomerShop = new TbCustomerShop();
                        tbCustomerShop.setCustomerId(tbCustomer.getCustomerId());
                        tbCustomerShop.setShopId(Integer.valueOf(shopIds.get(i)));
                        customerService.insertTbCustomerShop(tbCustomerShop);
                    }
                }

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

    /**
     * 회원리스트
     * @param baseRequest
     * @return
     */
    @AdminUserLogin
    @GetMapping(value = "/list")
    public BaseResponse getAllCustomerList(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbCustomerDto> returnData = customerService.getAllCustomerList();
        return BaseResponse.valueOfSuccessList(returnData);
    }

    /**
     * 회원상세정보
     * @param customerId
     * @return
     */
    @AdminUserLogin
    @GetMapping(value = "/info")
    public BaseResponse getCustomerInfoByCustomerId(@RequestParam("customerId") Integer customerId) {
        if (customerId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbCustomerDto tbCustomerDto = customerService.getCustomerInfoByCustomerId(customerId);
        List<TbCustomerShopDto> lstTbCustomerShop = customerService.getCustomerShopListByCustomerId(customerId);
        return BaseResponse.valueOfSuccess(tbCustomerDto);
    }

    @PostMapping(value = "/delete")
    public BaseResponse deleteCustomerByCustomerId(@RequestParam("customerId") Integer customerId) {
        if (customerId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            customerService.deleteCustomerByCustomerId(customerId);
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
        }
    }

    /**
     * TODO 회원별 예약 리스트
     * @param baseRequest
     * @param customerId
     * @return
     */
    @AdminUserLogin
    @GetMapping(value = "/booking/list")
    public BaseResponse getBookingListByCustomerId(BaseRequest baseRequest, @RequestParam("customerId") Integer customerId) {
        if (customerId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());

        return null;
    }

    /**
     * TODO 회원별 지불 리스트
     * @param baseRequest
     * @param customerId
     * @return
     */
    @AdminUserLogin
    @GetMapping(value = "/pay/list")
    public BaseResponse getPayListByCustomerId(BaseRequest baseRequest, @RequestParam("customerId") Integer customerId) {
        if (customerId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());

        return null;
    }
}
