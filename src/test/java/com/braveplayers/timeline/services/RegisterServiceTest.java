package com.braveplayers.timeline.services;

import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.repositories.RegisterRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

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
        when(repository.save(entity)).thenReturn(Mono.just(entity));

        Register entitySaved = service.save(entity).toFuture().get();

        assertEquals(entity, entitySaved);
        verify(repository, times(1)).save(entity);
    }
}
