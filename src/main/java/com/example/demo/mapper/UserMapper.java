package com.example.demo.mapper;

import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.UserInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfoDTO toDTO(UserInfo userInfo);

    UserInfo toEntity(UserInfoDTO userInfoDTO);

    List<UserInfoDTO> toDTOs(List<UserInfo> userInfos);

    List<UserInfo> toEntities(List<UserInfoDTO> userInfoDTOs);
}
