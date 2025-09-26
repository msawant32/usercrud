package com.example.demo;

import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static java.lang.reflect.Array.get;

@WebMvcTest (controllers = com.example.demo.controller.DemoController.class)
@RestClientTest
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @Autowired
    private UserInfoService userInfoService;


    @Test
    void testGetUser() {
        // Implement test logic here

    }
}
