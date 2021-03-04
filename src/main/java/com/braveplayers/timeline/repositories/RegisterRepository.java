package com.braveplayers.timeline.repositories;

import com.braveplayers.timeline.entities.Register;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RegisterRepository extends ReactiveMongoRepository<Register, String> {
}
