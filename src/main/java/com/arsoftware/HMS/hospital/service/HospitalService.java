package com.arsoftware.HMS.hospital.service;

import com.arsoftware.HMS.hospital.dto.HospitalDTO;

import java.util.List;

public interface HospitalService {
    HospitalDTO getHospital(long hospitalId) throws Exception;

    List<HospitalDTO> getHospitalList();
}
