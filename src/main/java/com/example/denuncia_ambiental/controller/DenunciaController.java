package com.example.denuncia_ambiental.controller;
import com.example.denuncia_ambiental.dto.DenunciaDTO;
import com.example.denuncia_ambiental.model.Denuncia;
import com.example.denuncia_ambiental.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping
    public ResponseEntity<DenunciaDTO> criarDenuncia(@RequestBody Denuncia denuncia,
                                                     Authentication authentication) {
        DenunciaDTO denunciaDTO = denunciaService.criarDenuncia(denuncia, authentication.getName());
        return ResponseEntity.ok(denunciaDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DenunciaDTO>> listarDenuncias(
            @RequestParam(required = false) Denuncia.TipoDenuncia tipo,
            @RequestParam(required = false) Denuncia.StatusDenuncia status,
            Pageable pageable) {

        Page<DenunciaDTO> denuncias = denunciaService.listarDenuncias(tipo, status, pageable);
        return ResponseEntity.ok(denuncias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaDTO> buscarDenuncia(@PathVariable Long id) {
        DenunciaDTO denuncia = denunciaService.buscarPorId(id);
        return ResponseEntity.ok(denuncia);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id,
                                                @RequestParam Denuncia.StatusDenuncia novoStatus) {
        denunciaService.atualizarStatus(id, novoStatus);
        return ResponseEntity.noContent().build();
    }
}
