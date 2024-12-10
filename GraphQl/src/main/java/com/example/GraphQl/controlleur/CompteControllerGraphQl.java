package com.example.GraphQl.controlleur;

import com.example.GraphQl.entities.Compte;
import com.example.GraphQl.repositories.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
@Controller
@AllArgsConstructor
public class CompteControllerGraphQl {
    private CompteRepository compteRepository;

    // Requête pour obtenir tous les comptes
    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    // Requête pour obtenir un compte par son ID
    @QueryMapping
    public Compte compteById(@Argument Long id) {
        Compte compte = compteRepository.findById(id).orElse(null);
        if (compte == null) {
            throw new RuntimeException(String.format("Compte %s not found", id));
        }
        return compte;
    }

    // Mutation pour sauvegarder un compte
    @MutationMapping
    public Compte saveCompte(@Argument Compte compte) {
        return compteRepository.save(compte);
    }

    // Requête pour obtenir des statistiques sur les comptes (nombre total, somme des soldes, moyenne des soldes)
    @QueryMapping
    public Map<String, Object> totalSolde() {
        long count = compteRepository.count();
        double sum = compteRepository.sumSoldes(); // Supposant une méthode sumSoldes() dans CompteRepository
        double average = count > 0 ? sum / count : 0;

        return Map.of(
                "count", count,
                "sum", sum,
                "average", average
        );
    }

}
