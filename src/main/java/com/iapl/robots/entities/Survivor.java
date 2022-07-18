package com.iapl.robots.entities;

import com.iapl.robots.pojos.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "survivor")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long survivorId;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId")
    private Location lastLocation;
    @Column
    private boolean isInfected = Boolean.FALSE;
    @OneToMany
    private Set<Resource> resources;

}
