package com.example.destiny_service.repositories;

import com.example.destiny_service.model.entities.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinyRepository extends JpaRepository<Destiny,Long> {
}
