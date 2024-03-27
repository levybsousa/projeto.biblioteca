package com.projeto.biblioteca.security;



import com.projeto.biblioteca.model.entity.RoleEntity;
import com.projeto.biblioteca.model.entity.UserEntity;
import com.projeto.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        new UsernameNotFoundException("Username not Found");
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoleEntities()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roleEntities) {
        return roleEntities.stream().map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getNome())).collect(Collectors.toList());
    }
}
