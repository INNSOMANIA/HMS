package com.arsoftware.HMS.doctor.service;

import com.arsoftware.HMS.doctor.dto.DoctorDTO;
import com.arsoftware.HMS.doctor.model.PoliclinicType;
import com.arsoftware.HMS.doctor.persistence.db.DoctorRepository;
import com.arsoftware.HMS.doctor.persistence.entity.Doctor;
import com.arsoftware.HMS.hospital.dto.HospitalDTO;
import com.arsoftware.HMS.hospital.persistence.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceBean implements DoctorService {
    @Autowired
    DoctorRepository<Doctor> doctorRepository;

    @Override
    public DoctorDTO getDoctor(long doctorId) throws Exception {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            return new DoctorDTO(doctor.getId(),
                    doctor.getName(),
                    doctor.getSurname(),
                    doctor.getPantientId(),
                    doctor.getPoliclinicType(),
                    doctor.getInterventionType());

        } else {
            throw new Exception("Doctor is not found in the system");
        }
    }

    @Override
    public List<DoctorDTO> getDoctorList() {
        return doctorRepository.findAll().stream().map(doctor -> new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getPantientId(),
                doctor.getPoliclinicType(),
                doctor.getInterventionType()
        )).collect(Collectors.toList());
    }
}
