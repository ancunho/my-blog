package online.cunho.blog.controller.backend;

import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbRoomDto;
import online.cunho.blog.entity.TbRoom;
import online.cunho.blog.service.RoomService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(value = "/list")
    public BaseResponse getAllRoomList(BaseRequest baseRequest, @RequestBody TbRoomDto tbRoomDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbRoomDto> returnData = roomService.getAllRoomList(tbRoomDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @PostMapping(value = "/proc")
    public BaseResponse procTbRoomByTbRoomDto(BaseRequest baseRequest, @RequestBody TbRoomDto tbRoomDto) {
        if (tbRoomDto == null
            || tbRoomDto.getShopId() == null
            || StringUtils.isEmpty(String.valueOf(tbRoomDto.getShopId()))
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        if (tbRoomDto.getRoomId() == null || "".equals(String.valueOf(tbRoomDto.getRoomId()))) {
            // insert new
            TbRoom tbRoom = new TbRoom();
            tbRoom.setShopId(tbRoomDto.getShopId());
            tbRoom.setRoomType(tbRoomDto.getRoomType());
            tbRoom.setRoomName(tbRoomDto.getRoomName());
            tbRoom.setRoomThumbnail(tbRoomDto.getRoomThumbnail());
            tbRoom.setRoomIntro(tbRoomDto.getRoomIntro());
            tbRoom.setRoomCode(tbRoomDto.getRoomCode());
            tbRoom.setRoomCapacity(tbRoomDto.getRoomCapacity());
            tbRoom.setRoomStatus(tbRoomDto.getRoomStatus());
            tbRoom.setOption01(tbRoomDto.getOption01());
            tbRoom.setOption02(tbRoomDto.getOption02());
            tbRoom.setOption03(tbRoomDto.getOption03());
            tbRoom.setOption04(tbRoomDto.getOption04());
            tbRoom.setOption05(tbRoomDto.getOption05());

            boolean isSuccessInsert = roomService.insertTbRoom(tbRoom);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
        } else {
            // update
            TbRoom tbRoom = new TbRoom();
            tbRoom.setRoomId(tbRoomDto.getRoomId());
            tbRoom.setShopId(tbRoomDto.getShopId());
            tbRoom.setRoomType(tbRoomDto.getRoomType());
            tbRoom.setRoomName(tbRoomDto.getRoomName());
            tbRoom.setRoomThumbnail(tbRoomDto.getRoomThumbnail());
            tbRoom.setRoomIntro(tbRoomDto.getRoomIntro());
            tbRoom.setRoomCode(tbRoomDto.getRoomCode());
            tbRoom.setRoomCapacity(tbRoomDto.getRoomCapacity());
            tbRoom.setRoomStatus(tbRoomDto.getRoomStatus());
            tbRoom.setOption01(tbRoomDto.getOption01());
            tbRoom.setOption02(tbRoomDto.getOption02());
            tbRoom.setOption03(tbRoomDto.getOption03());
            tbRoom.setOption04(tbRoomDto.getOption04());
            tbRoom.setOption05(tbRoomDto.getOption05());

            boolean isSuccessUpdate = roomService.updateTbRoom(tbRoom);
            if (isSuccessUpdate) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }
    }

    @GetMapping(value = "/info")
    public BaseResponse getTbRoomByRoomId(@RequestParam("roomId") Integer roomId) {
        if (roomId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbRoomDto tbRoomDto = roomService.getTbRoomInfoByRoomId(roomId);
        return BaseResponse.valueOfSuccess(tbRoomDto);
    }
}
