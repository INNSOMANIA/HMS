package com.arsoftware.HMS.hospital.dto;

import java.io.Serializable;

public class HospitalDTO implements Serializable {

    private static final long serialVersionUID = 222L;
    private final long id;

    private final String name;

    private final Long patientId;

    private final Long doctorId;

    public HospitalDTO(long id, String name, Long patientId, Long doctorId) {
        this.id = id;
        this.name = name;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }
}
