package com.example.denuncia_ambiental.dto;

import lombok.Data;

@Data
public class TokenDTO {
    private String token;
    private String tipo;

    public TokenDTO(String token, String bearer) {
    }
}
