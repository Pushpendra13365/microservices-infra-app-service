package com.infra_app.controller;

import com.infra_app.dto.MandalDto;
import com.infra_app.service.MandalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mandals")
@RequiredArgsConstructor
public class MandalController {

    private final MandalService mandalService;

    @GetMapping
    public ResponseEntity<List<MandalDto>> getAllMandals(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(mandalService.getAllMandals(username));
    }

    @GetMapping("/district/{districtId}")
    public ResponseEntity<List<MandalDto>> getMandalsByDistrictId(@PathVariable Long districtId,
                                                                  @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(mandalService.getMandalsByDistrictId(districtId, username));
    }
}
