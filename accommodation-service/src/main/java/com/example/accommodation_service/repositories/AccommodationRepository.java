package com.example.accommodation_service.repositories;

import com.example.accommodation_service.model.entieties.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
}
