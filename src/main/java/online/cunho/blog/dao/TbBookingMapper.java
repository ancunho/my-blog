package online.cunho.blog.dao;

import online.cunho.blog.dto.TbBookingDto;
import online.cunho.blog.entity.TbBooking;

import java.util.List;

public interface TbBookingMapper {
    int deleteByPrimaryKey(Long bookingId);

    int insert(TbBooking record);

    int insertSelective(TbBooking record);

    TbBooking selectByPrimaryKey(Long bookingId);

    int updateByPrimaryKeySelective(TbBooking record);

    int updateByPrimaryKey(TbBooking record);

    List<TbBookingDto> getAllBookingList(TbBookingDto tbBookingDto);

    TbBookingDto getBookingInfoByBookingId(Integer bookingId);
}