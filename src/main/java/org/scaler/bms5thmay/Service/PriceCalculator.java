package org.scaler.bms5thmay.Service;

import org.scaler.bms5thmay.Repo.ShowSeatTypeRepo;
import org.scaler.bms5thmay.models.Show;
import org.scaler.bms5thmay.models.ShowSeat;
import org.scaler.bms5thmay.models.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PriceCalculator {
    /*

    SHOWSEAT, SHOW_SEAT_TYPE
        1. find seat type and number of seats booked by user..
        2. find price of seat type in SHOW_SEAT_TYPE then add based on seat type..

     */

    private ShowSeatTypeRepo showSeatTypeRepo;

    PriceCalculator(ShowSeatTypeRepo showSeatTypeRepo){
        this.showSeatTypeRepo = showSeatTypeRepo;
    }

    public int calculate(Show show, List<ShowSeat> showSeats){
        int amount = 0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepo.findAllByShow(show);

        // plat: 100
        // silver 50
        // gold: 70
        for( ShowSeat s: showSeats){ // 1,2,3,4
            for(ShowSeatType seatType: showSeatTypes){
                if(s.getSeat().getSeatType().equals(seatType.getSeatType())){
                    amount+=seatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
