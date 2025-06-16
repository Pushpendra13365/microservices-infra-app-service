package com.infra_app.repository;

import com.infra_app.model.Mandal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MandalRepository extends JpaRepository<Mandal, Long> {
    List<Mandal> findByDistrictId(Long districtId);
}


