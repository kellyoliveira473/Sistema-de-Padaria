package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_padaria")
public class Padaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "produtos")
    private String produtos;
    @Column(name = "valor")
    private Double valor;


}
