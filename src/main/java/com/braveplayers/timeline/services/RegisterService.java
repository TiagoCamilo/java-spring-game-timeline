package com.braveplayers.timeline.services;

import com.braveplayers.timeline.entities.Register;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegisterService {
    Mono<Register> save(Register register);

    Flux<Register> findAll();
}
