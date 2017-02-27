package com.radio.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PRODUCERS")
public class Producer {

    @Id
    @Column(name="producerid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    private DaoFactory dao;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Embedded
    private EmailAddress email;

    public Producer(){};

    //public Producer(DaoFactory dao, String firstName, String lastName, EmailAddress email){
    public Producer(String firstName, String lastName, EmailAddress email){
        //this.dao = dao;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

//    public <T> T getDao(){
//        return dao.getDao();
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

}
