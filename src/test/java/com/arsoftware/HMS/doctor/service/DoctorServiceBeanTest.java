package com.arsoftware.HMS.doctor.service;

import com.arsoftware.HMS.doctor.dto.DoctorDTO;
import com.arsoftware.HMS.doctor.persistence.db.DoctorRepository;
import com.arsoftware.HMS.doctor.persistence.entity.Doctor;
import com.arsoftware.HMS.doctor.unit.DoctorHelper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DoctorServiceBeanTest extends DoctorHelper {

    @InjectMocks
    private DoctorServiceBean doctorService;

    @Mock
    DoctorRepository doctorRepository;

    @Test
    void getDoctorTest() throws Exception {

        Doctor doctor = getSampleDoctor();

        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(doctor));

        DoctorDTO returnedDDTO = doctorService.getDoctor(anyLong());

        assertEquals(returnedDDTO.getId(), doctor.getId());
        assertEquals(returnedDDTO.getName(), doctor.getName());
        assertEquals(returnedDDTO.getSurname(), doctor.getSurname());
        assertEquals(returnedDDTO.getPoliclinicType(), doctor.getPoliclinicType());
        assertEquals(returnedDDTO.getInterventionType(), doctor.getInterventionType());
        assertEquals(returnedDDTO.getPantientId(), doctor.getPantientId());
    }

    @Test
    void getDoctorThrowExcWhenDoctorDoesNotExist() {
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            doctorService.getDoctor(anyLong());
        });

        String expectedMessage = "Doctor is not found in the system";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void getDoctorListTest() {
        List<Doctor> doctorList = getSampleDoctorList();

        when(doctorRepository.findAll()).thenReturn(doctorList);

        List<DoctorDTO> doctorDTOList = doctorService.getDoctorList();

        assertEquals(2, doctorDTOList.size());
    }
}

