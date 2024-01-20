package com.arsoftware.HMS.pantient.service;

import com.arsoftware.HMS.pantient.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO getPatient(long patientId) throws Exception;

    List<PatientDTO> getPatientList();
}
