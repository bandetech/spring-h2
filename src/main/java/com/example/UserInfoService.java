package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;
   
    public List<UserInfo> getUserInfos(){
        return repository.findAll();
    }

    public List<UserInfo> getUserInfo(String name){
        log.info("getUserInfo called!!");
        return repository.findByName(name);
    }

    public List<UserInfo> getUserInfoLike(String name){
        
        return repository.findByNameLike(name);
    }

    public Integer addUser(UserInfo user){
        UserInfo registeredUser = repository.save(user);
        return registeredUser.getId();
    }

}
