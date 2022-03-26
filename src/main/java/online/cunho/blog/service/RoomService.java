package online.cunho.blog.service;

import online.cunho.blog.dto.TbRoomDto;
import online.cunho.blog.entity.TbRoom;

import java.util.List;

public interface RoomService {

    public Boolean insertTbRoom(TbRoom tbRoom);
    public Boolean updateTbRoom(TbRoom tbRoom);
    public List<TbRoomDto> getAllRoomList(TbRoomDto tbRoomDto);
    public TbRoomDto getTbRoomInfoByRoomId(Integer roomId);

}
