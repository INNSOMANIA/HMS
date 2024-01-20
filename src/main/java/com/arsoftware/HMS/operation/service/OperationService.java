package com.arsoftware.HMS.operation.service;

import com.arsoftware.HMS.operation.dto.OperationDTO;

import java.util.List;

public interface OperationService {
    OperationDTO getOperation(long operationId) throws Exception;

    List<OperationDTO> getOperationList();
}
