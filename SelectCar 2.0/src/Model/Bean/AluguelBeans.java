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
public class AluguelBeans{
    private int idAluguel;
    public VeiculoBeans veiculo;
    private String dataAluguel;
    private String dataEntrega;
    private ClienteBeans cliente;
    private char entregue;
    private String observacao;
    private float valorPago;
    
    public AluguelBeans() {
    }
    public AluguelBeans(int idAluguel, VeiculoBeans veiculo, String dataAluguel, String dataEntrega, ClienteBeans cliente, char entregue, String observacao, float valorPago) {
        this.idAluguel = idAluguel;
        this.veiculo = veiculo;
        this.dataAluguel = dataAluguel;
        this.dataEntrega = dataEntrega;
        this.cliente = cliente;
        this.entregue = entregue;
        this.observacao = observacao;
        this.valorPago = valorPago;
    }
    public int getIdAluguel() {
        return idAluguel;
    }
    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }
    public VeiculoBeans getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(VeiculoBeans veiculo) {
        this.veiculo = veiculo;
    }
    public String getDataAluguel() {
        return dataAluguel;
    }
    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }
    public String getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public ClienteBeans getCliente() {
        return cliente;
    }
    public void setCliente(ClienteBeans cliente) {
        this.cliente = cliente;
    }
    public char getEntregue() {
        return entregue;
    }
    public void setEntregue(char entregue) {
        this.entregue = entregue;
    }
     public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
     public float getValorPago() {
        return valorPago;
    }
    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return dataAluguel; //To change body of generated methods, choose Tools | Templates.
    }    

    public int getCliente(ClienteBeans cpfClient) {
        return 0;
    }

    public int getVeiculo(VeiculoBeans placaVeiculo) {
        return 0;
    }
}