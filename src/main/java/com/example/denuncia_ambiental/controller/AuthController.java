package com.example.denuncia_ambiental.controller;

import com.example.denuncia_ambiental.dto.LoginDTO;
import com.example.denuncia_ambiental.dto.TokenDTO;
import com.example.denuncia_ambiental.model.Usuario;
import com.example.denuncia_ambiental.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        TokenDTO tokenDTO = usuarioService.autenticar(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }
}
