package com.example.GraphQl.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.GraphQl.entities.TypeCompte;
import com.example.GraphQl.entities.TypeTransaction;

import java.util.Date;

    @NoArgsConstructor
    @AllArgsConstructor
    public class TransactionRequest {
        private Long compteId;
        private Double montant;
        @Temporal(TemporalType.DATE)
        private Date date;
        @Enumerated(EnumType.STRING)
        private TypeTransaction type;

        private long compte ;

        public Long getCompteId() {
            return compteId;
        }

        public Double getMontant() {
            return montant;
        }

        public Date getDate() {
            return date;
        }

        public TypeTransaction getType() {
            return type;
        }

        public long getCompte() {
            return compte;
        }

        public void setCompteId(Long compteId) {
            this.compteId = compteId;
        }

        public void setMontant(Double montant) {
            this.montant = montant;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setType(TypeTransaction type) {
            this.type = type;
        }

        public void setCompte(long compte) {
            this.compte = compte;
        }
    }

