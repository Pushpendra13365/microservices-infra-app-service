package com.infra_app.service.serviceimpl;

import com.infra_app.dto.DistrictDto;
import com.infra_app.model.District;
import com.infra_app.repository.DistrictRepository;
import com.infra_app.service.DistrictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    private DistrictDto toDto(District district) {
        return new DistrictDto(
                district.getId(),
                district.getZone().getId(),
                district.getName()
        );
    }

    @Override
    public List<DistrictDto> getAllDistricts(String username) {
        log.info("User '{}' accessed all districts", username);
        return districtRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DistrictDto> getDistrictsByZoneId(Long zoneId, String username) {
        log.info("User '{}' accessed districts for zoneId {}", username, zoneId);
        return districtRepository.findByZoneId(zoneId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
