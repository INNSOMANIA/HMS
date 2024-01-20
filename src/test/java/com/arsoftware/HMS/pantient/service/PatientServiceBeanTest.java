package com.arsoftware.HMS.pantient.service;

import com.arsoftware.HMS.pantient.dto.PatientDTO;
import com.arsoftware.HMS.pantient.persistence.db.PatientRepository;
import com.arsoftware.HMS.pantient.persistence.entity.Patient;
import com.arsoftware.HMS.pantient.unit.PatientHelper;
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
public class PatientServiceBeanTest extends PatientHelper {

    @InjectMocks
    private PatientServiceBean patientService;

    @Mock
    PatientRepository patientRepository;

    @Test
    void getPantientTest() throws Exception {

        Patient patient = getSamplePatient();

        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(patient));

        PatientDTO returnedPDTO = patientService.getPatient(anyLong());

        assertEquals(returnedPDTO.getId(), patient.getId());
        assertEquals(returnedPDTO.getName(), patient.getName());
        assertEquals(returnedPDTO.getSurname(), patient.getSurname());
        assertEquals(returnedPDTO.getAge(), patient.getAge());
        assertEquals(returnedPDTO.getSize(), patient.getSize());
        assertEquals(returnedPDTO.getKg(), patient.getKg());
    }

    @Test
    void getPatientThrowExcWhenPatientDoesNotExist() {
        when(patientRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            patientService.getPatient(anyLong());
        });

        String expectedMessage = "Patient is not found in the system";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getPatientListTest() {
        List<Patient> patientList = getSamplePatientList();

        when(patientRepository.findAll()).thenReturn(patientList);

        List<PatientDTO> patientDTOList = patientService.getPatientList();

        assertEquals(2, patientDTOList.size());
    }

}
