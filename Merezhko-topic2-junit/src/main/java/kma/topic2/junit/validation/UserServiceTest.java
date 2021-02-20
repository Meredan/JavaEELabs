package kma.topic2.junit.validation;

import kma.topic2.junit.Main;
import kma.topic2.junit.exceptions.UserNotFoundException;
import kma.topic2.junit.model.NewUser;
import kma.topic2.junit.model.User;
import kma.topic2.junit.repository.UserRepository;
import kma.topic2.junit.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = Main.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @MockBean
    private UserValidator userValidator;

    @Test
    void newUser() {
        NewUser user = NewUser.builder().login("Java").fullName("John Doe").password("12345").build();
        userService.createNewUser(user);
        Mockito.verify(userValidator).validateNewUser(ArgumentMatchers.any());
        User userMere = userRepository.getUserByLogin(user.getLogin());
        Assertions.assertEquals(user.getFullName(), userMere.getFullName());
        Assertions.assertEquals(user.getLogin(), userMere.getLogin());
        Assertions.assertEquals(user.getPassword(), userMere.getPassword());
    }

    @Test
    void getUserByLogin() {
        NewUser user = NewUser.builder().login("Java").fullName("John Doe").password("12345").build();
        userRepository.saveNewUser(user);
        User userMere = userService.getUserByLogin(user.getLogin());
        Assertions.assertEquals(user.getLogin(), userMere.getLogin());
        Assertions.assertEquals(user.getFullName(), userMere.getFullName());
        Assertions.assertEquals(user.getPassword(), userMere.getPassword());
    }

    @Test
    void failGetUserByLogin() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {userService.getUserByLogin("none");});
    }
}
