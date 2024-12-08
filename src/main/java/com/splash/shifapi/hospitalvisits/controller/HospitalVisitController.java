package com.splash.shifapi.hospitalvisits.controller;

import com.splash.shifapi.hospitalvisits.dto.HospitalVisitCreationDto;
import com.splash.shifapi.hospitalvisits.dto.HospitalVisitFetchDto;
import com.splash.shifapi.hospitalvisits.service.HospitalVisitService;
import com.splash.shifapi.infrastructure.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class HospitalVisitController {

    @Autowired
    HospitalVisitService hospitalVisitService;

    @GetMapping
    public ResponseEntity<?> getAllHospitalVisits(){
        List<HospitalVisitFetchDto> visits =hospitalVisitService.getAllHospitalVisits();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",visits));
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<?> getVisitById(
            @PathVariable("visitId") Integer visitId
    ){
        HospitalVisitFetchDto visit=hospitalVisitService.getVisitById(visitId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",visit));
    }

    @PostMapping
    public ResponseEntity<?> createHospitalVisit(
            @RequestBody HospitalVisitCreationDto dto
    ){
        hospitalVisitService.createHospitalVisit(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("success", null));

    }

    @PutMapping("/{visitId}")
    public ResponseEntity<?> updateHospitalVisit(
            @PathVariable("visitId") Integer visitId,
            @RequestBody HospitalVisitCreationDto dto
    ){
        hospitalVisitService.updateHospitalVisit(dto, visitId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null));
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<?> deleteHospitalVisit(
            @PathVariable("visitId") Integer visitId
    ){
        hospitalVisitService.deleteHospitalVisit(visitId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null));
    }

}
