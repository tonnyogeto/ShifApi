package com.splash.ShifApi.claims.dto;

import com.splash.ShifApi.claims.model.Status;
import com.splash.ShifApi.hospitalVisits.dto.HospitalVisitFetchDto;
import lombok.Data;

@Data
public class ClaimFetchDto {

    private Status status;
    private HospitalVisitFetchDto visit;
}
