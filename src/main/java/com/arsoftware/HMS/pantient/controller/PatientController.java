package com.arsoftware.HMS.pantient.controller;

import com.arsoftware.HMS.pantient.dto.PatientDTO;
import com.arsoftware.HMS.pantient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/{patientId}")
    public PatientDTO getPatient(@PathVariable("patientId") long patientId) throws Exception {
        return patientService.getPatient(patientId);
    }

    @GetMapping(value = "")
    public List<PatientDTO> getPatientList() {
        return patientService.getPatientList();
    }
}
