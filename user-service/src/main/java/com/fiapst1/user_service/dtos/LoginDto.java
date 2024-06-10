package com.fiapst1.user_service.dtos;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String email;

    private String senha;

}
