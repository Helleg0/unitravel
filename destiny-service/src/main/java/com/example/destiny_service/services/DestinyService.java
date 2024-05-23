package com.example.destiny_service.services;

import com.example.destiny_service.model.dtos.DestinyRequest;
import com.example.destiny_service.model.dtos.DestinyResponse;
import com.example.destiny_service.model.entities.Destiny;
import com.example.destiny_service.repositories.DestinyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinyService {

    private final DestinyRepository destinyRepository;

    public void addDestiny(DestinyRequest destinyRequest){

        var destiny = Destiny.builder()
                .id(destinyRequest.getId())
                .name(destinyRequest.getName())
                .description(destinyRequest.getDescription())
                .price(destinyRequest.getPrice())
                .place(destinyRequest.getPlace()).build();

        destinyRepository.save(destiny);

        log.info("Destiny added:{}",destiny);
    }

    public List<DestinyResponse> getAllDestiny(){
        var destiny = destinyRepository.findAll();

        return destiny.stream().map(this::mapToUserResponse).toList();
    }

    private DestinyResponse mapToUserResponse(Destiny destiny){
        return DestinyResponse.builder()
                .id(destiny.getId())
                .name(destiny.getName())
                .description(destiny.getDescription())
                .price(destiny.getPrice())
                .place(destiny.getPlace()).build();
    }

    public void updateDestiny(DestinyRequest destinyRequest){
        Optional<Destiny> optionalDestiny = destinyRepository.findById(destinyRequest.getId());

        if (optionalDestiny.isPresent()){
            Destiny destiny = optionalDestiny.get();

            destiny.setName(destinyRequest.getName());
            destiny.setDescription(destinyRequest.getDescription());
            destiny.setPrice(destinyRequest.getPrice());
            destiny.setPlace(destinyRequest.getPlace());

            destinyRepository.save(destiny);

            log.info("destiny updated: {}", destiny);

        }else {
            log.error("destiny with ID {} not found", destinyRequest.getId());
        }
    }

    public void deleteDestiny(Long destinyId){

        Optional<Destiny> optionalDestiny = destinyRepository.findById(destinyId);

        if (optionalDestiny.isPresent()){
            destinyRepository.deleteById(destinyId);
        }else {
            throw new NoSuchElementException("destiny with ID"+destinyId+"not found");
        }
    }

}
