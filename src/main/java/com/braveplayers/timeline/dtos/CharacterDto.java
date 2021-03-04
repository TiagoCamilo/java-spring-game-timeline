package com.braveplayers.timeline.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterDto {
    private Integer id;
    private String name;
    private Integer level;
    private String guildName;
    private String worldName;
    private String vocation;
}
