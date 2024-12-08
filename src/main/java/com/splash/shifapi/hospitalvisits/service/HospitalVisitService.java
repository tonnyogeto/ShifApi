package com.splash.shifapi.hospitalvisits.service;

import com.splash.shifapi.hospitalvisits.dao.HospitalVisitDao;
import com.splash.shifapi.hospitalvisits.dto.HospitalVisitCreationDto;
import com.splash.shifapi.hospitalvisits.dto.HospitalVisitFetchDto;
import com.splash.shifapi.hospitalvisits.model.HospitalVisit;
import com.splash.shifapi.infrastructure.exceptions.ResourceNotFoundException;
import com.splash.shifapi.users.model.User;
import com.splash.shifapi.users.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalVisitService {

    @Autowired
    HospitalVisitDao hospitalVisitDao;

    @Autowired
    UserService userService;


    public List<HospitalVisitFetchDto> getAllHospitalVisits() {
        List<HospitalVisit> visits = hospitalVisitDao.findAll();

        List<HospitalVisitFetchDto> dtos = new ArrayList<>();
        for(HospitalVisit h: visits){
            HospitalVisitFetchDto dto = convertToDto(h);
            dtos.add(dto);
        }
        return dtos;
    }

    public HospitalVisitFetchDto getVisitById(Integer visitId) {
        HospitalVisit visit = getVisitByIdOrElseThrow(visitId);
        return convertToDto(visit);

    }

    public HospitalVisit getVisitByIdOrElseThrow(Integer visitId){
        Optional<HospitalVisit> hospitalVisitOptional = hospitalVisitDao.findById(visitId);
        if(hospitalVisitOptional.isPresent()){
            return hospitalVisitOptional.get();
        }else{
            throw new ResourceNotFoundException(String.format("Visit with id %d not found", visitId));
        }
    }


    public static HospitalVisitFetchDto convertToDto(HospitalVisit h) {
        HospitalVisitFetchDto dto = new HospitalVisitFetchDto();
        dto.setCurrentDate(h.getCurrentDate());
        User user = h.getUser();
        if (user != null) {
            dto.setUser(UserService.convertToDto(user));
        }
        return dto;
    }



    public void deleteHospitalVisit(Integer visitId) {
        HospitalVisit visit =getVisitByIdOrElseThrow(visitId);
        hospitalVisitDao.delete(visit);

    }

    @Transactional
    public void createHospitalVisit(HospitalVisitCreationDto dto) {
        User user=userService.getPersonByIdOrElseThrow(dto.getUserId());
        HospitalVisit visit =new HospitalVisit();
        visit.setUser(user);
        hospitalVisitDao.save(visit);

    }

    public void updateHospitalVisit(HospitalVisitCreationDto dto, Integer visitId) {
        HospitalVisit visit =getVisitByIdOrElseThrow(visitId);
        User user=userService.getPersonByIdOrElseThrow(dto.getUserId());
        visit.setUser(user);
        hospitalVisitDao.save(visit);
    }
}
