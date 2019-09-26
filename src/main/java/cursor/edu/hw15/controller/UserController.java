package cursor.edu.hw15.controller;

import cursor.edu.hw15.model.User;
import cursor.edu.hw15.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("user/newUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("admin/delete/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteByUsername(username);
    }

    @GetMapping("user/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("user/getAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("user/getUserByName/{username}")
    public Optional<User> findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }
}
