package com.infra_app.service;

import com.infra_app.dto.LocationDto;
import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocations();
}
