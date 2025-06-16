package com.infra_app.repository;

import com.infra_app.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByZoneId(Long zoneId);
}
