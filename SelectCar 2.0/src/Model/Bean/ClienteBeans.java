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
public class ClienteBeans {
    private String nomeCliente;
    private String endereco;
    private String uf;
    private String telefone;
    private String cpf;
    private String email;
    
    public ClienteBeans() {
    }
    public ClienteBeans(String nomeCliente, String endereco, String uf, String telefone, String cpf, String email) {
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.uf = uf;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nomeCliente; //To change body of generated methods, choose Tools | Templates.
    }    
}

