package org.example.backend.dto;

public class AdminDTO {
    private Long idUtilisateur;
    private String username;
    private String email;
    // Add other specific admin user fields here

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
}
