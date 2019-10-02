/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.view;

import br.uninove.poo.dao.Conexao;
import com.mysql.jdbc.Connection;

/**
 *
 * @author internet
 */
public class Principal {
    public static void main(String[] args) {
          Conexao objConexao = new Conexao();
          Connection conn = objConexao.getConexao();//chamando o método conectar
          System.out.println(objConexao.getStatusConexao());
    }
}
