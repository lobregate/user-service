package com.fiapst1.user_service.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="NOME")
    private String nome;

    @Column(name="SENHA")
    private String senha;

}
