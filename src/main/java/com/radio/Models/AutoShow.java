package com.radio.Models;

import javax.persistence.*;

@Entity
@Table(name="AUTOSHOWS")
public class AutoShow extends Show{
    @Id
    @Column(name="autoshowid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="SHOWGENRES",
            joinColumns = {@JoinColumn (name="autoshowid")},
            inverseJoinColumns = {@JoinColumn(name="genreid")})
    private Genre genre;

    private Policies policies = new Policies();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Policies getPolicies() {
        return policies;
    }

    public void setPolicies(Policies policies) {
        this.policies = policies;
    }
}
