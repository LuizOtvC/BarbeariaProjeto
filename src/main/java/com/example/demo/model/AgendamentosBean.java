/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class AgendamentosBean {
    private int id_agendamento;
    private Date horario;
    private int id_barbeiro;

    public AgendamentosBean() {
    }

    public AgendamentosBean(int id_agendamento, Date horario, int id_barbeiro) {
        this.id_agendamento = id_agendamento;
        this.horario = horario;
        this.id_barbeiro = id_barbeiro;
    }

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(int id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }


    
    
}
