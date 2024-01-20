package com.arsoftware.HMS.pantient.dto;

import com.arsoftware.HMS.pantient.model.Gender;

import java.io.Serializable;
import java.util.PrimitiveIterator;

public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 111L;

    private final long id;

    private final String name;

    private final String surname;

    private final Gender gender;

    private final int age;

    private final int size;

    private final int kg;

    public PatientDTO(long id, String name, String surname, Gender gender, int age, int size, int kg) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.kg = kg;
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

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getSize() {
        return size;
    }

    public int getKg() {
        return kg;
    }
}

