package com.example.car_park_management.security;

import com.example.car_park_management.model.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfo implements UserDetails {

    private String account;
    private String password;
    private GrantedAuthority grantedAuthority;

    public UserInfo(Employee employee) {
        this.account = employee.getAccount();
        this.password = employee.getPassword();
        this.grantedAuthority = new SimpleGrantedAuthority(employee.getDepartment());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(this.grantedAuthority);
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
