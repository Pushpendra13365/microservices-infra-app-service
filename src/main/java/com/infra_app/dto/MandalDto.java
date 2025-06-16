package com.infra_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MandalDto {
    private Long id;
    private Long districtId;
    private String name;
}


