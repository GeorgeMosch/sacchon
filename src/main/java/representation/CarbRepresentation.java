package representation;

import jpaUtil.JpaUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Carb;
import org.modelmapper.ModelMapper;
import repository.CarbRepository;
import repository.PatientRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class CarbRepresentation {
    private long id;
    private double carb;
    private LocalDate date;
    private long dateOffsetDays;
    private long patientId;

    private String uri;

    Carb carbEntity = createCarb();
    ModelMapper modelMapper = new ModelMapper();
    CarbRepresentation carbRepresentation = modelMapper.map(carbEntity, CarbRepresentation.class);

    public CarbRepresentation(Carb carb) {
        if (carb != null) {
            id = carb.getId();
            this.carb = carb.getCarb();
            date = carb.getDate();
            if (carb.getPatient() != null) {
                patientId = carb.getPatient().getId();
            }

            uri = "http://localhost:9000/v1/carb/" + carb.getId();
        }

    }

    public Carb createCarb() {
        EntityManager em = JpaUtil.getEntityManager();
        CarbRepository carbRepository = new CarbRepository(em);
        Carb carb = new Carb();

        carb.setCarb(this.carb);
        if (date == null) {
            carb.setDate(LocalDate.from(ZonedDateTime.now().minusDays(dateOffsetDays).toInstant()));
        } else {
            carb.setDate(date);
        }
        carb.setSimpleDate(carbRepository.getSimpleDate(carb.getDate()));


        PatientRepository patientRepository = new PatientRepository(em);
        carb.setPatient(patientRepository.read(patientId));
        return carb;
    }
}