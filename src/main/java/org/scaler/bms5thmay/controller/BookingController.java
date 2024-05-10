package org.scaler.bms5thmay.controller;

import org.scaler.bms5thmay.Service.BookingService;
import org.scaler.bms5thmay.dto.BookingRequestDto;
import org.scaler.bms5thmay.dto.BookingResponseDto;
import org.scaler.bms5thmay.dto.ResponseStatus;
import org.scaler.bms5thmay.models.Booking;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bs){
        this.bookingService=bs;
    }

    public BookingResponseDto CreateBooking(BookingRequestDto requestDto){


        BookingResponseDto bookingResponseDto = new BookingResponseDto();

        Booking b = bookingService.CreateBooking(requestDto.getUserId(), requestDto.getShowSeatIds(),
                requestDto.getShowId());

        bookingResponseDto.setBookingId(b.getId());
        bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return bookingResponseDto;

    }
}


// 8:20..