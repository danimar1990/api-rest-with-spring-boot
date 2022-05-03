package br.edu.unoesc.rent.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message="O nome de usuário deve ser preenchido")
    private String Usuario;
    @NotBlank(message="A senha deve ser preenchida")
    private String senha;
    
    public String getUsuario() {
        return Usuario;
    }
    public void getUsuario(String usuario) {
    	Usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
