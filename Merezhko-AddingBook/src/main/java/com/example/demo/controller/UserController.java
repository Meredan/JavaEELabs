package com.example.demo.controller;

import com.example.demo.model.BookEntity;
import com.example.demo.model.PermissionEntity;
import com.example.demo.model.UserEntity;
import com.example.demo.model.UserService;
import com.example.demo.model.UserDetails;
import com.example.demo.model.Permission;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final com.example.demo.service.UserService userService;

    public UserController(com.example.demo.service.UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping("/user-details")
    public ResponseEntity<UserDetails> userDetails() {
        final UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDetails);
    }


    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping(value = "/fav-books")
    public ResponseEntity<Set<BookEntity>> userFavBooks() {
        final UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userService.getUsersLikedBooks(userDetails.getUsername()));
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/fav-books/{bookId}", method = RequestMethod.POST)
    public ResponseEntity<Set<BookEntity>> bookFormControllerAdd(@PathVariable String bookId) {
        final UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.addUsersLikedBooks(userDetails.getUsername(), Integer.parseInt(bookId));
        return ResponseEntity.ok(userEntity.getLikedBooks());
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/fav-books/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<Set<BookEntity>> bookFormControllerDelete(@PathVariable String bookId) {
        final UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.deleteUsersLikedBooks(userDetails.getUsername(), Integer.parseInt(bookId));
        return ResponseEntity.ok(userEntity.getLikedBooks());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserService> registerUserController(@Valid @RequestBody final UserService userModel) {
        System.out.println(userModel.getPassword());
        List<PermissionEntity> permissions = new ArrayList<>();
        permissions.add(new PermissionEntity(1, Permission.LIKED_BOOK));
        permissions.add(new PermissionEntity(2, Permission.VIEW_CATALOG));
        UserEntity userEntity = this.userService.registerUser(userModel.getLogin(), userModel.getPassword(), userModel.getCustomAuthField(), permissions);
        UserService userService = new UserService();
        userService.setId(userEntity.getId());
        userService.setPassword(null);
        userService.setCustomAuthField(userEntity.getCustomAuthField());
        userService.setLogin(userEntity.getLogin());
        return ResponseEntity.ok(userService);
    }
}

