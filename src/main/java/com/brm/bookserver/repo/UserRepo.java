package com.brm.bookserver.repo;

import com.brm.bookserver.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Registration, Long> {
    Optional<Registration>findByCode(String code);

}
