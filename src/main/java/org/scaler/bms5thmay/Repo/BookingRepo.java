package org.scaler.bms5thmay.Repo;

import org.scaler.bms5thmay.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    Booking save(Booking b);
}
