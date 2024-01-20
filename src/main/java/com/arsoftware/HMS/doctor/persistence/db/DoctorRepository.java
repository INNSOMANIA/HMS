package com.arsoftware.HMS.doctor.persistence.db;

import com.arsoftware.HMS.doctor.persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository<T extends Doctor> extends JpaRepository<Doctor , Long> {
    Optional<Doctor> findById(Long doctorId);

    List<Doctor> findAll();
}
