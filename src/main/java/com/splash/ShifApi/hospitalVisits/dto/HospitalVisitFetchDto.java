package com.splash.ShifApi.hospitalVisits.dto;

import com.splash.ShifApi.users.dto.UserFetchDto;
import com.splash.ShifApi.users.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class HospitalVisitFetchDto {
    private UserFetchDto user;
    private Date currentDate= new Date();
}
