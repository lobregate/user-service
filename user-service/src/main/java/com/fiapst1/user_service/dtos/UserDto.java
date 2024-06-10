package com.fiapst1.user_service.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String nome;

    private String email;

    private String senha;

}
