package online.cunho.blog.service;

import online.cunho.blog.dto.TbBookingDto;
import online.cunho.blog.entity.TbBooking;

import java.util.List;

public interface BookingService {

    public Boolean insertTbBooking(TbBooking tbBooking);
    public Boolean updateTbBooking(TbBooking tbBooking);
    public List<TbBookingDto> getAllBookingList(TbBookingDto tbBookingDto);
    public TbBookingDto getBookingInfoByBookingId(Integer bookingId);

}
