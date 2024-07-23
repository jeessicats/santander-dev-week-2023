package me.dio.controller;

// Importa as classes necessárias para manipulação de usuários e serviços
import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Define a classe como um controlador REST
@RestController
// Mapeia o caminho base para todos os métodos dentro desta classe
@RequestMapping("/users")
public class UserController {

    // Injeta o serviço de usuário para manipulação de operações de usuários
    private final UserService userService;

    // Construtor que recebe o UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Manipula solicitações GET para buscar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        // Recupera o usuário usando o UserService
        var user = userService.findById(id);
        // Retorna o usuário encontrado com um status HTTP 200 OK
        return ResponseEntity.ok(user);
    }

    // Manipula solicitações POST para criar um novo usuário
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        // Cria o usuário usando o UserService
        var userCreated = userService.create(userToCreate);
        // Constrói o URI do local onde o novo usuário foi criado
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        // Retorna uma resposta HTTP 201 Created com o URI do novo usuário e o usuário criado no corpo da resposta
        return ResponseEntity.created(location).body(userCreated);
    }
}
