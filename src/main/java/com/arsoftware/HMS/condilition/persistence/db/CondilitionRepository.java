package com.arsoftware.HMS.condilition.persistence.db;

import com.arsoftware.HMS.condilition.persistence.entity.Condilition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CondilitionRepository<T extends Condilition> extends JpaRepository<Condilition , Long> {

    Optional<Condilition> findById(Long condilitionId);

    List<Condilition> findAll();
}
