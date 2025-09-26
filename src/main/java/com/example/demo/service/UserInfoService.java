package com.example.demo.service;

import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserInfoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserInfoService {

    @Autowired
    public UserInfoRepository userInfoRepository;

    @Autowired
    UserMapper userMapper;

    public UserInfoDTO getUserInfoByUserId(Long id){
        return userMapper.toDTO(userInfoRepository.findById(id).orElse(null));
    }

    public UserInfoDTO createUser(UserInfoDTO userInfoDTO){
        return userMapper.toDTO(userInfoRepository.save(userMapper.toEntity(userInfoDTO)));
    }

    public UserInfoDTO updateUserInfo(UserInfoDTO userInfoDTO){
        return userMapper.toDTO(userInfoRepository.save(userMapper.toEntity(userInfoDTO)));
    }

    public void deleteUserInfo (UserInfoDTO userInfoDTO){
        userInfoRepository.delete(userMapper.toEntity(userInfoDTO));
    }

    public void deleteUserInfoById (Long userId){
        userInfoRepository.deleteById(userId);
    }

    public List<UserInfoDTO> getUserInfoList(UserInfoDTO userInfoDTO){
        if(null != userInfoDTO.getFirstName() && null != userInfoDTO.getLastName()){
            List<UserInfo> lstUserEntity = userInfoRepository
                    .findByFirstNameAndLastName(userInfoDTO.getFirstName(), userInfoDTO.getLastName());
            return userMapper.toDTOs(lstUserEntity);
        } else if (null != userInfoDTO.getFirstName()){
            List<UserInfo> lstUserEntity = userInfoRepository.findByFirstName(userInfoDTO.getFirstName());
            return userMapper.toDTOs(lstUserEntity);
        } else if (null != userInfoDTO.getLastName()) {
            List<UserInfo> lstUserInfo = userInfoRepository.findByLastName(userInfoDTO.getLastName());
            return userMapper.toDTOs(lstUserInfo);
        }
        return null;
    }

    public List<UserInfoDTO> getAllUsers(){
        return userMapper.toDTOs(userInfoRepository.findAll());
    }

}
