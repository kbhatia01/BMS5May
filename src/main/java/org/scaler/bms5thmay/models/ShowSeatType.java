package org.scaler.bms5thmay.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseClass{

    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;
}
