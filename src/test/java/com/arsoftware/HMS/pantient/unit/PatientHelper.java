package com.arsoftware.HMS.pantient.unit;

import com.arsoftware.HMS.pantient.dto.PatientDTO;
import com.arsoftware.HMS.pantient.model.Gender;
import com.arsoftware.HMS.pantient.persistence.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientHelper {

    protected static Patient getSamplePatient() {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Name");
        patient.setSurname("Surname");
        patient.setGerder(Gender.MALE);
        patient.setAge(19);
        patient.setKg(50);
        patient.setSize(170);

        return patient;
    }

    protected static List<Patient> getSamplePatientList() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(getSamplePatient());
        patientList.add(getSamplePatient());

        return patientList;
    }

    protected static PatientDTO getSamplePatientDTO() {
        return new PatientDTO(1L,
                "Name",
                "SURName",
                Gender.MALE,
                15,
                190,
                80);
    }

    protected static List<PatientDTO> getSamplePatientDTOList() {
        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientDTOList.add(new PatientDTO(1L,
                "NAME",
                "SURNAME",
                Gender.WOMAN,
                19,
                180,
                80));

        return patientDTOList;
    }
}
