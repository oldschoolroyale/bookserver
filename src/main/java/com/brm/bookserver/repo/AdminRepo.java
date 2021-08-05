package com.brm.bookserver.repo;

import com.brm.bookserver.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin>findAdminByUsernameAndPassword(String username, String password);
}
