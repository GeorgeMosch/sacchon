package model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
public class Carb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double carb;
    private LocalDate date;
    private LocalDate simpleDate;

    @ManyToOne
    private Patient patient;
}
