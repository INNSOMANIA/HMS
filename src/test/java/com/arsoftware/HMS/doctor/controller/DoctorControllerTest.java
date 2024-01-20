package com.arsoftware.HMS.doctor.controller;

import com.arsoftware.HMS.doctor.service.DoctorServiceBean;
import com.arsoftware.HMS.doctor.unit.DoctorHelper;
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
public class DoctorControllerTest extends DoctorHelper {

    @MockBean
    private DoctorServiceBean doctorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDoctor() throws Exception {
        when(doctorService.getDoctor(1l)).thenReturn(getSampleDoctorDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/doctor/1"))
                .andExpect(status().isOk())
                .equals(getSampleDoctorDTO());
    }

    @Test
    void getDoctorList() throws Exception {
        when(doctorService.getDoctorList()).thenReturn(getSampleDoctorDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/doctor"))
                .andExpect(status().isOk())
                .equals(getSampleDoctorList());
    }
}
