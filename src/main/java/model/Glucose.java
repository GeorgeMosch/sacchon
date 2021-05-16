package model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
public class Glucose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double glucose;
    private LocalDate date;

    @ManyToOne
    private Patient patient;
}
