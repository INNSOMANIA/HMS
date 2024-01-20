package com.arsoftware.HMS.condilition.dto;

import com.arsoftware.HMS.condilition.model.SeriousnessType;

import java.io.Serializable;

public class CondilitionDTO implements Serializable {

    private static final long serialVersionUID = 555l;

    private final long id;

    private final String info;

    private final SeriousnessType seriousnessType;

    public CondilitionDTO(long id, String info, SeriousnessType seriousnessType) {
        this.id = id;
        this.info = info;
        this.seriousnessType = seriousnessType;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public SeriousnessType getSeriousnessType() {
        return seriousnessType;
    }
}

