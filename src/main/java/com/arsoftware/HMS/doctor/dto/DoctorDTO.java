package com.arsoftware.HMS.doctor.dto;

import com.arsoftware.HMS.doctor.model.InterventionType;
import com.arsoftware.HMS.doctor.model.PoliclinicType;

import java.io.Serializable;

public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = 444L;

    private final long id;

    private final String name;

    private final String surname;

    private final Long pantientId;

    private final PoliclinicType policlinicType;

    private final InterventionType interventionType;

    public DoctorDTO(long id, String name, String surname, Long pantientId, PoliclinicType policlinicType, InterventionType interventionType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pantientId = pantientId;
        this.policlinicType = policlinicType;
        this.interventionType = interventionType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getPantientId() {
        return pantientId;
    }

    public PoliclinicType getPoliclinicType() {
        return policlinicType;
    }

    public InterventionType getInterventionType() {
        return interventionType;
    }
}
