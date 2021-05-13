package model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Patient extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int age;
    private String sex;
    private LocalDate dateRegistered;
    private String role = "patient";
    private boolean consultationChanged = false;
    private LocalDate recentConsultation;
    private LocalDate recentCarb;
    private LocalDate recentGlucose;

    @ManyToOne
    private Doctor doctor;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Carb> carbList;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Glucose> glucoseList;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultation> consultationList;


}
