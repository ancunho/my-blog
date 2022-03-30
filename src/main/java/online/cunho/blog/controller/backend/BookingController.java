package online.cunho.blog.controller.backend;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.annotation.PassLogin;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbBookingDto;
import online.cunho.blog.entity.TbBooking;
import online.cunho.blog.service.BookingService;
import online.cunho.blog.util.Util;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/backend/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @AdminUserLogin
    @PostMapping(value = "/list")
    public BaseResponse getAllBookingList(BaseRequest baseRequest, @RequestBody TbBookingDto tbBookingDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbBookingDto> returnData = bookingService.getAllBookingList(tbBookingDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @AdminUserLogin
    @PostMapping(value = "/proc")
    public BaseResponse procTbBookingByTbBookingDto(BaseRequest baseRequest, @RequestBody TbBookingDto tbBookingDto) {
        if (StringUtils.isEmpty(tbBookingDto.getBookingStartday())
            || StringUtils.isEmpty(tbBookingDto.getBookingEndday())
            || StringUtils.isEmpty(tbBookingDto.getBookingStarttime())
            || StringUtils.isEmpty(tbBookingDto.getBookingEndtime())
            || StringUtils.isEmpty(tbBookingDto.getBookingMobile())
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbBookingDto.getBookingId() == null || "".equals(String.valueOf(tbBookingDto.getBookingId()))) {
                // insert new
                TbBooking tbBooking = new TbBooking();
                tbBooking.setBookingOrderNo("B" + Util.generateOrderNo());
                tbBooking.setBookingOrderStatus("02"); // 01:예약가능, 02:이미예약, 99:예약불가능
                tbBooking.setBookingType("02"); //01:miniapp, 02:management system
                tbBooking.setShopId(tbBookingDto.getShopId());
                tbBooking.setRoomId(tbBookingDto.getRoomId());
                tbBooking.setCustomerId(tbBookingDto.getCustomerId());
                tbBooking.setBookingPersonCount(tbBookingDto.getBookingPersonCount());
                tbBooking.setBookingStartday(tbBookingDto.getBookingStartday());
                tbBooking.setBookingEndday(tbBookingDto.getBookingEndday());
                tbBooking.setBookingStarttime(tbBookingDto.getBookingStarttime());
                tbBooking.setBookingEndtime(tbBookingDto.getBookingEndtime());
                tbBooking.setBookingMobile(tbBookingDto.getBookingMobile());
                tbBooking.setBookingPersonName(tbBookingDto.getBookingPersonName());
                tbBooking.setPayStatus(tbBookingDto.getPayStatus());
                tbBooking.setRemark(tbBookingDto.getRemark());
                tbBooking.setComment(tbBookingDto.getComment());
                tbBooking.setOption01(tbBookingDto.getOption01());
                tbBooking.setOption02(tbBookingDto.getOption02());
                tbBooking.setOption03(tbBookingDto.getOption03());
                tbBooking.setOption04(tbBookingDto.getOption04());
                tbBooking.setOption05(tbBookingDto.getOption05());

                boolean isSuccessInsert = bookingService.insertTbBooking(tbBooking);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbBooking tbBooking = new TbBooking();
                tbBooking.setBookingId(tbBookingDto.getBookingId());
                tbBooking.setBookingOrderNo(tbBookingDto.getBookingOrderNo());
                tbBooking.setBookingOrderStatus(tbBookingDto.getBookingOrderStatus()); // 01:예약가능, 02:이미예약, 99:예약불가능
                tbBooking.setBookingType("02"); //01:miniapp, 02:management system
                tbBooking.setShopId(tbBookingDto.getShopId());
                tbBooking.setRoomId(tbBookingDto.getRoomId());
                tbBooking.setCustomerId(tbBookingDto.getCustomerId());
                tbBooking.setBookingPersonCount(tbBookingDto.getBookingPersonCount());
                tbBooking.setBookingStartday(tbBookingDto.getBookingStartday());
                tbBooking.setBookingEndday(tbBookingDto.getBookingEndday());
                tbBooking.setBookingStarttime(tbBookingDto.getBookingStarttime());
                tbBooking.setBookingEndtime(tbBookingDto.getBookingEndtime());
                tbBooking.setBookingMobile(tbBookingDto.getBookingMobile());
                tbBooking.setBookingPersonName(tbBookingDto.getBookingPersonName());
                tbBooking.setPayStatus(tbBookingDto.getPayStatus());
                tbBooking.setRemark(tbBookingDto.getRemark());
                tbBooking.setComment(tbBookingDto.getComment());
                tbBooking.setOption01(tbBookingDto.getOption01());
                tbBooking.setOption02(tbBookingDto.getOption02());
                tbBooking.setOption03(tbBookingDto.getOption03());
                tbBooking.setOption04(tbBookingDto.getOption04());
                tbBooking.setOption05(tbBookingDto.getOption05());

                boolean isSuccessUpdate = bookingService.updateTbBooking(tbBooking);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }
    }

    @AdminUserLogin
    @GetMapping(value = "/info")
    public BaseResponse getBookingInfoByBookingId(BaseRequest baseRequest, @RequestParam("bookingId") Integer bookingId) {
        if (bookingId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbBookingDto tbBookingDto = bookingService.getBookingInfoByBookingId(bookingId);
        return BaseResponse.valueOfSuccess(tbBookingDto);
    }
}
