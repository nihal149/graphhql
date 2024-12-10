package com.example.GraphQl.repositories;

import com.example.GraphQl.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
@Repository
    public interface CompteRepository extends JpaRepository<Compte, Long> {

        // Méthode pour compter le nombre total de comptes (héritée de JpaRepository)
        long count();

        // Méthode pour calculer la somme des soldes de tous les comptes
        @Query("SELECT SUM(c.solde) FROM Compte c")
        Double sumSoldes();

        // Méthode pour calculer la moyenne des soldes (optionnelle, peut être calculée via totalSolde)
        @Query("SELECT AVG(c.solde) FROM Compte c")
        Double averageSolde();
    }


