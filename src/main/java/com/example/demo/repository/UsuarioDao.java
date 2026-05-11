/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.AuthBean;
import com.example.demo.model.IdUsuarioBean;
import com.example.demo.model.UsuarioBean;
import com.example.demo.model.UsuarioLogarBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioDao {
    
    public void registrar(AuthBean usuario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?,?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public AuthBean logar(String email, String senha) {
        AuthBean usuario = new AuthBean();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;        
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND senha = ?");
            
             stmt.setString(1, email);
             stmt.setString(2, senha);
             rs = stmt.executeQuery();

            if (rs.next()) {         
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public void SalvarUsuario(UsuarioBean update){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id_usuario = ? ");
            
  
                stmt.setString(1, update.getNome());
                stmt.setString(2, update.getEmail());
                stmt.setString(3, update.getSenha());
                stmt.setInt(4, update.getId_usuario());
                
                
                 stmt.executeUpdate();
            
    }catch (SQLException e){
           e.printStackTrace();
        }
        
        
    
}
    public void DeletarUsuario(IdUsuarioBean update){
            try{
                Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("DELETE from usuarios WHERE id_usuario = ? ");
            
            stmt.setInt(1, update.getId_usuario());
            
            stmt.executeUpdate();
            
            }catch (SQLException e){
           e.printStackTrace();
        }
        }
}
