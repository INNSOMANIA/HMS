package com.arsoftware.HMS.hospital.controller;

import com.arsoftware.HMS.hospital.dto.HospitalDTO;
import com.arsoftware.HMS.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping(value = "/{hospitalId}")
    public HospitalDTO getHospital(@PathVariable("hospitalId") long hospitalId) throws Exception {
        return hospitalService.getHospital(hospitalId);
    }

    @GetMapping(value = "")
    public List<HospitalDTO> getHospitalList() {
        return hospitalService.getHospitalList();
    }
}
