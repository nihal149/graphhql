package com.example.GraphQl.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GraphQlExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {

            @Override
            public String getMessage() {
                // Retourne le message de l'exception levée
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                // Permet de retourner la localisation (facultatif, ici null)
                return null;
            }

            @Override
            public ErrorClassification getErrorType() {
                // Peut retourner un type d'erreur spécifique ou null (facultatif)
                return null;
            }
        };
    }
}

