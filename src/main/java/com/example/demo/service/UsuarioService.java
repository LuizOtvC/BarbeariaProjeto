/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.AuthBean;
import com.example.demo.model.UsuarioBean;
import com.example.demo.repository.BarbeirosDao;
import com.example.demo.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioDao repository;
    
    public void registrar(UsuarioBean usuario){
        repository.registrar(usuario);
    }
    public AuthBean logar(String email, String senha){
        return repository.logar(email, senha);
    }
    public void SalvarUsuario(UsuarioBean update){
        repository.SalvarUsuario(update);
    }
    
}
