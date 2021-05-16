package resource;

import exception.AuthorizationException;
import exception.EntityException;
import jpaUtil.JpaUtil;
import model.Patient;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import repository.PatientRepository;
import representation.PatientRepresentation;
import representation.ResultData;
import security.Shield;
import service.PatientService;
import service.PatientServiceImpl;

import javax.persistence.EntityManager;

public class PatientResource extends ServerResource {
    private long id;
    private PatientService patientService;
    private EntityManager entityManager;

    @Override
    protected void doInit() {
        entityManager = JpaUtil.getEntityManager();
        patientService = new PatientServiceImpl(entityManager);
        id = Long.parseLong(getAttribute("id"));
    }

    @Override
    protected void doRelease(){
        entityManager.close();
    }


    @Get("json")
    public ResultData<PatientRepresentation> getPatient() throws AuthorizationException {
        ResourceUtils.checkRole(this, Shield.ROLE_CHIEF_DOCTOR);
        return patientService.readPatient(id);
    }

    @Put("json")
    public PatientRepresentation updatePatient(PatientRepresentation patientRepresentation) throws AuthorizationException, EntityException {
        ResourceUtils.checkRole(this, Shield.ROLE_CHIEF_DOCTOR);
        return patientService.updatePatient(id, patientRepresentation);
    }

    @Delete("json")
    public boolean deletePatient() throws AuthorizationException, EntityException {
        ResourceUtils.checkRole(this, Shield.ROLE_CHIEF_DOCTOR);
        return patientService.deletePatient(id);
    }

}
