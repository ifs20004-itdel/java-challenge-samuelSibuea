package ist.challenge.samuel_sibuea.repository;

import ist.challenge.samuel_sibuea.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AuthRepositoryTests {

    @Autowired
    private AuthRepository authRepository;

    @DisplayName("JUnit test for register User")
    @Test
    public void givenUserObject_whenRegister_thenReturnSavedUser(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");

        User savedUser  = authRepository.save(user);

        Assertions.assertNotNull(savedUser.getId());
        Assertions.assertEquals(user.getUsername(), savedUser.getUsername());
        Assertions.assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @DisplayName("JUnit test for login User")
    @Test
    public void givenTrueUserCredential_whenLogin_thenReturnTrue(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        authRepository.save(user);

        boolean savedUserExists = authRepository.existsUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        Assertions.assertEquals(true,savedUserExists);
    }

    @DisplayName("Junit test to show all user")
    @Test
    public void get_allUser(){

        authRepository.deleteAll();

        User user1 = new User();
        user1.setUsername("root");
        user1.setPassword("root");

        User user2 = new User();
        user2.setUsername("test");
        user2.setPassword("test");

        authRepository.save(user1);
        authRepository.save(user2);
        List<User> data = authRepository.findAll();

        Assertions.assertNotNull(data);
        Assertions.assertEquals(2, data.size());
    }
}
