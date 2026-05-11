/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.AgendamentosBean;
import com.example.demo.model.BarbeirosBean;
import com.example.demo.service.BarbeiroService;
import com.example.demo.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/barbeiros")
public class BarbeirosController {
    @Autowired
    private BarbeiroService service;
    
    @Autowired
    private TokenService serviceToken;
    
    @GetMapping
    public List<BarbeirosBean> lerTodos(@RequestHeader("Authorization") String auth){
        String token = auth.replace("Bearer ", "");
        serviceToken.validarToken(token);
        return service.lerTodos();
        
        
    }
    
}
