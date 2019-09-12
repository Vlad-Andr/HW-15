package cursor.edu.hw15.service;

import cursor.edu.hw15.config.SpringSecurityConf;
import cursor.edu.hw15.model.User;
import cursor.edu.hw15.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;

    private final SpringSecurityConf config;


    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.getUsrById(id).isPresent()?userRepo.findById(id):Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username).isPresent()?userRepo.findByUsername(username):Optional.empty();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepo.deleteByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(config.encoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).get();
    }
}
