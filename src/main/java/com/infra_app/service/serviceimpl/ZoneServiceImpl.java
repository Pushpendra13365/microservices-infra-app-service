package com.infra_app.service.serviceimpl;

import com.infra_app.model.Zone;
import com.infra_app.repository.ZoneRepository;
import com.infra_app.service.ZoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;

    @Override
    public List<Zone> getAllZones(String username) {
        log.info("User '{}' accessed zones", username);
        return zoneRepository.findAll();
    }
}

