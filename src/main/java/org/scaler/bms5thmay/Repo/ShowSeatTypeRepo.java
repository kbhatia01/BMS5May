package org.scaler.bms5thmay.Repo;

import org.scaler.bms5thmay.models.Show;
import org.scaler.bms5thmay.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show s);
}
