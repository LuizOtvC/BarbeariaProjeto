/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Chave;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import javax.crypto.SecretKey;

/**
 *
 * @author Aluno
 */
public class GeradorChaveBarbeiro {
    public static void main(String[] args) {
        SecretKey key = Jwts.SIG.HS256.key().build();
        
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Sua Chave: "+ secretString);
    }
    
}
