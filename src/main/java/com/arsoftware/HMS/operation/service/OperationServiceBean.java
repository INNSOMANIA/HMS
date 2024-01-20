package com.arsoftware.HMS.operation.service;

import com.arsoftware.HMS.operation.dto.OperationDTO;
import com.arsoftware.HMS.operation.persistence.db.OperationRepository;
import com.arsoftware.HMS.operation.persistence.entity.Operation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationServiceBean implements OperationService {

    OperationRepository<Operation> operationRepository;

    @Override
    public OperationDTO getOperation(long operationId) throws Exception {
        Optional<Operation> optionalOperation = operationRepository.findById(operationId);
        if (optionalOperation.isPresent()) {
            Operation operation = optionalOperation.get();
            return new OperationDTO(operation.getId(),
                    operation.getPantientId(),
                    operation.getCondolitionId(),
                    operation.getHospitalId());
        } else {
            throw new Exception("Operation is not found in the system");
        }
    }

    @Override
    public List<OperationDTO> getOperationList() {
        return operationRepository.findAll().stream().map(operation -> new OperationDTO(
                operation.getId(),
                operation.getPantientId(),
                operation.getCondolitionId(),
                operation.getHospitalId()
        )).collect(Collectors.toList());
    }
}
