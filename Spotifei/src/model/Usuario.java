/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Akira
 * 
 *  Precisa fazer uma funcao para reconhecer se o email é realmente um email @ no final
 *  para o telefone a mesma coisa
 *  
 * 
 */
public class Usuario {
    
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public void UsuarioEmail(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void UsuarioTelefone(String nome, String tel, String senha) {
        this.nome = nome;
        this.telefone = tel;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
