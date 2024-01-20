package com.arsoftware.HMS.hospital.service;

import com.arsoftware.HMS.hospital.dto.HospitalDTO;
import com.arsoftware.HMS.hospital.persistence.db.HospitalRepository;
import com.arsoftware.HMS.hospital.persistence.entity.Hospital;
import com.arsoftware.HMS.hospital.unit.HospitalHelper;

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
public class HospitalServiceBeanTest extends HospitalHelper {

    @InjectMocks
    private HospitalServiceBean hospitalService;

    @Mock
    HospitalRepository hospitalRepository;

    @Test
    void getHospitalTest() throws Exception {

        Hospital hospital = getSampleHospital();

        when(hospitalRepository.findById(anyLong())).thenReturn(Optional.of(hospital));

        HospitalDTO returnedHDTO = hospitalService.getHospital(anyLong());

        assertEquals(returnedHDTO.getId(), hospital.getId());
        assertEquals(returnedHDTO.getName(), hospital.getName());
        assertEquals(returnedHDTO.getDoctorId(), hospital.getDoctorId());
        assertEquals(returnedHDTO.getPatientId(), hospital.getPatientId());
    }

    @Test
    void getHospitalThrowExcWhenHospitalDoesNotExist() {
        when(hospitalRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            hospitalService.getHospital(anyLong());
        });

        String expectedMessage = "Hospital is not found in the system";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getHospitalListTest() {
        List<Hospital> hospitalList = getSampleHospitalList();

        when(hospitalRepository.findAll()).thenReturn(hospitalList);

        List<HospitalDTO> hospitalDTOList = hospitalService.getHospitalList();

        assertEquals(2, hospitalDTOList.size());
    }
}
