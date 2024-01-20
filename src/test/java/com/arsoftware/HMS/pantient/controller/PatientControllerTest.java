package com.arsoftware.HMS.pantient.controller;

import com.arsoftware.HMS.pantient.service.PatientService;
import com.arsoftware.HMS.pantient.unit.PatientHelper;
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
public class PatientControllerTest extends PatientHelper {

    @MockBean
    private PatientService patientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPatient() throws Exception {
        when(patientService.getPatient(1l)).thenReturn(getSamplePatientDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patient/1"))
                .andExpect(status().isOk())
                .equals(getSamplePatientDTO());
    }

    @Test
    void getPatientList() throws Exception {
        when(patientService.getPatientList()).thenReturn(getSamplePatientDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patient"))
                .andExpect(status().isOk())
                .equals(getSamplePatientList());
    }
}
