package com.example.demo.repository;

import com.example.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

    List<UserInfo> findByFirstName(String firstName);

    List<UserInfo> findByLastName(String lastName);

    List<UserInfo> findByFirstNameAndLastName (String firstName, String lastName);

    List<UserInfo> findAll();
}
