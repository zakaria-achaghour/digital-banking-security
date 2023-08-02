package com.zakaria.digitalbanking.services;

import com.zakaria.digitalbanking.entities.AppRole;
import com.zakaria.digitalbanking.entities.AppUser;

public interface AppAcocountService {

    AppUser addNewUser(String username, String password, String email, String confirmPassword);
    AppRole addNewRole(String role);

    void attachRoleToUser(String userName, String role);
    void dettachRoleFromuser(String userName, String role);

    AppUser loadUserByUsername(String username);
}
