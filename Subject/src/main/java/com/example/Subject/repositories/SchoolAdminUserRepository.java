package com.example.Subject.repositories;

import com.example.Subject.models.SchoolAdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolAdminUserRepository extends JpaRepository<SchoolAdminUser, Long> {
    SchoolAdminUser findByUsername(String username);
}
