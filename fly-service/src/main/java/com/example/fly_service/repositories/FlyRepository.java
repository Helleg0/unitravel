package com.example.fly_service.repositories;

import com.example.fly_service.model.entities.Fly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<Fly,Long> {
}
