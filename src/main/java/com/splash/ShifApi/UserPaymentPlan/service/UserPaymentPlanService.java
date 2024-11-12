package com.splash.ShifApi.UserPaymentPlan.service;

import com.splash.ShifApi.UserPaymentPlan.dao.UserPaymentPlanDao;
import com.splash.ShifApi.UserPaymentPlan.dto.UserPaymentPlanCreationDto;
import com.splash.ShifApi.UserPaymentPlan.dto.UserPaymentPlanFetchDto;
import com.splash.ShifApi.UserPaymentPlan.model.UserPaymentPlan;
import com.splash.ShifApi.infrastructure.exceptions.ResourceNotFoundException;
import com.splash.ShifApi.users.model.User;
import com.splash.ShifApi.users.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserPaymentPlanService {
    
    @Autowired
    UserPaymentPlanDao userPaymentPlanDao;
    
    @Autowired
    UserService userService;

    public List<UserPaymentPlanFetchDto> getAllUserPaymentPlans() {

        List<UserPaymentPlan> paymentPlans = userPaymentPlanDao.findAll();
        List <UserPaymentPlanFetchDto>  dtos = new ArrayList<>();
        
        for(UserPaymentPlan p:paymentPlans){
            UserPaymentPlanFetchDto dto = convertToDto(p);
            dtos.add(dto);
        }
      return dtos;  
    }
    
    public static UserPaymentPlanFetchDto convertToDto(UserPaymentPlan p){
        UserPaymentPlanFetchDto dto = new UserPaymentPlanFetchDto();
        dto.setPaymentPlan(p.getPaymentPlan());
        dto.setAmount(p.getAmount());
        User user = p.getUser();
        if(user != null){
            dto.setUser(UserService.convertToDto(user));
        }
        return dto;
    }

    public UserPaymentPlanFetchDto getUserPaymentPlanById(Integer planId) {
        UserPaymentPlan paymentPlan = getUserPaymentPlanByIdOrElseThow(planId);
        return convertToDto(paymentPlan);
    }

    private UserPaymentPlan getUserPaymentPlanByIdOrElseThow(Integer planId) {
        Optional<UserPaymentPlan> userPaymentPlanOptional=userPaymentPlanDao.findById(planId);
        if(userPaymentPlanOptional.isPresent()){
            return userPaymentPlanOptional.get();
        }else {
            throw new ResourceNotFoundException(String.format("UserPaymentPlan with id %d not found ",planId ));
        }
    }

    @Transactional
    public void createUserPaymentPlan(UserPaymentPlanCreationDto dto) {
        User user= userService.getPersonByIdOrElseThrow(dto.getUserId());
        UserPaymentPlan userPaymentPlan= new UserPaymentPlan();
        userPaymentPlan.setUser(user);
        userPaymentPlan.setAmount(dto.getAmount());
        userPaymentPlan.setPaymentPlan(dto.getPaymentPlan());
        userPaymentPlanDao.save(userPaymentPlan);
    }

    public void updateUserPaymentPlan(Integer planId, UserPaymentPlanCreationDto dto) {
        UserPaymentPlan userPaymentPlan = getUserPaymentPlanByIdOrElseThow(planId);
        User user = userService.getPersonByIdOrElseThrow(dto.getUserId());
        userPaymentPlan.setUser(user);
        userPaymentPlan.setAmount(dto.getAmount());
        userPaymentPlan.setPaymentPlan(dto.getPaymentPlan());
        userPaymentPlanDao.save(userPaymentPlan);
    }

    public void deleteUserPaymentPlan(Integer planId) {
        UserPaymentPlan userPaymentPlan=getUserPaymentPlanByIdOrElseThow(planId);
        userPaymentPlanDao.delete(userPaymentPlan);
    }
}
