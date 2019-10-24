/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AB1239450
 */
public class CarroDAO {

    //Método que retorna a lsta de carros, com todos os carros do sistema
    public List<Carro> getListaDeCarros() {

        try {
            //Conecta ao banco através da classe de conexão:
            Conexao con = new Conexao();
            con.getConexao();

            //Select na tablea de carros:
            String sql = "select * from carros;";

            //Executa a query
            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            //Prepara a lista de carros para retornar
            List<Carro> listaDeCarros = new ArrayList<Carro>();

            //para cada item retonrado no select, faça...
            while (resultado.next()) {
                Carro c = new Carro(); //Cria um carro novo na memória
                c.setIdCarro(resultado.getInt("idCarro")); //Seta o ID dele
                c.setFabricante(resultado.getString("fabricante")); //Seta o fabricante
                c.setModelo(resultado.getString("modelo")); //Seta o modelo
                c.setCor(resultado.getString("cor")); //Seta a cor
                c.setKm(resultado.getDouble("km")); //Seta a KM
                c.setValor(resultado.getDouble("valor")); //Seta o valor do carro
                c.setAno(resultado.getInt("anoFabricacao")); //Seta o ano de fabricação

                //insere o carro na lista local
                listaDeCarros.add(c);
            }

            //Ao terminar o laço, fecha a conexão
            resultado.close();
            comando.close();
            con.getConexao().close();

            //Retorna a lista de carros
            return listaDeCarros;

        } catch (Exception e) { //Se der algum exessão...
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean inserirCarro(Carro c) {
        try {
            //Seta e abre a conexão
            Conexao conexao = new Conexao();
            conexao.getConexao();

            //Query de inserção (as aspas são muit importantes):
            String sql = "";
            sql += "insert into Carros (fabricante, modelo, "
                    + "anoFabricacao, cor, km, valor)";
            sql += " VALUES ";
            sql += " ('" + c.getFabricante() + "', '" + c.getModelo() + "', "
                    + c.getAno() + ",'" + c.getCor() + "', " + c.getKm() + ", "
                    + c.getValor() + ")";

            //Executa
            PreparedStatement comando = conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate(sql);
            return true; //se inseriu, retorna verdadeiro.

        } catch (SQLException e) { //Se deu algum erro...
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(Carro c) {
        try {
            //Seta e abre a conexão
            Conexao conexao = new Conexao();
            conexao.getConexao();

            //Query de inserção (as aspas são muit importantes):
            String sql;
            sql = "update carros set";
            sql += " fabricante = '" + c.getFabricante() + "'";
            sql += " ,cor = '" + c.getCor() + "'";
            sql += ", km = " + c.getKm();
            sql += ", valor = " + c.getValor();
            sql += ", anoFabricacao = " + c.getAno();
            sql += " where idcarro = " + c.getIdCarro();

            //Executa
            PreparedStatement comando = conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate(sql);
            return true; //se inseriu, retorna verdadeiro.

        } catch (SQLException e) { //Se deu algum erro...
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int idCarro) {

        String deleteSQL = "delete from carros where idcarro = ?";
        //Seta e abre a conexão
        Conexao conexao = new Conexao();
        Connection conn=conexao.getConexao();

        try {
            PreparedStatement comando = conn.prepareStatement(deleteSQL);
            comando.setInt(1, idCarro);

            // execute delete SQL stetement
            comando.executeUpdate();
        } catch (SQLException e) { //Se deu algum erro...
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
