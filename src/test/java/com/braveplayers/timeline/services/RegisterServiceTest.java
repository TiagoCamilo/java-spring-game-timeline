package com.braveplayers.timeline.services;

import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.repositories.RegisterRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RegisterServiceTest {

    RegisterService service;

    @Mock
    RegisterRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new RegisterServiceImpl(repository);
    }

    @SneakyThrows
    @Test
    public void save_MonoOfRegister() {
        Register entity = Register.builder().build();
        Mono<Register> monoEntity = Mono.just(entity);
        when(repository.save(entity)).thenReturn(monoEntity);

        Mono<Register> monoEntitySaved = service.save(entity);

        assertEquals(monoEntity, monoEntitySaved);
        verify(repository, times(1)).save(entity);
    }

    @SneakyThrows
    @Test
    public void findAllByWorld_FluxOfRegister() {
        Flux<Register> fluxEntity = Flux.just(mock(Register.class));
        when(repository.findAll()).thenReturn(fluxEntity);

        Flux<Register> fluxEntityFound = service.findAll();

        assertEquals(fluxEntity, fluxEntityFound);
        verify(repository, times(1)).findAll();
    }
}
