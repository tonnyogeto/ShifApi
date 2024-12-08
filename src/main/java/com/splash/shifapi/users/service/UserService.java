package com.splash.shifapi.users.service;

import com.splash.shifapi.infrastructure.exceptions.ResourceNotFoundException;
import com.splash.shifapi.users.dao.UserDao;
import com.splash.shifapi.users.dto.UserCreationDto;
import com.splash.shifapi.users.dto.UserFetchDto;
import com.splash.shifapi.users.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<UserFetchDto> getAllUsers() {
        List<User> allUsers=  userDao.findAll();

        List<UserFetchDto> dtos = new ArrayList<>();

        for(User u: allUsers){
            UserFetchDto dto =convertToDto(u);
            dtos.add(dto);
        }

        return dtos;
    }


    public UserFetchDto getUserById(Integer userId) {
        User user =getPersonByIdOrElseThrow(userId);
        return convertToDto(user);
    }

    public User getPersonByIdOrElseThrow(Integer userId){
        Optional<User> userOptional =userDao.findById(userId);
        if(userOptional.isPresent()){
            return userOptional.get();
        } else{
            throw new ResourceNotFoundException(String.format("User with id %d not found", userId));
        }
    }

    @Transactional
    public void createUser(UserCreationDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setIdNo(dto.getIdNo());
        user.setImagePath(dto.getImagePath());
        userDao.save(user);
    }



    public void updateUser(UserCreationDto dto, Integer userId) {
        User user = getPersonByIdOrElseThrow(userId);
        user.setName(dto.getName());
        user.setImagePath(dto.getImagePath());
        user.setIdNo(dto.getIdNo());
        userDao.save(user);

    }

    public static UserFetchDto convertToDto(User u) {
        UserFetchDto dto =new UserFetchDto();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setIdNo(u.getIdNo());
        dto.setImagePath(u.getImagePath());
        return dto;
    }

    public void deleteUserById(Integer userId) {
        User user = getPersonByIdOrElseThrow(userId);
        userDao.delete(user);
    }
}
