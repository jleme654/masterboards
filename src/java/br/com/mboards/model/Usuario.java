/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mboards.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Julio Leme
 */
@ManagedBean
public class Usuario implements Serializable {

    private int id;
    private String nome;
    private String senha;

    public Usuario() {  }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getDataAcessoUltimoLogin(){
        Date date = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("dd 'de' MMM'.' yyyy ' às ' HH:mm:ss", new Locale("pt", "BR"));
        String s = dataFormatada.format(date);
        return s;
    }

    @Override
    public String toString() {
        return "Usuario{nome + "+nome+", senha=" + senha + "}";
    }
}

