package com.arsoftware.HMS.pantient.persistence.entity;

import com.arsoftware.HMS.pantient.model.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @Column(name = "ID" , nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME" , nullable = false)
    private String name;

    @Column(name = "SURNAME" , nullable = false)
    private String surname;

    @Column(name = "AGE" , nullable = false)
    private int age;

    @Column(name = "GENDER" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gerder;

    @Column(name = "SIZE" , nullable = false)
    private int size;

    @Column(name = "KG" , nullable = false)
    private int kg;

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

    public Gender getGerder() {
        return gerder;
    }

    public void setGerder(Gender gerder) {
        this.gerder = gerder;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }
}
