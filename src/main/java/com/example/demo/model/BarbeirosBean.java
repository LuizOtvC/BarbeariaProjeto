/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

/**
 *
 * @author Aluno
 */
public class BarbeirosBean {
    private int id_barbeiro;
    private String nome;
    private int telefone;
    private String email;

    public BarbeirosBean() {
    }

    public BarbeirosBean(int id_barbeiro, String nome, int telefone, String email) {
        this.id_barbeiro = id_barbeiro;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(int id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
