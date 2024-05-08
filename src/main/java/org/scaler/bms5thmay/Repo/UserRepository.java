package org.scaler.bms5thmay.Repo;

import org.scaler.bms5thmay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);
    // SELECT * FROM User where id = aLong

//    Optional<User> findByEmailAndPassword(String email, String password);

}
