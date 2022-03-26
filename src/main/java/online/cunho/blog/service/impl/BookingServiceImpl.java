package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbBookingMapper;
import online.cunho.blog.dto.TbBookingDto;
import online.cunho.blog.entity.TbBooking;
import online.cunho.blog.service.BookingService;
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
public class BookingServiceImpl implements BookingService {

    @Resource
    private TbBookingMapper tbBookingMapper;

    @Transactional
    public Boolean insertTbBooking(TbBooking tbBooking) {
        int insertCount = tbBookingMapper.insertSelective(tbBooking);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbBooking(TbBooking tbBooking) {
        int updateCount = tbBookingMapper.updateByPrimaryKeySelective(tbBooking);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbBookingDto> getAllBookingList(TbBookingDto tbBookingDto) {
        return tbBookingMapper.getAllBookingList(tbBookingDto);
    }

    public TbBookingDto getBookingInfoByBookingId(Integer bookingId) {
        return tbBookingMapper.getBookingInfoByBookingId(bookingId);
    }


}
