package com.arsoftware.HMS.doctor.service;

import com.arsoftware.HMS.doctor.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO getDoctor(long doctorId) throws Exception;

    List<DoctorDTO> getDoctorList();
}
