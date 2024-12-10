package com.example.GraphQl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private double montant;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private TypeTransaction type;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public double getMontant() {
        return montant;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public TypeTransaction getType() {
        return type;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}