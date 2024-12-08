package com.splash.shifapi.claims.dto;

import com.splash.shifapi.claims.model.Status;
import com.splash.shifapi.hospitalvisits.dto.HospitalVisitFetchDto;
import lombok.Data;

@Data
public class ClaimFetchDto {

    private Status status;
    private HospitalVisitFetchDto visit;
}
