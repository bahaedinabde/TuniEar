package org.example.backend.mapper;

import org.example.backend.dto.AdminDTO;
import org.example.backend.model.Admin;

public class AdminMapper {
    public static AdminDTO toDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setIdUtilisateur(admin.getIdUtilisateur());
        dto.setUsername(admin.getUsername());
        dto.setEmail(admin.getEmail());
        return dto;
    }
    public static Admin toEntity(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setIdUtilisateur(dto.getIdUtilisateur());
        admin.setUsername(dto.getUsername());
        admin.setEmail(dto.getEmail());
        return admin;
    }

}
