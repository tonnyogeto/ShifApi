package com.splash.shifapi.hospitalvisits.dto;

import com.splash.shifapi.users.dto.UserFetchDto;
import lombok.Data;

import java.util.Date;

@Data
public class HospitalVisitFetchDto {
    private UserFetchDto user;
    private Date currentDate= new Date();
}
