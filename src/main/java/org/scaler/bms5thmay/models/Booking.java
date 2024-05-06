package org.scaler.bms5thmay.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseClass{
    private String BookingNumber;

    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}


/*
        1               M
        Booking ===   SHOW_SEAT

          M              1
 */