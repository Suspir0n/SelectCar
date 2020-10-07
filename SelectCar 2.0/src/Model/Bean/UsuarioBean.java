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
public class UsuarioBean {
    
    private String coduser;
    private String nomeuser;
    private String cargouser;
    private String loginuser;
    private String emailuser;
    private String senhauser;
    
    public UsuarioBean(String coduser, String nomeuser, String cargouser, String loginuser, String emailuser, String senhauser) {
        this.coduser = coduser;
        this.nomeuser = nomeuser;
        this.cargouser = cargouser;
        this.loginuser = loginuser;
        this.emailuser = emailuser;
        this.senhauser = senhauser;
    }

    public UsuarioBean() {
    }
    public String getCoduser() {
        return coduser;
    }
    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }
    public String getNomeuser() {
        return nomeuser;
    }
    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }
    public String getCargouser() {
        return cargouser;
    }
    public void setCargouser(String cargouser) {
        this.cargouser = cargouser;
    }
    public String getLoginuser() {
        return loginuser;
    }
    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }
    public String getEmailuser() {
        return emailuser;
    }
    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }
    public String getSenhauser() {
        return senhauser;
    }
    public void setSenhauser(String senhauser) {
        this.senhauser = senhauser;
    }

    @Override
    public String toString() {
        return nomeuser; //To change body of generated methods, choose Tools | Templates.
    }    
}
