package com.splash.ShifApi.payments.service;

import com.splash.ShifApi.infrastructure.exceptions.ResourceNotFoundException;
import com.splash.ShifApi.payments.dao.PaymentDao;
import com.splash.ShifApi.payments.dto.PaymentCreationDto;
import com.splash.ShifApi.payments.dto.PaymentFetchDto;
import com.splash.ShifApi.payments.model.Payment;
import com.splash.ShifApi.users.model.User;
import com.splash.ShifApi.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentDao paymentDao;

    @Autowired
    UserService userService;

    public List<PaymentFetchDto> getAllPayments() {
        List<Payment> payments = paymentDao.findAll();
        List<PaymentFetchDto> dtos = new ArrayList<>();

        for(Payment k: payments){
            PaymentFetchDto dto = convertToDto(k);
            dtos.add(dto);
        }
        return dtos;
    }

    private static PaymentFetchDto convertToDto(Payment k) {
        PaymentFetchDto dto=new PaymentFetchDto();
        dto.setAmount(k.getAmount());
        User user = k.getUser();
        if(user != null){
            dto.setUser(UserService.convertToDto(user));
        }
        return dto;
    }


    public PaymentFetchDto getPaymentById(Integer paymentId) {
        Payment payment = getPaymentByIdOrElseThrow(paymentId);
        return convertToDto(payment);

    }

    private Payment getPaymentByIdOrElseThrow(Integer paymentId) {
        Optional<Payment> paymentOptional = paymentDao.findById(paymentId);
        if(paymentOptional.isPresent()){
            return paymentOptional.get();
        }else {
            throw new ResourceNotFoundException(String.format("Payment with id %d not found", paymentId));
        }
    }

    public void createPayment(PaymentCreationDto dto) {
        User user =userService.getPersonByIdOrElseThrow(dto.getUserId());
        Payment payment=new Payment();
        payment.setUser(user);
        payment.setAmount(dto.getAmount());
        paymentDao.save(payment);
    }


    public void updatePayment(Integer paymentId, PaymentCreationDto dto) {
        Payment payment=getPaymentByIdOrElseThrow(paymentId);
        User user = userService.getPersonByIdOrElseThrow(dto.getUserId());
        payment.setUser(user);
        payment.setAmount(dto.getAmount());
        paymentDao.save(payment);
    }

    public void deletePayment(Integer paymentId) {
        Payment payment=getPaymentByIdOrElseThrow(paymentId);
        paymentDao.delete(payment);
    }
}
