package com.exam.domain.vo;

import java.util.Objects;

/**
 * Contenedor de tipos de identidad para el dominio de evaluaciones.
 */
public final class Identities {

    // Clase para la identidad de preguntas
    public static final class QRef {
        private final String _innerCode;

        public QRef(String code) {
            // Validación para diferenciarlo del original
            this._innerCode = Objects.requireNonNull(code, "Reference code required");
        }

        public String asRaw() { 
            return _innerCode; 
        }
    }

    // Clase para la identidad del estudiante
    public static final class StudentToken {
        private final String _token;

        public StudentToken(String token) {
            this._token = token;
        }

        public String serial() { 
            return _token; 
        }
    }

    // Constructor privado para evitar que instancien la clase contenedora
    private Identities() {}
}