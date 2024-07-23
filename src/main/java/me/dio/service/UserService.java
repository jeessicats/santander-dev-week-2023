package me.dio.service;

// Importa a classe necessária para definir o serviço de usuários
import me.dio.domain.model.User;

// Define a interface para o serviço de usuários
public interface UserService {

    // Declara um método para encontrar um usuário pelo ID
    User findById(Long id);

    // Declara um método para criar um novo usuário
    User create(User userToCreate);
}
