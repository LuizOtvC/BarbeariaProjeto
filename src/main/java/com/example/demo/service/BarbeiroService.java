/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.AgendamentosBean;
import com.example.demo.model.BarbeirosBean;
import com.example.demo.repository.BarbeirosDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class BarbeiroService {
    @Autowired
    private BarbeirosDao repository;
    
    
    
    
    public List<BarbeirosBean> lerTodos(){
        return repository.lerTodos();
    }
    public void adicionar(AgendamentosBean agendamento) {
        repository.adicionar(agendamento);
    }
    
    public List<AgendamentosBean> lerTodosAgendamentos(){
        return repository.lerTodosAgendamentos();
    }
    public List<AgendamentosBean> lerTodosAgendamentosPorData(){
        return repository.lerTodosAgendamentosPorData();
    }
}
