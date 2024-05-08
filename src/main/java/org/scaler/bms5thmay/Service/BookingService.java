package org.scaler.bms5thmay.Service;

import org.scaler.bms5thmay.Repo.ShowRepository;
import org.scaler.bms5thmay.Repo.UserRepository;
import org.scaler.bms5thmay.models.Booking;
import org.scaler.bms5thmay.models.Show;
import org.scaler.bms5thmay.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class BookingService {

    private UserRepository userRepo;
    private ShowRepository showRepo;

    public BookingService(UserRepository userRepo, ShowRepository showRepo){
        this.userRepo = userRepo;
        this.showRepo = showRepo;
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


        // TODO: complete step 3, 5, 6,7(Except save), 9




    return null;

    }

}
