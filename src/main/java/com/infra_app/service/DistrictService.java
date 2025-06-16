package com.infra_app.service;

import com.infra_app.dto.DistrictDto;
import com.infra_app.model.District;

import java.util.List;

public interface DistrictService {
    List<DistrictDto> getAllDistricts(String username);
    List<DistrictDto> getDistrictsByZoneId(Long zoneId, String username);
}

