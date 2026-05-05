/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.AgendamentosBean;
import com.example.demo.model.BarbeirosBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class BarbeirosDao {  
    public List<BarbeirosBean> lerTodos(){
        List<BarbeirosBean> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM barbeiros");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                BarbeirosBean barbeiro = new BarbeirosBean();
                barbeiro.setId_barbeiro(rs.getInt("id_barbeiro"));
                barbeiro.setNome(rs.getString("nome"));
                barbeiro.setTelefone(rs.getInt("telefone"));
                barbeiro.setEmail(rs.getString("email"));
                
                dados.add(barbeiro);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return dados;   
    }
    
     public void adicionar(AgendamentosBean agendamento){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO agendamentos (horario, id_barbeiro) VALUES (?,?)");
            stmt.setDate(1, agendamento.getHorario());
            stmt.setInt(2, agendamento.getId_barbeiro());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<AgendamentosBean> lerTodosAgendamentos(){
        List<AgendamentosBean> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM agendamentos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                AgendamentosBean agendamento = new AgendamentosBean();
                agendamento.setId_agendamento(rs.getInt("id_agendamento"));
                agendamento.setHorario(rs.getDate("horario"));
                agendamento.setId_barbeiro(rs.getInt("id_barbeiro"));
                
                dados.add(agendamento);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return dados;   
    }
    public List<AgendamentosBean> lerTodosAgendamentosPorData(){
        List<AgendamentosBean> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM agendamentos WHERE horario >= CURDATE();");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                AgendamentosBean agendamento = new AgendamentosBean();
                agendamento.setId_agendamento(rs.getInt("id_agendamento"));
                agendamento.setHorario(rs.getDate("horario"));
                agendamento.setId_barbeiro(rs.getInt("id_barbeiro"));
                
                dados.add(agendamento);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return dados;   
    }

    
}
