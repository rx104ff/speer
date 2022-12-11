package com.speer.interview.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.speer.interview.models.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class JwtUserDetails implements UserDetails {
    private static final long serialVersionUID = 5155720064139820502L;
    private final Long id;
    private final String username;
    @JsonIgnore
    private final String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUserDetails create(User user) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("USER"));

        return new JwtUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public  Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
