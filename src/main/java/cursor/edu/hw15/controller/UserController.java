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

    @PostMapping("admin/add-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/admin/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteByUsername(username);
    }

    @GetMapping("/admin/id/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/admin/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{username}")
    public Optional<User> findByUsername(@PathVariable("username") String username) {

        return userService.findByUsername(username);
    }
}
