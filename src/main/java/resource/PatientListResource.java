package resource;

import exception.AuthorizationException;
import exception.EntityException;
import jpaUtil.JpaUtil;
import model.Patient;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import repository.PatientRepository;
import representation.PatientRepresentation;
import representation.ResultData;
import security.Shield;
import service.PatientService;
import service.PatientServiceImpl;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientListResource extends ServerResource {
    private PatientService patientService ;
    private EntityManager entityManager;


    @Override
    protected void doInit() {
        entityManager = JpaUtil.getEntityManager();
        patientService = new PatientServiceImpl(entityManager);
    }

    @Override
    protected void doRelease(){
        entityManager.close();
    }

    @Get("json")
    public List<PatientRepresentation> getPatient() throws AuthorizationException {
        ResourceUtils.checkRole(this, Shield.ROLE_CHIEF_DOCTOR);
        return patientService.readPatient();
    }

    @Post("json")
    public ResultData<PatientRepresentation> add(PatientRepresentation patientRepresentationIn) throws AuthorizationException, EntityException {
        ResourceUtils.checkRole(this, Shield.ROLE_CHIEF_DOCTOR);
        return patientService.createPatient(patientRepresentationIn);
    }
}