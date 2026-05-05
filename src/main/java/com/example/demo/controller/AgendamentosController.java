/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.AgendamentosBean;
import com.example.demo.service.BarbeiroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping
    public String Criar(@RequestBody AgendamentosBean agenda){
        service.adicionar(agenda);
        return "horario adicionado";
    }
    
    @GetMapping
    public List<AgendamentosBean> lerTodosAgendamentos(){
        return service.lerTodosAgendamentos();
    }
    @GetMapping("/dataAtual")
    public List<AgendamentosBean> lerTodosAgendamentosPorData(){
        return service.lerTodosAgendamentosPorData();
    }
}
