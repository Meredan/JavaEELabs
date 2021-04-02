package com.example.demo.service;

import com.example.demo.model.PermissionEntity;
import com.example.demo.model.UserEntity;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    private static List<GrantedAuthority> mapAuthorities(final List<PermissionEntity> permissions) {
        return permissions.stream()
                .map(PermissionEntity::getPermission)
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserEntity user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with login: " + username));

        return new UserDetails(
                username,
                user.getPassword(),
                mapAuthorities(user.getPermissions()),
                user.getCustomAuthField(),
                user.getLikedBooks()
        );
    }

}
