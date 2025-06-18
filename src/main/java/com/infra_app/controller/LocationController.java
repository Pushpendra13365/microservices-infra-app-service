package com.infra_app.controller;

import com.infra_app.dto.ApiResponse;
import com.infra_app.dto.LocationDto;
import com.infra_app.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/location")
    public ResponseEntity<List<LocationDto>> getAllLocations(
            @RequestHeader("Authorization") String token,
            @RequestParam Long userId,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        log.info("User {} requesting location list", userDetails.getUsername());
        List<LocationDto> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
}

