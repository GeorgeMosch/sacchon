package service;

import exception.EntityException;
import representation.DoctorRepresentation;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    @Override
    public DoctorRepresentation createDoctor(DoctorRepresentation doctorRepresentation) {
        return null;
    }

    @Override
    public List<DoctorRepresentation> readDoctor() {
        return null;
    }

    @Override
    public List<DoctorRepresentation> readDoctor(DoctorRepresentation doctorRepresentation) {
        return null;
    }

    @Override
    public DoctorRepresentation readDoctor(long patientId) throws EntityException {
        return null;
    }

    @Override
    public DoctorRepresentation updateDoctor(long doctorId, DoctorRepresentation doctorRepresentation) throws EntityNotFoundException, EntityException {
        return null;
    }

    @Override
    public boolean deleteDoctor(long doctorId) throws EntityNotFoundException, EntityException {
        return false;
    }
}
