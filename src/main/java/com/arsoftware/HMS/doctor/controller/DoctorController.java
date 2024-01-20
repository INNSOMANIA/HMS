package com.arsoftware.HMS.doctor.controller;

import com.arsoftware.HMS.doctor.dto.DoctorDTO;
import com.arsoftware.HMS.doctor.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/{doctorId}")
    public DoctorDTO getDoctor(@PathVariable("doctorId") long doctorId) throws Exception {
        return doctorService.getDoctor(doctorId);
    }

    @GetMapping(value = "")
    public List<DoctorDTO> getDoctorList() {
        return doctorService.getDoctorList();
    }
}
