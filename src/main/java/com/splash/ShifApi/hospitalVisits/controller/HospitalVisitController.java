package com.splash.ShifApi.hospitalVisits.controller;

import com.splash.ShifApi.hospitalVisits.dto.HospitalVisitCreationDto;
import com.splash.ShifApi.hospitalVisits.dto.HospitalVisitFetchDto;
import com.splash.ShifApi.hospitalVisits.service.HospitalVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class HospitalVisitController {

    @Autowired
    HospitalVisitService hospitalVisitService;

    @GetMapping
    public ResponseEntity<?> getAllHospitalVisits(){
        List<HospitalVisitFetchDto> visits =hospitalVisitService.getAllHospitalVisits();
        return ResponseEntity.status(HttpStatus.OK).body(visits);
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<?> getVisitById(
            @PathVariable("visitId") Integer visitId
    ){
        HospitalVisitFetchDto visit=hospitalVisitService.getVisitById(visitId);
        return ResponseEntity.status(HttpStatus.OK).body(visit);
    }

    @PostMapping
    public ResponseEntity<?> createHospitalVisit(
            @RequestBody HospitalVisitCreationDto dto
    ){
        hospitalVisitService.createHospitalVisit(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");

    }

    @PutMapping("/visitId")
    public ResponseEntity<?> updateHospitalVisit(
            @PathVariable("visitId") Integer visitId,
            @RequestBody HospitalVisitCreationDto dto
    ){
        hospitalVisitService.updateHospitalVisit(dto, visitId);
        return ResponseEntity.status(HttpStatus.OK).body("updated successfully");
    }

    @DeleteMapping("/visitId")
    public ResponseEntity<?> deleteHospitalVisit(
            @PathVariable("visitId") Integer visitId
    ){
        hospitalVisitService.deleteHospitalVisit(visitId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }

}
