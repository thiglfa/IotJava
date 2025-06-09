package com.example.denuncia_ambiental.service;

import com.example.denuncia_ambiental.dto.DenunciaDTO;
import com.example.denuncia_ambiental.model.Denuncia;
import com.example.denuncia_ambiental.model.Usuario;
import com.example.denuncia_ambiental.repository.DenunciaRepository;
import com.example.denuncia_ambiental.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DenunciaDTO criarDenuncia(Denuncia denuncia, String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        denuncia.setUsuario(usuario);
        Denuncia denunciaSalva = denunciaRepository.save(denuncia);
        return toDTO(denunciaSalva);
    }

    public Page<DenunciaDTO> listarDenuncias(Denuncia.TipoDenuncia tipo,
                                             Denuncia.StatusDenuncia status,
                                             Pageable pageable) {
        Page<Denuncia> denuncias;

        if (tipo != null && status != null) {
            denuncias = denunciaRepository.findByTipoAndStatus(tipo, status, pageable);
        } else if (tipo != null) {
            denuncias = denunciaRepository.findByTipo(tipo, pageable);
        } else if (status != null) {
            denuncias = denunciaRepository.findByStatus(status, pageable);
        } else {
            denuncias = denunciaRepository.findAll(pageable);
        }

        return denuncias.map(this::toDTO);
    }

    public DenunciaDTO buscarPorId(Long id) {
        Denuncia denuncia = denunciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));
        return toDTO(denuncia);
    }

    public void atualizarStatus(Long id, Denuncia.StatusDenuncia novoStatus) {
        Denuncia denuncia = denunciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));
        denuncia.setStatus(novoStatus);
        denunciaRepository.save(denuncia);
    }

    private DenunciaDTO toDTO(Denuncia denuncia) {
        DenunciaDTO dto = new DenunciaDTO();
        dto.setId(denuncia.getId());
        dto.setTitulo(denuncia.getTitulo());
        dto.setDescricao(denuncia.getDescricao());
        dto.setTipo(denuncia.getTipo());
        dto.setDataCriacao(denuncia.getDataCriacao());
        dto.setStatus(denuncia.getStatus());
        dto.setUsuarioNome(denuncia.getUsuario().getNome());
        dto.setLocalizacao(denuncia.getLocalizacao());
        dto.setFotoUrl(denuncia.getFotoUrl());
        return dto;
    }
}
