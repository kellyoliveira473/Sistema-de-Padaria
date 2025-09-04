package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_cadastro")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf",unique = true)
    private String cpf;
    @Column(name = "Telefone")
    private Integer telefone;
    @Column(name = "email")
    private String email;
    @Column(name="data_nascimento")
    private LocalDate datanascimento;

}
