package com.splash.ShifApi.claims.dto;

import com.splash.ShifApi.claims.model.Status;
import lombok.Data;

@Data
public class ClaimCreationDto {
    private Status status;
    private Integer visitId;
}
