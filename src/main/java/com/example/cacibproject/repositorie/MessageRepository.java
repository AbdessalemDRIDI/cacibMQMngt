package com.example.cacibproject.repositorie;

import com.example.cacibproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Custom queries if necessary
}