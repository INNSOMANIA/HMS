package com.arsoftware.HMS.operation.persistence.db;

import com.arsoftware.HMS.operation.persistence.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OperationRepository<T extends Operation> extends JpaRepository<Operation, Long> {

    Optional<Operation> findById(Long operationId);

    List<Operation> findAll();

}
