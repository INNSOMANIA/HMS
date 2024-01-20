package com.arsoftware.HMS.condilition.service;

import com.arsoftware.HMS.condilition.dto.CondilitionDTO;
import com.arsoftware.HMS.condilition.persistence.db.CondilitionRepository;
import com.arsoftware.HMS.condilition.persistence.entity.Condilition;
import com.arsoftware.HMS.condilition.unit.CondilitionHelper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CondilitionServiceBeanTest extends CondilitionHelper {

    @InjectMocks
    private CondilitionServiceBean condilitionService;

    @Mock
    CondilitionRepository condilitionRepository;

    @Test
    void getCondilitionTest() throws Exception {

        Condilition condilition = getSampleCondilition();

        when(condilitionRepository.findById(anyLong())).thenReturn(Optional.of(condilition));

        CondilitionDTO returnedCDTO = condilitionService.getCondilition(anyLong());

        assertEquals(returnedCDTO.getId(), condilition.getId());
        assertEquals(returnedCDTO.getInfo(), condilition.getInfo());
        assertEquals(returnedCDTO.getSeriousnessType(), condilition.getSeriousnessType());
    }

    @Test
    void getCondilitionThrowExcWhenCondilitionDoesNotExist() {
        when(condilitionRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            condilitionService.getCondilition(anyLong());
        });

        String expectedMessage = "Condilition is not found in the system";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getCondilitionListTest() {
        List<Condilition> condilitionList = getSampleCondilitionList();

        when(condilitionRepository.findAll()).thenReturn(condilitionList);

        List<CondilitionDTO> condilitionDTOList = condilitionService.getCondilitionList();

        assertEquals(2, condilitionDTOList.size());
    }
    
}
