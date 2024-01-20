package com.arsoftware.HMS.condilition.service;

import com.arsoftware.HMS.condilition.dto.CondilitionDTO;
import com.arsoftware.HMS.condilition.persistence.db.CondilitionRepository;
import com.arsoftware.HMS.condilition.persistence.entity.Condilition;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CondilitionServiceBean implements CondilitionService {

    CondilitionRepository<Condilition> condilitionRepository;

    @Override
    public CondilitionDTO getCondilition(long condilitionId) throws Exception {
        Optional<Condilition> optionalCondilition = condilitionRepository.findById(condilitionId);
        if (optionalCondilition.isPresent()) {
            Condilition condilition = optionalCondilition.get();
            return new CondilitionDTO(
                    condilition.getId(),
                    condilition.getInfo(),
                    condilition.getSeriousnessType());

        } else {
            throw new Exception("Condilition is not found in the system");
        }
    }

    @Override
    public List<CondilitionDTO> getCondilitionList() {
        return condilitionRepository.findAll().stream().map(condilition -> new CondilitionDTO(
                condilition.getId(),
                condilition.getInfo(),
                condilition.getSeriousnessType()
        )).collect(Collectors.toList());
    }
}
