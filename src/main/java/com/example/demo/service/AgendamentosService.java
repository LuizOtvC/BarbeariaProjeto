/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.repository.BarbeirosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class AgendamentosService {
    
    @Autowired
    private BarbeirosDao repository;
    
    
}
