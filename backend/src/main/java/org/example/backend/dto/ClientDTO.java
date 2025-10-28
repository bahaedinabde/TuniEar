package org.example.backend.dto;

import java.util.List;

public class ClientDTO {
    private Long idUtilisateur;
    private String username;
    private String email;
    private String password;
    private String adresse;
    private List<Long> commandesIds;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Long> getCommandesIds() {
        return commandesIds;
    }

    public void setCommandesIds(List<Long> commandesIds) {
        this.commandesIds = commandesIds;
    }
}
