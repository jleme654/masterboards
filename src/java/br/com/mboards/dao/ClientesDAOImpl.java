/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mboards.dao;

import br.com.mboards.model.Clientes;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
@ManagedBean
public class ClientesDAOImpl implements ClientesDAO, Serializable {

    public static ArrayList lista = null;
    public String telefone;

    private Clientes lerUmaLinhaCliente(ResultSet rs) throws SQLException {
        Clientes vo = new Clientes();
        vo.setId(rs.getInt("id"));
        vo.setNome(rs.getString("Nome"));
        vo.setEmail(rs.getString("Email"));
        vo.setTelefone(rs.getString("Telefone"));
        return vo;
    }

    private ArrayList lerLinhas(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Clientes linhaCliente = lerUmaLinhaCliente(rs);
            lista.add(linhaCliente);
        }

        return lista;
    }

    @Override
    public ArrayList<Clientes> getAllClientes() {
        PreparedStatement st = null;
        try {
            lista = new ArrayList();
            st = (PreparedStatement) Conexao.conecta().prepareStatement("select * from clientes");
            ResultSet rs = st.executeQuery();
            lista = lerLinhas(rs);
        } catch (SQLException e) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

    @Override
    public void save(String nome, String telefone, String email) {
        PreparedStatement st;
        try {
            st = (PreparedStatement) Conexao.conecta().prepareStatement("insert into clientes (nome,telefone, email) values (?,?,?)");
            st.setString(1, nome);
            st.setString(2, telefone);
            st.setString(3, email);
            int result = st.executeUpdate();
            if (result == 1) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso", ""));
           
                return;
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Nao foi possivel cadastrar o cliente", ""));

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void remove(Clientes cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Clientes cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void reset() {
        this.telefone = null;
        RequestContext.getCurrentInstance().reset("form:panel");
    }
}
