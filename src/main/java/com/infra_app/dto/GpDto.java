package com.infra_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GpDto {
    private Long id;
    private Long mandalId;
    private String name;
    private String code;
}
