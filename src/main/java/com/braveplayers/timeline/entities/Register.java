package com.braveplayers.timeline.entities;

import com.braveplayers.timeline.enums.RegisterType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Register {

    @Id
    private String id;
    private RegisterType type;
    private String world;
    private Character character;
    private String oldValue;
    private String newValue;
}
