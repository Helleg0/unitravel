package com.example.accommodation_service.controllers;

import com.example.accommodation_service.model.dtos.AccommodationRequest;
import com.example.accommodation_service.model.dtos.AccommodationResponse;
import com.example.accommodation_service.services.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  addAccommodation(@RequestBody AccommodationRequest accommodationRequest){
        this.accommodationService.addAccommodation(accommodationRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccommodationResponse> getAllAccommodations(){
        return this.accommodationService.getAllAccommodations();
    }

    @PutMapping("/{accommodationId}")
    public void editAccommodation(@PathVariable Long accommodationId, @RequestBody AccommodationRequest accommodationRequest) {
        accommodationRequest.setId(accommodationId);
        this.accommodationService.updateAccommodation(accommodationRequest);
    }
}
