package ist.challenge.samuel_sibuea.service;

import ist.challenge.samuel_sibuea.dto.AuthRequestDto;
import ist.challenge.samuel_sibuea.entity.User;
import ist.challenge.samuel_sibuea.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public boolean findByUsername(String username){
        return authRepository.existsUserByUsername(username);
    }

    public User registerUser(AuthRequestDto authRequestDto){
        User user = new User();
        user.setUsername(authRequestDto.getUsername());
        user.setPassword(authRequestDto.getPassword());
        return authRepository.save(user);
    }

    public boolean findUser(AuthRequestDto authRequestDto){
        User user = new User();
        user.setUsername(authRequestDto.getUsername());
        user.setPassword(authRequestDto.getPassword());
        return authRepository.existsUserByUsernameAndPassword(user.getUsername(), user.getPassword()) ;
    }
}
