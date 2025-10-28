package org.example.backend.service;


import org.example.backend.dto.AdminDTO;
import org.example.backend.mapper.AdminMapper;
import org.example.backend.model.Admin;
import org.example.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDTO> getAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(AdminMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdminDTO getById(Long id) {
        return adminRepository.findById(id)
                .map(AdminMapper::toDTO)
                .orElse(null);
    }

    public AdminDTO create(AdminDTO dto) {
        Admin admin = AdminMapper.toEntity(dto);
        Admin saved = adminRepository.save(admin);
        return AdminMapper.toDTO(saved);
    }

    public AdminDTO update(Long id, AdminDTO dto) {
        return adminRepository.findById(id)
                .map(existing -> {
                    existing.setUsername(dto.getUsername());
                    existing.setEmail(dto.getEmail());
                    Admin updated = adminRepository.save(existing);
                    return AdminMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
