/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Carro;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author internet
 */
public class CarroDAO {

    public List<Carro> getListarCarro() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM carros";
        List<Carro> listCarros = new ArrayList<Carro>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Carro objCarro = new Carro();
                objCarro.setIdCarro(resultado.getInt("idCarro"));
                objCarro.setAnoFabricacao(resultado.getInt("anoFabricacao"));
                objCarro.setCor(resultado.getString("cor"));
                objCarro.setFabricante(resultado.getString("fabricante"));
                objCarro.setKm(resultado.getDouble("km"));
                objCarro.setModelo(resultado.getString("modelo"));
                objCarro.setValor(resultado.getDouble("Valor"));
                listCarros.add(objCarro);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }

    public boolean inserir(Carro objCarro) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "INSERT INTO `carros`(`fabricante`, `modelo`, `anoFabricacao`, `cor`, `km`, `valor`)";

            sql += " VALUES(";
            sql += "'" + objCarro.getFabricante() + "',"; //varchar 
            sql += "'" + objCarro.getModelo() + "',"; //varchar 
            sql += objCarro.getAnoFabricacao() + ","; //inteiro 
            sql += "'" + objCarro.getCor() + "',"; //varchar 
            sql += objCarro.getKm() + ","; //decimal
            sql += objCarro.getValor(); //decimal
            sql += " );";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
