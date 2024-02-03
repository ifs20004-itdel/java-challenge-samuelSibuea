package ist.challenge.samuel_sibuea.service;

import ist.challenge.samuel_sibuea.entity.User;
import ist.challenge.samuel_sibuea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User editUser(@RequestBody User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findUserById(id);
    }

    public boolean existByUsername(String username){
        return userRepository.existsUserByUsername(username);
    }

}
