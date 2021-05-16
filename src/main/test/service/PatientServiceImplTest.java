package service;

import model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.PatientRepository;
import representation.PatientRepresentation;
import representation.ResultData;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PatientServiceImplTest {

    //mocking the repository and the EntityManager
    @Mock
    private PatientRepository patientRepositoryMock  ;
    @Mock
    private EntityManager emMock  ;

    @InjectMocks
    PatientService patientService = new PatientServiceImpl(emMock);

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() throws Exception{

        Patient patientExp = new Patient();
        when(patientRepositoryMock.save(any(Patient.class)) ).thenReturn(patientExp);

        PatientRepresentation patientRepresentation = new PatientRepresentation();
        patientRepresentation.setName("George");
        patientRepresentation.setUsername("George");
        patientRepresentation.setPassword("1234");

        ResultData<PatientRepresentation> patientRepresentationPersisted = patientService.createPatient(patientRepresentation);
        assertEquals(patientRepresentation.getName(), patientRepresentationPersisted.getData().getName());
    }
}