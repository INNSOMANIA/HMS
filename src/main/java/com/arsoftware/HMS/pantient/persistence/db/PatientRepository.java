package com.arsoftware.HMS.pantient.persistence.db;

import com.arsoftware.HMS.pantient.persistence.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository<T extends Patient> extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long patientId);

    List<Patient> findAll();
}