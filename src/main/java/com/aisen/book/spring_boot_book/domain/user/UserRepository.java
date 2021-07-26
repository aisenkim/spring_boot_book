package com.aisen.book.spring_boot_book.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Identify if user is registered or not
     */
    Optional<User> findByEmail(String email);
}
