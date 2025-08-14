package com.api.sam.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_mentor")
    public class Mentor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank(message = "O campo nome é obrigatório")
        private String nome;

        @NotBlank(message = "O campo cpf é obrigatório")
        private String cpf;

        @NotBlank(message = "O campo email é obrigatório")
        private String email;

        @NotBlank(message = "O campo senha é obrigatório")
        private String senha;

        /*@NotNull(message = "O tipo de usuário é obrigatório")
        private TipoMentor tipoDeUsuario;
         */
        @NotBlank(message = "O campo telefone é obrigatório")
        private String telefone;

        private String tempoDeExperiencia;
        private String tipoDeVinculo;


    @NotNull(message = "A área de atuação é obrigatória")
    private AreaDeAtuacao areaDeAtuacao;


    //private Endereco endereco; criar classe endereço
    }

