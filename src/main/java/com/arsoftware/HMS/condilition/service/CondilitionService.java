package com.arsoftware.HMS.condilition.service;

import com.arsoftware.HMS.condilition.dto.CondilitionDTO;

import java.util.List;

public interface CondilitionService {
    CondilitionDTO getCondilition(long doctorId) throws Exception;

    List<CondilitionDTO> getCondilitionList();
}
