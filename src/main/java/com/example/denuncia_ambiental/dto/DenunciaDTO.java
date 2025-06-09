package com.example.denuncia_ambiental.dto;


import com.example.denuncia_ambiental.model.Denuncia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Denuncia.TipoDenuncia tipo;
    private LocalDateTime dataCriacao;
    private Denuncia.StatusDenuncia status;
    private String usuarioNome;
    private String localizacao;
    private String fotoUrl;
}
