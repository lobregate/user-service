package com.fiapst1.user_service.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name="ID")
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="NOME")
    private String nome;

    @Column(name="SENHA")
    private String senha;

}
