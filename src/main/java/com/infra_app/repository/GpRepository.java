package com.infra_app.repository;

import com.infra_app.model.Gp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GpRepository extends JpaRepository<Gp, Long> {
    List<Gp> findByMandalId(Long mandalId);
}

