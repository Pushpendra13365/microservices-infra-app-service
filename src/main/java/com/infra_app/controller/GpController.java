package com.infra_app.controller;

import com.infra_app.dto.GpDto;
import com.infra_app.service.GpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gps")
@RequiredArgsConstructor
public class GpController {

    private final GpService gpService;

    @GetMapping("/mandal/{mandalId}")
    public ResponseEntity<List<GpDto>> x(@PathVariable Long mandalId,
                                                        @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(gpService.getGpsByMandalId(mandalId, username));
    }
}

