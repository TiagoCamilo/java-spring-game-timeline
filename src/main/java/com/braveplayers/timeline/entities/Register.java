package com.braveplayers.timeline.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Register {

    @Id
    private String id;
    private String content;

    public Register(String content) {
        this.content = content;
    }
}
