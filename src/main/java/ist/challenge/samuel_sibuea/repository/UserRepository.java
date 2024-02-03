package ist.challenge.samuel_sibuea.repository;

import ist.challenge.samuel_sibuea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserById(Integer id);
    boolean existsUserByUsername(String username);
}
