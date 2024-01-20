package com.arsoftware.HMS.hospital.controller;

import com.arsoftware.HMS.hospital.service.HospitalService;
import com.arsoftware.HMS.hospital.unit.HospitalHelper;

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
public class HospitalControllerTest extends HospitalHelper {
    @MockBean
    private HospitalService hospitalService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHospital() throws Exception {
        when(hospitalService.getHospital(1l)).thenReturn(getSampleHospitalDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital/1"))
                .andExpect(status().isOk())
                .equals(getSampleHospitalDTO());
    }

    @Test
    void getHospitalList() throws Exception {
        when(hospitalService.getHospitalList()).thenReturn(getSampleHospitalDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital"))
                .andExpect(status().isOk())
                .equals(getSampleHospitalList());
    }
}
