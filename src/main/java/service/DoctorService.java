package service;

import exception.EntityException;
import representation.DoctorRepresentation;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface DoctorService {
    DoctorRepresentation createDoctor(DoctorRepresentation doctorRepresentation) ;
    List<DoctorRepresentation> readDoctor();
    List<DoctorRepresentation> readDoctor(DoctorRepresentation doctorRepresentation);
    DoctorRepresentation readDoctor(long patientId) throws EntityException;
    DoctorRepresentation updateDoctor(long doctorId, DoctorRepresentation doctorRepresentation)
            throws EntityNotFoundException, EntityException;
    boolean deleteDoctor(long doctorId) throws EntityNotFoundException, EntityException;
}
