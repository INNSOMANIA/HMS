package com.arsoftware.HMS.condilition.persistence.entity;

import com.arsoftware.HMS.condilition.model.SeriousnessType;
import jakarta.persistence.*;

@Entity
@Table(name = "CONDILITION")
public class Condilition {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "INFO")
    private String info;

    @Column(name = "SERIOUSNESS_TYPE")
    @Enumerated(EnumType.STRING)
    private SeriousnessType seriousnessType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public SeriousnessType getSeriousnessType() {
        return seriousnessType;
    }

    public void setSeriousnessType(SeriousnessType seriousnessType) {
        this.seriousnessType = seriousnessType;
    }
}
