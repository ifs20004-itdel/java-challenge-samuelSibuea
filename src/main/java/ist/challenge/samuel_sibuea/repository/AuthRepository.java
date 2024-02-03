package ist.challenge.samuel_sibuea.repository;

import ist.challenge.samuel_sibuea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(String username);
    boolean existsUserByUsernameAndPassword(String username, String password);
}
