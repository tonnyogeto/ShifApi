package com.splash.ShifApi.payments.controller;

import com.splash.ShifApi.infrastructure.Response.ApiResponse;
import com.splash.ShifApi.payments.dto.PaymentCreationDto;
import com.splash.ShifApi.payments.dto.PaymentFetchDto;
import com.splash.ShifApi.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getAllPayments(){
        List<PaymentFetchDto> payments = paymentService.getAllPayments();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", payments)
        );
    }


    @GetMapping("/{paymentId}")
    public ResponseEntity<?> getPaymentById(
            @PathVariable("paymentId") Integer paymentId
    ){
        PaymentFetchDto dto = paymentService.getPaymentById(paymentId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", dto)
        );
    }


    @PostMapping
    public ResponseEntity<?> createPayment(
            @RequestBody PaymentCreationDto dto
            ){
        paymentService.createPayment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("success", null)
        );
    }


    @PutMapping("/{paymentId}")
    public ResponseEntity<?> updatePayment(
            @PathVariable("paymentId") Integer paymentId,
            @RequestBody PaymentCreationDto dto
    ){
        paymentService.updatePayment(paymentId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }


    @DeleteMapping("/{paymentId}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("paymentId") Integer paymentId
    ){
        paymentService.deletePayment(paymentId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null)
        );
    }

}
