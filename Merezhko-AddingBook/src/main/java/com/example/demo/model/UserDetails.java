package com.example.demo.model;

import com.example.demo.model.BookEntity;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;

@Getter
@ToString(callSuper = true)
public class UserDetails extends User {

    private final String customAuthField;
    private final Set<BookEntity> likedBooks;

    public UserDetails(
            final String username,
            final String password,
            final List<? extends GrantedAuthority> authorities,
            final String customAuthField,
            final Set<BookEntity> likedBooks) {
        super(username, password, authorities);
        this.customAuthField = customAuthField;
        this.likedBooks = likedBooks;
    }
}
