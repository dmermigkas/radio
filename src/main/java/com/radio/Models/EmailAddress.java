package com.radio.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmailAddress {

    @Column(name="email")
    private String email;

    public EmailAddress(){};

    public EmailAddress(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof EmailAddress)) {
            return false;
        }

        EmailAddress theEmail = (EmailAddress) other;
        return email == null ? theEmail.getEmail() == null
                : email.equals(theEmail.getEmail());
    }

    @Override
    public int hashCode() {
        return email == null ? 0 : email.hashCode();
    }

}
