package com.example.fly_service.services;

import com.example.fly_service.model.dtos.FlyRequest;
import com.example.fly_service.model.dtos.FlyResponse;
import com.example.fly_service.model.entities.Fly;
import com.example.fly_service.repositories.FlyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class FlyService {
    private final FlyRepository flyRepository;
    public void addFly(FlyRequest flyRequest){
        var fly = Fly.builder()
                .id(flyRequest.getId())
                .idPlane(flyRequest.getId_plane())
                .dateFly(flyRequest.getDate_fly())
                .departureCity(flyRequest.getDeparture_city())
                .arriveCity(flyRequest.getArrive_city()).build();

        flyRepository.save(fly);
        log.info("fly added: {}",fly);
    }

    public List<FlyResponse> getAllFlys(){
        var flys = flyRepository.findAll();

        return flys.stream().map(this::mapToUserResponse).toList();
    }

    private FlyResponse mapToUserResponse(Fly fly){
        return FlyResponse.builder()
                .id(fly.getId())
                .id_plane(fly.getIdPlane())
                .date_fly(fly.getDateFly())
                .departure_city(fly.getDepartureCity())
                .arrive_city(fly.getArriveCity()).build();
    }

    public void updateUser(FlyRequest flyRequest){
        Optional<Fly> optionalFly = flyRepository.findById(flyRequest.getId());

        if (optionalFly.isPresent()){
            Fly fly = optionalFly.get();

            fly.setIdPlane(flyRequest.getId_plane());
            fly.setDateFly(flyRequest.getDate_fly());
            fly.setDepartureCity(flyRequest.getDeparture_city());
            fly.setArriveCity(flyRequest.getArrive_city());

            flyRepository.save(fly);

            log.info("fly updated: {}", fly);

        }else {
            log.error("fly with ID {} not found", flyRequest.getId());
        }
    }

    public void deleteFly(Long flyId){

        Optional<Fly> optionalFly = flyRepository.findById(flyId);

        if (optionalFly.isPresent()){
            flyRepository.deleteById(flyId);
        }else {
            throw new NoSuchElementException("Fly with ID"+flyId+"not found");
        }
    }
}
