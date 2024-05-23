package com.example.destiny_service.controllers;

import com.example.destiny_service.model.dtos.DestinyRequest;
import com.example.destiny_service.model.dtos.DestinyResponse;
import com.example.destiny_service.services.DestinyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destiny")
@RequiredArgsConstructor
public class DestinyController {
    private final DestinyService destinyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  addDestiny(@RequestBody DestinyRequest destinyRequest){
        this.destinyService.addDestiny(destinyRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DestinyResponse> getAllDestiny(){
        return this.destinyService.getAllDestiny();
    }

    @PutMapping("/{destinyId}")
    public void updateDestiny(@PathVariable Long destinyId, @RequestBody DestinyRequest destinyRequest) {
        destinyRequest.setId(destinyId);
        this.destinyService.updateDestiny(destinyRequest);
    }

    @DeleteMapping("/{destinyId}")
    public void deleteDestiny(@PathVariable Long destinyId) {
        this.destinyService.deleteDestiny(destinyId);
    }

}
