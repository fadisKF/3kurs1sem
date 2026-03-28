package com.db.kafedra.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Discipline> disciplines;

    public Teacher() {}

    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}