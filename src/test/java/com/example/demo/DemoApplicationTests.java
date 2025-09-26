package com.example.demo;

import com.example.demo.controller.DemoController;
import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DemoController demoController;

	@Autowired
	private UserInfoService userInfoService;

	@Test
	void demoControllerLoads() {
		assert(demoController != null);
		UserInfoDTO userInfo = demoController.getUser(3L).getBody();
		assert(!userInfo.getFirstName().isEmpty());
	}

	@Test
	void contextLoads() {
	}



}
