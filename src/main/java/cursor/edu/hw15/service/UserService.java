package cursor.edu.hw15.service;

import cursor.edu.hw15.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
    void saveUser(User user);
    List<User> findAll();
}
