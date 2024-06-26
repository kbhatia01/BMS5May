package org.scaler.bms5thmay.Service;

import org.scaler.bms5thmay.Repo.BookingRepo;
import org.scaler.bms5thmay.Repo.ShowRepository;
import org.scaler.bms5thmay.Repo.UserRepository;
import org.scaler.bms5thmay.Repo.showSeatRepo;
import org.scaler.bms5thmay.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



@Service
public class BookingService {

    private UserRepository userRepo;
    private ShowRepository showRepo;

    private showSeatRepo showSeatRepo;
    private PriceCalculator priceCalculator;

    private BookingRepo bookingRepo;

    public BookingService(UserRepository userRepo, ShowRepository showRepo,
                          showSeatRepo showSeatRepo,
                          PriceCalculator priceCalculator,
                          BookingRepo bookingRepo){
        this.userRepo = userRepo;
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
        this.priceCalculator = priceCalculator;
        this.bookingRepo = bookingRepo;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking CreateBooking(Long userId,
                                 List<Long> showSeat, Long showId){

        /*

        1. check user if user exists..
        2. check if show exist..
        3. get all showSeat Ids objects and see if they exist...
        4. ----TAKE LOCK---
        5. check if seat available or not..
        6. if not throw error..
        7. if yes, Mark the status of all seats to blocked and save to db..
        8. --- RELEASE LOCK ---
        9. create a booking object with pending status..
        10. returning booking object..

         */

        Optional<User> uOptional = this.userRepo.findById(userId);
        if(uOptional.isEmpty()){
            throw new RuntimeException("User is not present..");
        }

        User u = uOptional.get();

        Optional<Show> sOptional = this.showRepo.findById(userId);
        if(sOptional.isEmpty()){
            throw new RuntimeException("User is not present..");
        }

        Show show = sOptional.get();


        List<ShowSeat> showSeats  = this.showSeatRepo.findAllById(showSeat);

//        5. check if seat available or not..
//        6. if not throw error..

        for(ShowSeat s: showSeats){
            if(!s.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Show seat id: " + s.getId() +" is not available..");
            }
        }

//        7. if yes, Mark the status of all seats to blocked and save to db..

        for(ShowSeat s: showSeats){
            s.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(s);
        }

//        9. create a booking object with pending status..
//        10. returning booking object..

        Booking b = new Booking();
        b.setBookingStatus(BookingStatus.PENDING);
        b.setCreatedAt(new Date());
        b.setUser(u);
        b.setShow(show);
        b.setPayments(new ArrayList<>());
        b.setShowSeats(showSeats);
        b.setAmount(priceCalculator.calculate(show, showSeats));

        b = bookingRepo.save(b);
        return b;

    }

}
