package com.arsoftware.HMS.condilition.controller;

import com.arsoftware.HMS.condilition.service.CondilitionService;
import com.arsoftware.HMS.condilition.unit.CondilitionHelper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CondilitionControllerTest extends CondilitionHelper {
    @MockBean
    private CondilitionService condilitionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCondilition() throws Exception {
        when(condilitionService.getCondilition(1l)).thenReturn(getSampleCondilitionDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/condilition/1"))
                .andExpect(status().isOk())
                .equals(getSampleCondilition());
    }

    @Test
    void getConlitionList() throws Exception {
        when(condilitionService.getCondilitionList()).thenReturn(getSampleCondilitionDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/condilition/"))
                .andExpect(status().isOk())
                .equals(getSampleCondilitionList());
    }
}
