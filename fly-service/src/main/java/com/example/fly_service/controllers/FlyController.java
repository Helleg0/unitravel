package com.example.fly_service.controllers;

import com.example.fly_service.model.dtos.FlyRequest;
import com.example.fly_service.model.dtos.FlyResponse;
import com.example.fly_service.services.FlyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fly")
@RequiredArgsConstructor
public class FlyController {

    private final FlyService flyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFly(@RequestBody FlyRequest flyRequest){this.flyService.addFly(flyRequest);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlyResponse> getAllFlys(){
        return this.flyService.getAllFlys();
    }

    @PutMapping("/{flyId}")
    public void updateFly(@PathVariable Long flyId, @RequestBody FlyRequest flyRequest) {
        flyRequest.setId(flyId);
        this.flyService.updateUser(flyRequest);
    }

    @DeleteMapping("/{flyId}")
    public void deleteFly(@PathVariable Long flyId) {
        this.flyService.deleteFly(flyId);
    }

}

