package service;

import exception.EntityException;
import representation.PatientRepresentation;
import representation.ResultData;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface PatientService {
    //CRUD
    ResultData<PatientRepresentation> createPatient(PatientRepresentation patientRepresentation)  ;
    List<PatientRepresentation> readPatient();
    List<PatientRepresentation> readPatient(PatientRepresentation patientRepresentation);
    ResultData<PatientRepresentation> readPatient(long patientId)throws EntityNotFoundException;
    PatientRepresentation updatePatient (long patientId, PatientRepresentation patientRepresentation)
            throws EntityNotFoundException, EntityException;
    boolean deletePatient(long patientId) throws EntityNotFoundException, EntityException;
}
