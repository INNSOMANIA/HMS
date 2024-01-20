package com.arsoftware.HMS.operation.controller;

import com.arsoftware.HMS.operation.dto.OperationDTO;
import com.arsoftware.HMS.operation.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @GetMapping(value = "/{operationId}")
    public OperationDTO getOperation(@PathVariable("operationId") long operationId) throws Exception {
        return operationService.getOperation(operationId);
    }

    @GetMapping
    public List<OperationDTO> getOperationList() {
        return operationService.getOperationList();
    }
}
