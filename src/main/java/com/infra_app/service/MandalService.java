package com.infra_app.service;

import com.infra_app.dto.MandalDto;
import java.util.List;

public interface MandalService {
    List<MandalDto> getAllMandals(String username);
    List<MandalDto> getMandalsByDistrictId(Long districtId, String username);
}

