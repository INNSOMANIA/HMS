package com.arsoftware.HMS.doctor.unit;

import com.arsoftware.HMS.doctor.dto.DoctorDTO;
import com.arsoftware.HMS.doctor.model.InterventionType;
import com.arsoftware.HMS.doctor.model.PoliclinicType;
import com.arsoftware.HMS.doctor.persistence.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorHelper {
    protected static Doctor getSampleDoctor() {
        Doctor doctor = new Doctor();
        doctor.getId();
        doctor.getName();
        doctor.getSurname();
        doctor.getInterventionType();
        doctor.getPantientId();
        doctor.getPoliclinicType();

        return doctor;
    }

    protected static List<Doctor> getSampleDoctorList() {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(getSampleDoctor());
        doctorList.add(getSampleDoctor());

        return doctorList;
    }

    protected static DoctorDTO getSampleDoctorDTO() {
        return new DoctorDTO(1,
                "NAME",
                "SURNAME",
                1L,
                PoliclinicType.EYE_DISEASES,
                InterventionType.DRESSING);
    }

    protected static List<DoctorDTO> getSampleDoctorDTOList() {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        doctorDTOList.add(new DoctorDTO(1l,
                "NAME",
                "SURNAME",
                1L,
                PoliclinicType.EYE_DISEASES,
                InterventionType.DRESSING));

        return doctorDTOList;
    }
}
