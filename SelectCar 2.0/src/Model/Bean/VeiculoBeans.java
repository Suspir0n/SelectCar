/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

/**
 *
 * @author Evand
 */
public class VeiculoBeans {
    private String numero;
    private String placa;
    private String fabricante;
    private String modelo;
    private int anoModelo;
    private int qtdPortas;
    private String acessorios;
    
    public VeiculoBeans() {
    }
    public VeiculoBeans(String numero, String placa, String fabricante, String modelo, int anoModelo, int qtdPortas, String acessorios) {
        this.numero = numero;
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.qtdPortas = qtdPortas;
        this.acessorios = acessorios;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnoModelo() {
        return anoModelo;
    }
    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }
    public int getQtdPortas() {
        return qtdPortas;
    }
    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }
    public String getAcessorios() {
        return acessorios;
    }
    public void setAcessorios(String acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public String toString() {
        return placa; //To change body of generated methods, choose Tools | Templates.
    }    
}

