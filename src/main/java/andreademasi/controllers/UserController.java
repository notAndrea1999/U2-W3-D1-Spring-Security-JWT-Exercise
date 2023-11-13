package andreademasi.controllers;

import andreademasi.entities.User;
import andreademasi.exceptions.BadRequestException;
import andreademasi.payloads.users.NewUserDTO;
import andreademasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return userService.getAllUsers(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User saveUser(@RequestBody @Validated NewUserDTO userDTO, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return userService.saveUser(userDTO);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

    @GetMapping("/{id}")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    User findUserByIdAndUpdate(@PathVariable long id, @RequestBody User user) {
        return userService.findUserByIdAndUpdate(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void findUserByIdAndDelete(@PathVariable long id) {
        userService.findUserByIdAndDelete(id);
    }

    @PatchMapping("upload/avatar/{id}")
    User uploadAvatar(@RequestParam("avatar") MultipartFile body, @PathVariable long id) throws IOException {
        System.out.println(body.getOriginalFilename());
        return userService.uploadAvatar(body, id);
    }
}
