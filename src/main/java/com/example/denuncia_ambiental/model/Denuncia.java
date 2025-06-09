package com.example.denuncia_ambiental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Lob
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoDenuncia tipo;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusDenuncia status = StatusDenuncia.PENDENTE;

    @ManyToOne
    private Usuario usuario;

    private String localizacao;
    private String fotoUrl;

    public enum TipoDenuncia {
        DESMATAMENTO, QUEIMADA, POLUICAO_AGUA, POLUICAO_AR, OUTROS
    }

    public enum StatusDenuncia {
        PENDENTE, EM_ANALISE, RESOLVIDA, DESCARTADA
    }
}