package com.arsoftware.HMS.hospital.service;

import com.arsoftware.HMS.hospital.dto.HospitalDTO;
import com.arsoftware.HMS.hospital.persistence.db.HospitalRepository;
import com.arsoftware.HMS.hospital.persistence.entity.Hospital;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HospitalServiceBean implements HospitalService{
    HospitalRepository<Hospital> hospitalRepository;
    @Override
    public HospitalDTO getHospital(long hospitalId) throws Exception {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            return new HospitalDTO(hospital.getId(),
                    hospital.getName(),
                    hospital.getPatientId(),
                    hospital.getDoctorId());
        }
        else {
            throw new Exception("Hospital is not found in the system");
        }
    }

    @Override
    public List<HospitalDTO> getHospitalList() {
        return hospitalRepository.findAll().stream().map(hospital -> new HospitalDTO(
                hospital.getId(),
                hospital.getName(),
                hospital.getPatientId(),
                hospital.getDoctorId()
        )).collect(Collectors.toList());
    }
}
