package com.infra_app.service;

import com.infra_app.model.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> getAllZones(String username);
}
