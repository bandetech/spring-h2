package com.example;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MySampleController {

    @Autowired
    private UserInfoService service;

    @GetMapping("/userinfo")
    public List<UserInfo> getUserInfo(){
        return service.getUserInfos();
    }
    
    @GetMapping("/getUser")
    public List<UserInfo> getUser(@RequestParam(name = "name") String name){
        return service.getUserInfo(name);
    }

    @GetMapping("/getUserLike")
    public List<UserInfo> getUserLike(@RequestParam(name = "name") String name){
        return service.getUserInfoLike(name);
    }

    @PostMapping("/addUser")
    public Integer addUser(@RequestBody UserInfo user){
        log.debug("Called addUser...");
        user.setCreateDatetime(LocalDateTime.now());
        
        return service.addUser(user);
    }


}
