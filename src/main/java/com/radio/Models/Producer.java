package com.radio.Models;

import com.radio.Daos.DaoFactory;

public class Producer {

    private Integer id;
    private DaoFactory dao;
    private String firstName;
    private String lastName;
    private EmailAddress email;

    public Producer(){};

    public Producer(DaoFactory dao, String firstName, String lastName, EmailAddress email){

        this.dao = dao;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public <T> T getDao(){
        return dao.getDao();
    }

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
