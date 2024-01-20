package com.arsoftware.HMS.operation.dto;

import java.io.Serializable;

public class OperationDTO implements Serializable {

    private static final long serialVersionUID = 333L;

    private final long id;

    private final Long pantientId;


    private final Long condolitionId;


    private final Long hospitalId;

    public OperationDTO(long id, Long pantientId, Long condolitionId, Long hospitalId) {
        this.id = id;
        this.pantientId = pantientId;
        this.condolitionId = condolitionId;
        this.hospitalId = hospitalId;
    }

    public long getId() {
        return id;
    }

    public Long getPantientId() {
        return pantientId;
    }

    public Long getCondolitionId() {
        return condolitionId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }
}
