package com.infra_app.controller;

import com.infra_app.dto.DistrictDto;
import com.infra_app.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<DistrictDto>> getAllDistricts(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(districtService.getAllDistricts(username));
    }

    @GetMapping("/by-zone/{zoneId}")
    public ResponseEntity<List<DistrictDto>> getDistrictsByZone(@PathVariable Long zoneId,
                                                                @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(districtService.getDistrictsByZoneId(zoneId, username));
    }
}

