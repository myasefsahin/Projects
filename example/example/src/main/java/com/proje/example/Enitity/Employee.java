package com.proje.example.Enitity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String name ;
    private String Surname;
    private String email;
    private String password ;
    private String date;

}
