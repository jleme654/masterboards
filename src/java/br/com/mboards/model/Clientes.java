/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mboards.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
@ManagedBean
public class Clientes implements Serializable {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    public Clientes() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
