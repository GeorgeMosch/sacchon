package model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@Getter
@Setter
public class User {
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;

    private String name;
    @Column(unique = true)
    private String email;
    private String address;
}
