package com.kingwoodart.service.impl;

import com.kingwoodart.entity.Role;
import com.kingwoodart.repository.RoleRepository;
import com.kingwoodart.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;


    @Override
    public Role createRole(Role role) {
        Role addRole = repository.save(role);
        return addRole;
    }
}
