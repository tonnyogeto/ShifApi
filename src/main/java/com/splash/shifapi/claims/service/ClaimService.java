package com.splash.shifapi.claims.service;

import com.splash.shifapi.claims.dao.ClaimDao;
import com.splash.shifapi.claims.dto.ClaimCreationDto;
import com.splash.shifapi.claims.dto.ClaimFetchDto;
import com.splash.shifapi.claims.model.Claim;
import com.splash.shifapi.hospitalvisits.model.HospitalVisit;
import com.splash.shifapi.hospitalvisits.service.HospitalVisitService;
import com.splash.shifapi.infrastructure.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    ClaimDao claimDao;

    @Autowired
    HospitalVisitService hospitalVisitService;

    public List<ClaimFetchDto> getAllClaims(){
        List<Claim> claims = claimDao.findAll();
        List<ClaimFetchDto> dtos = new ArrayList<>();

        for(Claim c: claims){
            ClaimFetchDto dto = convertToDto(c);
            dtos.add(dto);
        }

        return dtos;
    }



    public ClaimFetchDto getClaimById(Integer claimId) {
        Claim claim = getClaimByIdOrElseThrow(claimId);
        return convertToDto(claim);
    }


    public Claim getClaimByIdOrElseThrow(Integer claimId){
        Optional<Claim> claimOptional = claimDao.findById(claimId);
        if(claimOptional.isPresent()){
            return claimOptional.get();
        }else {
            throw new ResourceNotFoundException(String.format("Claim with id %d not found", claimId));
        }
    }


    private static ClaimFetchDto convertToDto(Claim c) {
        ClaimFetchDto dto = new ClaimFetchDto();
        dto.setStatus(c.getStatus());
        HospitalVisit hospitalVisit = c.getHospitalVisit();
        if(hospitalVisit !=null){
            dto.setVisit(HospitalVisitService.convertToDto(hospitalVisit));
        }
        return dto;
    }


    @Transactional
    public void createClaim(ClaimCreationDto dto) {
        HospitalVisit visit=  hospitalVisitService.getVisitByIdOrElseThrow(dto.getVisitId());
        Claim claim = new Claim();
        claim.setStatus(dto.getStatus()); ;
        claim.setHospitalVisit(visit);
        claimDao.save(claim);
    }


    public void updateClaim(Integer claimId, ClaimCreationDto dto) {
        Claim claim = getClaimByIdOrElseThrow(claimId);
        HospitalVisit visit=  hospitalVisitService.getVisitByIdOrElseThrow(dto.getVisitId());
        claim.setHospitalVisit(visit);
        claim.setStatus(dto.getStatus());
        claimDao.save(claim);
    }

    public void deleteClaim(Integer claimId) {
        Claim claim=getClaimByIdOrElseThrow(claimId);
        claimDao.delete(claim);
    }
}
