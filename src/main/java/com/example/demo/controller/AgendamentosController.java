/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.AgendamentosBean;
import com.example.demo.service.BarbeiroService;
import com.example.demo.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentosController {
    @Autowired
    private BarbeiroService service;
    
    @Autowired
    private TokenService serviceToken;
    
    @PostMapping
    public String Criar(@RequestBody AgendamentosBean agenda, @RequestHeader("Authorization") String auth){
        System.out.println(auth);
        String token = auth.replace("Bearer ", "");
        if(serviceToken.validarToken(token)){
            service.adicionar(agenda);
            return "horario adicionado";
        }else{
            return null;
        }
        
    }
    
    @GetMapping
    public List<AgendamentosBean> lerTodosAgendamentos(@RequestHeader("Authorization") String auth){
        System.out.println(auth);
        String token = auth.replace("Bearer ", "");
        if(serviceToken.validarToken(token)){
            return service.lerTodosAgendamentos();
        }else{
            return null;
        }
        
    }
    @GetMapping("/data-atual")
    public List<AgendamentosBean> lerTodosAgendamentosPorData(@RequestHeader("Authorization") String auth){
        System.out.println(auth);
        String token = auth.replace("Bearer ", "");
        if(serviceToken.validarToken(token)){
            return service.lerTodosAgendamentosPorData();
        }else{
            return null;
        }
        
    }
}
