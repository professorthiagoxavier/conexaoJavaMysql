/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author internet
 */
public class Conexao {
    private final String statusConexao ="Não conectado";

    /**
     * @return the statusConexao
     */
    public String getStatusConexao() {
	return statusConexao;
    }
    
    public Connection getConexao(){
	Connection conexao = null; 
	
	try{
	    String driveName = "com.mysql.jdbc.Driver";
	    Class.forName(driveName);
            
	    String servidor = "localhost";
	    String schema = "crud";
	    String url = "jdbc:mysql://" + servidor + "/" + schema;
	    String usuario = "root";
	    String senha = "";
	    
	    conexao = (Connection)DriverManager.getConnection(url, usuario, senha);
	    
	}catch(ClassNotFoundException | SQLException ce){
	           System.out.println(ce.getMessage());
	}
	
	
	return conexao;
    }
    
}
