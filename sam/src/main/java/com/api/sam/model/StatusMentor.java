package com.api.sam.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusMentor {
    PENDENTE,
    PROCESSANDO,
    CONCLUIDO;

    @JsonCreator
    public static StatusMentor from(String value) {
        return StatusMentor.valueOf(value.toUpperCase());
    }
}
