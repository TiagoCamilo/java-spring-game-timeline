package com.braveplayers.timeline.controllers;

import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.services.RegisterService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class RegisterControllers {
    private final RegisterService service;

    public RegisterControllers(RegisterService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Register> findAll() {
        return service.findAll().log();
    }

    @PostMapping
    public Mono<Register> save(@RequestBody Register register) {
        return service.save(register);
    }
}
