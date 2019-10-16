/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.view;

import br.uninove.poo.dao.CarroDAO;
import br.uninove.poo.dao.Conexao;
import br.uninove.poo.negocio.Carro;
import com.mysql.jdbc.Connection;
import java.util.List;

/**
 *
 * @author internet
 */
public class Principal {

    public static void main(String[] args) {
        Conexao objConexao = new Conexao();
        Connection conn = objConexao.getConexao();//chamando o método conectar
        System.out.println(objConexao.getStatusConexao());

        CarroDAO objCarroDao = new CarroDAO();
        Carro objCarroNew = new Carro();
        objCarroNew.setAnoFabricacao(2009);
        objCarroNew.setCor("Azul");
        objCarroNew.setFabricante("Fiat");
        objCarroNew.setKm(0);
        objCarroNew.setModelo("Toro");
        objCarroNew.setValor(110000);

        if (objCarroDao.inserir(objCarroNew)) {
            System.out.println("Inserido com sucesso");
        } else {
            System.out.println("Erro ao inserir");
        }

        List<Carro> lista = objCarroDao.getListarCarro();
        for (Carro item : lista) {
            System.out.print(item.getIdCarro() + ",");
            System.out.print(item.getAnoFabricacao() + ",");
            System.out.print(item.getCor() + ",");
            System.out.print(item.getFabricante() + ",");
            System.out.print(item.getKm() + ",");
            System.out.print(item.getModelo() + ",");
            System.out.print(item.getValor() + ",");
            System.out.println("");
        }

    }
}
