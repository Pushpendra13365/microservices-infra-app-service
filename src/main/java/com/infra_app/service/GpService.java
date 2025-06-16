package com.infra_app.service;

import com.infra_app.dto.GpDto;

import java.util.List;

public interface GpService {
    List<GpDto> getGpsByMandalId(Long mandalId, String username);
}
