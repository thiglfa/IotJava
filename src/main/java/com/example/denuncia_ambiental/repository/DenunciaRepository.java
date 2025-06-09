package com.example.denuncia_ambiental.repository;

import com.example.denuncia_ambiental.model.Denuncia;
import com.example.denuncia_ambiental.model.Denuncia.StatusDenuncia;
import com.example.denuncia_ambiental.model.Denuncia.TipoDenuncia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    Page<Denuncia> findByTipo(TipoDenuncia tipo, Pageable pageable);
    Page<Denuncia> findByStatus(StatusDenuncia status, Pageable pageable);
    Page<Denuncia> findByTipoAndStatus(TipoDenuncia tipo, StatusDenuncia status, Pageable pageable);
}
