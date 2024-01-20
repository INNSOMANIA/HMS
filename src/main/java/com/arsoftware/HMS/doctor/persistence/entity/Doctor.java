package com.arsoftware.HMS.doctor.persistence.entity;

import com.arsoftware.HMS.doctor.model.InterventionType;
import com.arsoftware.HMS.doctor.model.PoliclinicType;
import jakarta.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class Doctor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PANTIENT_ID")
    private Long pantientId;

    @Column(name = "POLICLINIC_TYPE")
    @Enumerated(EnumType.STRING)
    private PoliclinicType policlinicType;

    @Column(name = "INTERVENTION_TYPE")
    @Enumerated(EnumType.STRING)
    private InterventionType interventionType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPantientId() {
        return pantientId;
    }

    public void setPantientId(Long pantientId) {
        this.pantientId = pantientId;
    }

    public PoliclinicType getPoliclinicType() {
        return policlinicType;
    }

    public void setPoliclinicType(PoliclinicType policlinicType) {
        this.policlinicType = policlinicType;
    }

    public InterventionType getInterventionType() {
        return interventionType;
    }

    public void setInterventionType(InterventionType interventionType) {
        this.interventionType = interventionType;
    }
}
