package com.infra_app.service.serviceimpl;

import com.infra_app.dto.MandalDto;
import com.infra_app.model.Mandal;
import com.infra_app.repository.MandalRepository;
import com.infra_app.service.MandalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MandalServiceImpl implements MandalService {

    private final MandalRepository mandalRepository;

    @Override
    public List<MandalDto> getAllMandals(String username) {
        log.info("User '{}' accessed all mandals", username);
        return mandalRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MandalDto> getMandalsByDistrictId(Long districtId, String username) {
        log.info("User '{}' accessed mandals for districtId {}", username, districtId);
        return mandalRepository.findByDistrictId(districtId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private MandalDto convertToDto(Mandal mandal) {
        return new MandalDto(
                mandal.getId(),
                mandal.getDistrict().getId(),
                mandal.getName()
        );
    }
}


