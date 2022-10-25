package br.edu.utfpr.pb.tdd.server.controller;

import br.edu.utfpr.pb.tdd.server.model.User;
import br.edu.utfpr.pb.tdd.server.repository.UserRepository;
import br.edu.utfpr.pb.tdd.server.service.UserService;
import br.edu.utfpr.pb.tdd.server.shared.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public GenericResponse saveUser(@RequestBody @Valid User user) {
        userService.save(user);
        return new GenericResponse("Salvo com sucesso!");
    }

}
