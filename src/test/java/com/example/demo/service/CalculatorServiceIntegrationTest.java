package com.example.demo.service;

import com.example.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CalculatorServiceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void addEndpointShouldWorkAsExpected() throws Exception {
        String path = "api/add/17/18";

        MvcResult mvcResult = mockMvc.perform(get(path))
                        .andExpect(status().isOk())
                        .andReturn();

        String actualResult = mvcResult.getResponse().getContentAsString();

        int actual = Integer.parseInt(actualResult);
        int expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    public void subtractEndpointShouldWorkAsExpected() throws Exception {
        String path = "api/subtract/10/7";

        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = mvcResult.getResponse().getContentAsString();

        int actual = Integer.parseInt(actualResult);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyEndpointShouldWorkAsExpected() throws Exception {
        String path = "api/multiply/6/2";

        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = mvcResult.getResponse().getContentAsString();

        int actual = Integer.parseInt(actualResult);
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void divideEndpointShouldWorkAsExpected() throws Exception {
        String path = "api/divide/4/2";

        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isNotImplemented())
                .andReturn();

        String actualResult = mvcResult.getResponse().getContentAsString();

        assertThrows(Exception.class, () -> actualResult.length());
    }

}