package com.example.demo.controller;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    UserInfoService userService;

    @Autowired
    AccountService accountService;

    @Operation(summary = "Get user information based on id")
    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfoDTO> getUser(@PathVariable("id") Long id){
        UserInfoDTO userInfoDTO =   userService.getUserInfoByUserId(id);
        return new ResponseEntity<UserInfoDTO>(userInfoDTO,HttpStatus.OK);
    }

    @Operation(summary = "Create a new user")
    @PostMapping("/createuser")
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody UserInfoDTO userinfo){
        UserInfoDTO userinfo1 = userService.createUser(userinfo);
         return new ResponseEntity<>(userinfo1,HttpStatus.CREATED);
    }

    @Operation(summary = "Delete user information based on id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserInfoDTO> deleteUser(@PathVariable("id") long userId){
        userService.deleteUserInfoById(userId);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete user information")
    @DeleteMapping("/delete")
    public ResponseEntity<UserInfoDTO> deleteUser(UserInfoDTO userInfo){
        userService.deleteUserInfo(userInfo);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get Users based on parameters: firstname, lastname, userid")
    @GetMapping("/users")
    public ResponseEntity<List<UserInfoDTO>> getUsers( @RequestParam Map<String,String> mapParams){
        log.info("In the getusers method::"  + ":" + mapParams);
        String firstname = mapParams.get("firstname");
        List<UserInfoDTO> lstUsers = null;
        if(StringUtil.isNullOrEmpty(firstname)){
            lstUsers = userService.getAllUsers();
        } else {
            UserInfoDTO userInfoDTO1 = new UserInfoDTO();
            userInfoDTO1.setFirstName(mapParams.get("firstname"));
            userInfoDTO1.setLastName(mapParams.get("lastname"));
            if (null != mapParams.get("userid"))
                userInfoDTO1.setId(Long.parseLong(mapParams.get("userid")));
            lstUsers = userService.getUserInfoList(userInfoDTO1);
        }
            log.info("List of Users:" + lstUsers);
        return new ResponseEntity<>(lstUsers,HttpStatus.OK);
    }

    @Operation(summary = "Get all users")
    @GetMapping("/allusers")
    public ResponseEntity<List<UserInfoDTO>> getUsers(){
        List<UserInfoDTO> lstUsers = userService.getAllUsers();
        log.info("List:" + lstUsers);
        return new ResponseEntity<>(lstUsers,HttpStatus.OK);
    }

    //TODO work in progress - include list of accounts in User object
    @Operation(summary = "Create a new account for a user")
    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        log.info("Creating a new account" + account);
        return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.OK);
    }

}
