package repository;

import model.Carb;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CarbRepository extends Repository<Carb, Long>{
    public CarbRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Carb> getEntityClass() {
        return Carb.class;
    }

    @Override
    public String getClassName() {
        return Carb.class.getName();
    }

    public LocalDate getSimpleDate(LocalDate date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(date);
        //            Date simpleDate= formatter.parse(formattedDate);
        LocalDate simpleDate = LocalDate.parse(formattedDate);
        return simpleDate;
    }
}
