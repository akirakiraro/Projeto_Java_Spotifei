/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Akira
 */
public class Musica {
    private String titulo;
    private int duracao;
    private int status;
    private String artista;
    private int IDartista;

    public Musica(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.status = 0;
    }

    public Musica(String titulo, int duracao, String artista) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.artista = artista;
    }
    public Musica(String titulo, int duracao, int IDartista) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.IDartista = IDartista;
    }

    public int getIDartista() {
        return IDartista;
    }

    public void setIDartista(int IDartista) {
        this.IDartista = IDartista;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
