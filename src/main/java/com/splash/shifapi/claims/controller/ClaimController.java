package com.splash.shifapi.claims.controller;

import com.splash.shifapi.claims.dto.ClaimCreationDto;
import com.splash.shifapi.claims.dto.ClaimFetchDto;
import com.splash.shifapi.claims.service.ClaimService;
import com.splash.shifapi.infrastructure.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping
    public ResponseEntity<?> getAllClaims(){
        List<ClaimFetchDto> claims = claimService.getAllClaims();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", claims)
        );
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<?> getClaimById(
            @PathVariable("claimId") Integer claimId
    ){
        ClaimFetchDto claim = claimService.getClaimById(claimId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",claim)
        );
    }

    @PostMapping
    public ResponseEntity<?> createClaim(
            @RequestBody ClaimCreationDto dto
            ){
        claimService.createClaim(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("success", null)
        );
    }

    @PutMapping("/{claimId}")
    public ResponseEntity<?> updateClaim(
            @PathVariable("claimId") Integer claimId,
            @RequestBody ClaimCreationDto dto
    ){
        claimService.updateClaim(claimId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }

    @DeleteMapping("/{claimId}")
    public ResponseEntity<?>deleteClaim(
            @PathVariable("claimId") Integer claimId
    ){
        claimService.deleteClaim(claimId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }
}
