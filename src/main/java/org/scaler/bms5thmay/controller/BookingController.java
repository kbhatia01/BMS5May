package org.scaler.bms5thmay.controller;

import org.scaler.bms5thmay.Service.BookingService;
import org.scaler.bms5thmay.dto.BookingRequestDto;
import org.scaler.bms5thmay.dto.BookingResponseDto;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bs){
        this.bookingService=bs;
    }

    public BookingResponseDto CreateBooking(BookingRequestDto requestDto){
        return null;
    }
}
