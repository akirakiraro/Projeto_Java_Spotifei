/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unieryatate
 */
public class MusicaSelecionada {
    
    private String titulo;
    private String duracao;
    private String artista;
    private String genero;

    public MusicaSelecionada(String titulo, String duracao, String artista, String genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.artista = artista;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }
    
    
}
