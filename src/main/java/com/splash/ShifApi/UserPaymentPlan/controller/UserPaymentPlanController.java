package com.splash.ShifApi.UserPaymentPlan.controller;

import com.splash.ShifApi.UserPaymentPlan.dto.UserPaymentPlanCreationDto;
import com.splash.ShifApi.UserPaymentPlan.dto.UserPaymentPlanFetchDto;
import com.splash.ShifApi.UserPaymentPlan.service.UserPaymentPlanService;
import com.splash.ShifApi.infrastructure.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userPaymentPlan")
public class UserPaymentPlanController {

    @Autowired
    UserPaymentPlanService userPaymentPlanService;

    @GetMapping
    public ResponseEntity<?> getALlUserPaymentPlans(){
        List<UserPaymentPlanFetchDto> paymentPlans = userPaymentPlanService.getAllUserPaymentPlans();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", paymentPlans)
        );
    }


    @GetMapping("/{planId}")
    public ResponseEntity<?> getUserPaymentPlanById(
            @PathVariable("planId") Integer planId
    ){
        UserPaymentPlanFetchDto dto=userPaymentPlanService.getUserPaymentPlanById(planId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",dto)
        );
    }


    @PostMapping
    public ResponseEntity<?> createUserPaymentPlan(
            @RequestBody UserPaymentPlanCreationDto dto
            ){
        userPaymentPlanService.createUserPaymentPlan(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("success", null)
        );
    }

    @PutMapping("/{planId}")
    public ResponseEntity<?> updateUserPaymentPlan(
            @PathVariable("planId") Integer planId,
            @RequestBody UserPaymentPlanCreationDto dto
    ){
        userPaymentPlanService.updateUserPaymentPlan(planId,dto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }


    @DeleteMapping("/{planId}")
    public ResponseEntity<?> deleteUserPaymentPlan(
            @PathVariable("planId") Integer planId
    ){
        userPaymentPlanService.deleteUserPaymentPlan(planId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }
}
