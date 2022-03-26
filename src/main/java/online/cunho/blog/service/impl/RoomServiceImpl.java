package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbRoomMapper;
import online.cunho.blog.dto.TbRoomDto;
import online.cunho.blog.entity.TbRoom;
import online.cunho.blog.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    @Resource
    private TbRoomMapper tbRoomMapper;

    @Transactional
    public Boolean insertTbRoom(TbRoom tbRoom) {
        int insertCount = tbRoomMapper.insertSelective(tbRoom);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbRoom(TbRoom tbRoom) {
        int updateCount = tbRoomMapper.updateByPrimaryKeySelective(tbRoom);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbRoomDto> getAllRoomList(TbRoomDto tbRoomDto) {
        return tbRoomMapper.getAllRoomList(tbRoomDto);
    }

    public TbRoomDto getTbRoomInfoByRoomId(Integer roomId) {
        return tbRoomMapper.getTbRoomInfoByRoomId(roomId);
    }


}
