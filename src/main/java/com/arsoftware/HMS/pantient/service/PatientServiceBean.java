package com.arsoftware.HMS.pantient.service;

import com.arsoftware.HMS.pantient.dto.PatientDTO;
import com.arsoftware.HMS.pantient.persistence.db.PatientRepository;
import com.arsoftware.HMS.pantient.persistence.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceBean implements PatientService {

    @Autowired
    PatientRepository<Patient> patientRepository;

    @Override
    public PatientDTO getPatient(long patientId) throws Exception {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            return new PatientDTO(patient.getId(),
                    patient.getName(),
                    patient.getSurname(),
                    patient.getGerder(),
                    patient.getAge(),
                    patient.getSize(),
                    patient.getKg());
        } else {
            throw new Exception("Pantient is not found in the system");
        }
    }

    @Override
    public List<PatientDTO> getPatientList() {
        return patientRepository.findAll().stream().map(patient -> new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getGerder(),
                patient.getAge(),
                patient.getSize(),
                patient.getKg()
        )).collect(Collectors.toList());
    }
}
