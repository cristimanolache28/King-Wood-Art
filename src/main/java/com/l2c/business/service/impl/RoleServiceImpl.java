package com.l2c.business.service.impl;

import com.l2c.business.entity.Role;
import com.l2c.business.repository.RoleRepository;
import com.l2c.business.service.RoleService;
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
