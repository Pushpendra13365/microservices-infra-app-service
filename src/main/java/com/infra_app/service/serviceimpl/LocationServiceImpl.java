package com.infra_app.service.serviceimpl;

import com.infra_app.dto.LocationDto;
import com.infra_app.exception.NoDataFoundException;
import com.infra_app.model.Location;
import com.infra_app.repository.LocationRepository;
import com.infra_app.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<LocationDto> getAllLocations() {
        log.info("Fetching all locations from DB");
        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            throw new NoDataFoundException("No locations found in database.");
        }

        return locations.stream()
                .map(location -> LocationDto.builder()
                        .id(location.getId())
                        .name(location.getName())
                        .build())
                .collect(Collectors.toList());
    }
}

