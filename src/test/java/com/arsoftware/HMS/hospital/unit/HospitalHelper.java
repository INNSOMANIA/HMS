package com.arsoftware.HMS.hospital.unit;

import com.arsoftware.HMS.hospital.dto.HospitalDTO;
import com.arsoftware.HMS.hospital.persistence.entity.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalHelper {
    protected static Hospital getSampleHospital() {
        Hospital hospital = new Hospital();
        hospital.getId();
        hospital.getName();
        hospital.getDoctorId();
        hospital.getPatientId();

        return hospital;
    }

    protected static List<Hospital> getSampleHospitalList() {
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalList.add(getSampleHospital());
        hospitalList.add(getSampleHospital());

        return hospitalList;
    }

    protected static HospitalDTO getSampleHospitalDTO() {
        return new HospitalDTO(1l,
                "NAME",
                1L,
                1L);
    }

    protected static List<HospitalDTO> getSampleHospitalDTOList() {
        List<HospitalDTO> hospitalDTOList = new ArrayList<>();
        hospitalDTOList.add(new HospitalDTO(1l,
                "NAME",
                1L,
                1L));
        return hospitalDTOList;
    }
}
