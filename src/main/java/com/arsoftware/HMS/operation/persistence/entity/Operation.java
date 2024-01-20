package com.arsoftware.HMS.operation.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PANTIENT_ID")
    private Long pantientId;

    @Column(name = "CONDOLITION_ID")
    private Long condolitionId;

    @Column(name = "HOSPITAL_ID")
    private Long hospitalId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPantientId() {
        return pantientId;
    }

    public void setPantientId(Long pantientId) {
        this.pantientId = pantientId;
    }

    public Long getCondolitionId() {
        return condolitionId;
    }

    public void setCondolitionId(Long condolitionId) {
        this.condolitionId = condolitionId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
