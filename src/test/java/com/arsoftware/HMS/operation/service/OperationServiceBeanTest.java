package com.arsoftware.HMS.operation.service;

import com.arsoftware.HMS.operation.dto.OperationDTO;
import com.arsoftware.HMS.operation.persistence.db.OperationRepository;
import com.arsoftware.HMS.operation.persistence.entity.Operation;
import com.arsoftware.HMS.operation.unit.OperationHelper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperationServiceBeanTest extends OperationHelper {
    @InjectMocks
    private OperationServiceBean operationService;

    @Mock
    OperationRepository operationRepository;

    @Test
    void getOperationTest() throws Exception {
        Operation operation = getSampleOperation();

        when(operationRepository.findById(anyLong())).thenReturn(Optional.of(operation));

        OperationDTO returnedODTO = operationService.getOperation(anyLong());

        assertEquals(returnedODTO.getId() , operation.getId());
        assertEquals(returnedODTO.getCondolitionId() , operation.getCondolitionId());
        assertEquals(returnedODTO.getHospitalId() , operation.getHospitalId());
        assertEquals(returnedODTO.getPantientId() , operation.getPantientId());

    }
    @Test
    void getOperationThrowExcWhenOperationDoesNotExist() {
        when(operationRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            operationService.getOperation(anyLong());
        });

        String expectedMessage = "Operation is not found in the system";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void getOperationListTest() {
        List<Operation> operationList = getSampleOperationList();

        when(operationRepository.findAll()).thenReturn(operationList);

        List<OperationDTO> operationDTOList = operationService.getOperationList();

        assertEquals(2, operationDTOList.size());
    }
}
