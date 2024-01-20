package com.arsoftware.HMS.condilition.controller;

import com.arsoftware.HMS.condilition.dto.CondilitionDTO;
import com.arsoftware.HMS.condilition.service.CondilitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/condilition")
public class CondilitionController {

    @Autowired
    CondilitionService condilitionService;

    @GetMapping(value = "/{condolitionId}")
    public CondilitionDTO getCondilition(@PathVariable("condolitionId") long condilitionId) throws Exception {
        return condilitionService.getCondilition(condilitionId);
    }

    @GetMapping(value = "")
    public List<CondilitionDTO> getCondilitionList() {
        return condilitionService.getCondilitionList();
    }
}
