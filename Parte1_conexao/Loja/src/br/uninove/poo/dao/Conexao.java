/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author internet
 */
public class Conexao {
    private String statusConexao = "Não conectado!";
    /**
     * @return the statusConexao
     */
    public String getStatusConexao() {
        return statusConexao;
    }
    
    public Connection getConexao(){
        Connection conn = null;
        String driveName = "com.mysql.jdbc.Driver";
        String servidor = "localhost";
        String schema = "loja";
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://" + servidor + "/" + schema;
        try {
            Class.forName(driveName);
            conn = (Connection) DriverManager.getConnection(url,usuario,senha);
           
            if(conn != null)
                statusConexao = "Conectado com sucesso!";
            else
                statusConexao = "Erro na conexão";
        } catch (ClassNotFoundException | SQLException ex) {
            statusConexao = ex.getMessage();
        }
        
        return conn;
    }
    
    
    
    
    
    
}
