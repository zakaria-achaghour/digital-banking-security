package com.zakaria.digitalbanking.repositories;

import com.zakaria.digitalbanking.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole findByName(String name);
}
