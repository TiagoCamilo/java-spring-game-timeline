package com.braveplayers.timeline.services;

import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.repositories.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository repository;

    public Mono<Register> save(Register register) {
        return repository.save(register);
    }

    @Override
    public Flux<Register> findAll() {
        return repository.findAll();
    }
}
