package com.arsoftware.HMS.hospital.persistence.db;

import com.arsoftware.HMS.hospital.persistence.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository<T extends Hospital> extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findById(Long pantientId);

    List<Hospital> findAll();
}
