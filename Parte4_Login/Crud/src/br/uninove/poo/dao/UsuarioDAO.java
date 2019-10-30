/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Carro;
import br.uninove.poo.negocio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago.xavier
 */
public class UsuarioDAO {

    public Boolean Login(Usuario user) {
        try {
            //Conecta ao banco através da classe de conexão:
            Conexao con = new Conexao();
            con.getConexao();

            //Select na tablea de carros:
            String sql = "select * from usuarios  where usuario = ? and senha = ?";

            //Executa a query
            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            comando.setString(1, user.getUsuario());
            comando.setString(2, user.getSenha());
            ResultSet resultado = comando.executeQuery();

            //Prepara a lista de carros para retornar
            List<Carro> listaDeCarros = new ArrayList<Carro>();

            //para cada item retonrado no select, faça...
            //Ao terminar o laço, fecha a conexão
            Boolean resultQuery = resultado.next();
            resultado.close();
            comando.close();
            con.getConexao().close();

            //Retorna a lista de carros
            return resultQuery;

        } catch (Exception e) { //Se der algum exessão...
            System.out.println(e.getMessage());
            return null;
        }
    }
}
