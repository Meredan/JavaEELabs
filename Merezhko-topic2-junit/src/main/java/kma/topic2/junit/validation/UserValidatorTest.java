package kma.topic2.junit.validation;

import kma.topic2.junit.exceptions.ConstraintViolationException;
import kma.topic2.junit.exceptions.LoginExistsException;
import kma.topic2.junit.model.NewUser;
import kma.topic2.junit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


@ExtendWith(MockitoExtension.class)
public class UserValidatorTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserValidator validator;

    @Test
    void validateUser() {
        NewUser user = NewUser.builder().login("Java").fullName("John Doe").password("12345").build();
        validator.validateNewUser(user);
    }


    @Test
    void incorrectPass() {
        NewUser user = NewUser.builder().login("Java").fullName("John Doe").password("______").build();
        assertThatThrownBy(() -> validator.validateNewUser(user)).isInstanceOfSatisfying(ConstraintViolationException.class,
                        errs -> assertThat(errs.getErrors().contains("Password doesn't match regex")));
    }

    @Test
    void incorrectPassSize() {
        NewUser user = NewUser.builder().login("Java").fullName("John Doe").password("12").build();
        assertThatThrownBy(() -> validator.validateNewUser(user)).isInstanceOfSatisfying(ConstraintViolationException.class,
                        errs -> assertThat(errs.getErrors().contains("Password has invalid size")));
    }
}
