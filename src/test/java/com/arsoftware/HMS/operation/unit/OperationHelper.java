package com.arsoftware.HMS.operation.unit;

import com.arsoftware.HMS.operation.dto.OperationDTO;
import com.arsoftware.HMS.operation.persistence.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationHelper {
    protected static Operation getSampleOperation() {
        Operation operation = new Operation();
        operation.getId();
        operation.getPantientId();
        operation.getCondolitionId();
        operation.getHospitalId();

        return operation;
    }

    protected static List<Operation> getSampleOperationList() {
        List<Operation> operationList = new ArrayList<>();
        operationList.add(getSampleOperation());
        operationList.add(getSampleOperation());

        return operationList;
    }

    protected static OperationDTO getSampleOperationDTO() {
        return new OperationDTO(1l,
                1L,
                1L,
                1L);
    }

    protected static List<OperationDTO> getSampleOperationDTOList() {
        List<OperationDTO> operationDTOList = new ArrayList<>();
        operationDTOList.add(new OperationDTO(1l,
                1L,
                1L,
                1L));
        return operationDTOList;
    }
}
