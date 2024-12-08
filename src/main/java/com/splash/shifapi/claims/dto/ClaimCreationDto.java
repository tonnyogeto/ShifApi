package com.splash.shifapi.claims.dto;

import com.splash.shifapi.claims.model.Status;
import lombok.Data;

@Data
public class ClaimCreationDto {
    private Status status;
    private Integer visitId;
}
