/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.view;

import br.uninove.poo.dao.CarroDAO;
import br.uninove.poo.negocio.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AB1239450
 */
public class Principal {

    public static void main(String[] args) {
        //Cria uma instância de CarrosDAO na memória
        CarroDAO carro = new CarroDAO();
        Carro objCarro1 = new Carro();
        objCarro1.setAno(2018);
        objCarro1.setCor("preto");
        objCarro1.setFabricante("Hyundai");
        objCarro1.setValor(3000);

        carro.inserirCarro(objCarro1);
        //Cria a lista de carros local, que será preenchida
        List<Carro> listaDeCarros = new ArrayList<Carro>();

        //Obtém a lista de carros através do objeto
        listaDeCarros = carro.getListaDeCarros();

        //Começa a imprimir os dados
        System.out.println("ID\t|\tMarca\t|\tModelo\t|\tAno\t|\tCor\t|\tKm\t|\tPreço");
        System.out.println("----\t|\t-----\t|\t------\t|\t---\t|\t---\t|\t------\t|\t----");
        for (Carro carroLocal : listaDeCarros) { //Iterator: Para cada carro na list de carros...
            System.out.print(carroLocal.getIdCarro() + "\t|\t");
            System.out.print(carroLocal.getFabricante() + "\t|\t");
            System.out.print(carroLocal.getModelo() + "\t|\t");
            System.out.print(carroLocal.getAno() + "\t|\t");
            System.out.print(carroLocal.getCor() + "\t|\t");
            System.out.print(carroLocal.getKm() + "\t|\t");
            System.out.print(carroLocal.getValor());
            System.out.println();
        }

        Carro newCar = new Carro();
        newCar.setAno(2018);
        newCar.setCor("amarelo");
        newCar.setFabricante("Hyundai");
        newCar.setValor(400000);
        newCar.setIdCarro(3);

        carro.update(newCar);

        System.out.print("\n\n\n\n\n\n");

        //Obtém a lista de carros através do objeto
        listaDeCarros = carro.getListaDeCarros();
        //Começa a imprimir os dados
        System.out.println("ID\t|\tMarca\t|\tModelo\t|\tAno\t|\tCor\t|\tKm\t|\tPreço");
        System.out.println("----\t|\t-----\t|\t------\t|\t---\t|\t---\t|\t------\t|\t----");
        for (Carro carroLocal : listaDeCarros) { //Iterator: Para cada carro na list de carros...
            System.out.print(carroLocal.getIdCarro() + "\t|\t");
            System.out.print(carroLocal.getFabricante() + "\t|\t");
            System.out.print(carroLocal.getModelo() + "\t|\t");
            System.out.print(carroLocal.getAno() + "\t|\t");
            System.out.print(carroLocal.getCor() + "\t|\t");
            System.out.print(carroLocal.getKm() + "\t|\t");
            System.out.print(carroLocal.getValor());
            System.out.println();
        }

        //delete
        carro.delete(3);
        
        System.out.print("\n\n\n\n\n\n");
        
//Obtém a lista de carros através do objeto
        listaDeCarros = carro.getListaDeCarros();
        //Começa a imprimir os dados
        System.out.println("ID\t|\tMarca\t|\tModelo\t|\tAno\t|\tCor\t|\tKm\t|\tPreço");
        System.out.println("----\t|\t-----\t|\t------\t|\t---\t|\t---\t|\t------\t|\t----");
        for (Carro carroLocal : listaDeCarros) { //Iterator: Para cada carro na list de carros...
            System.out.print(carroLocal.getIdCarro() + "\t|\t");
            System.out.print(carroLocal.getFabricante() + "\t|\t");
            System.out.print(carroLocal.getModelo() + "\t|\t");
            System.out.print(carroLocal.getAno() + "\t|\t");
            System.out.print(carroLocal.getCor() + "\t|\t");
            System.out.print(carroLocal.getKm() + "\t|\t");
            System.out.print(carroLocal.getValor());
            System.out.println();
        }
    }
}
