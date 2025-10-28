package org.example.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleUtilisateur role;

    private LocalDateTime dateCreation;

    private String statusUtilisateur;

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

    public RoleUtilisateur getRole() {

        return role;
    }
    public void setRole(RoleUtilisateur role) {
        this.role = role;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatusUtilisateur() {
        return statusUtilisateur;
    }
    public void setStatusUtilisateur(String statusUtilisateur) {
        this.statusUtilisateur = statusUtilisateur;
    }
}
