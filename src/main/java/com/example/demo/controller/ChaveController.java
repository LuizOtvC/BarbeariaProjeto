/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.AuthBean;
import com.example.demo.model.UsuarioBean;
import com.example.demo.service.BarbeiroService;
import com.example.demo.service.TokenService;
import com.example.demo.service.UsuarioService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/chave")
public class ChaveController {
    @Autowired
    private TokenService service;
    
    @Autowired
    private UsuarioService servicea;
    
    
    @PostMapping("/registro")
    public String registrar(@RequestBody UsuarioBean usuario) {
        servicea.registrar(usuario);
        return "sucesso";
    }
    
    
    
    @PostMapping("/logar")
    public String logar(@RequestBody AuthBean req){
        AuthBean usuario = servicea.logar(req.getEmail(), req.getSenha());  
        if(usuario.getEmail() != null){
            return service.gerarToken(usuario.getEmail());
        }else{
            return "invalido";
        }
    }
    
    @PostMapping("/validar-token")
    public String validarToken(@RequestParam String token) {
        if (service.validarToken(token)) {
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + 
                   ", Emitido em: " + claims.getIssuedAt() + 
                   ", Expira em: " + claims.getExpiration();
        } else {
            return "Token inválido ou expirado!";
        }
    }
    
    @PutMapping("/modificar/{id}")
    public String SalvarUsuario(@PathVariable int id, @RequestBody UsuarioBean update){
        update.setId_usuario(id);
        servicea.SalvarUsuario(update);
        return "usuario atualizado com sucesso";
    }
    
}
