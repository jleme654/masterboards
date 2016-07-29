/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mboards.dao;


import br.com.mboards.model.Clientes;
import java.util.ArrayList;

/**
 *
 * @author jleme
 */
public interface ClientesDAO {

    public ArrayList<Clientes> getAllClientes();

    public void save(String nome, String telefone, String email);

    public void remove(Clientes cliente);

    public void update(Clientes cliente);
}
