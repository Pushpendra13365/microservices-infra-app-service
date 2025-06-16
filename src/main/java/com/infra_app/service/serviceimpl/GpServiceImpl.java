package com.infra_app.service.serviceimpl;

import com.infra_app.dto.GpDto;
import com.infra_app.model.Gp;
import com.infra_app.repository.GpRepository;
import com.infra_app.service.GpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GpServiceImpl implements GpService {

    private final GpRepository gpRepository;

    @Override
    public List<GpDto> getGpsByMandalId(Long mandalId, String username) {
        log.info("User '{}' requested GPs for mandalId {}", username, mandalId);
        return gpRepository.findByMandalId(mandalId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private GpDto convertToDto(Gp gp) {
        return new GpDto(gp.getId(), gp.getMandal().getId(), gp.getName(), gp.getCode());
    }
}

