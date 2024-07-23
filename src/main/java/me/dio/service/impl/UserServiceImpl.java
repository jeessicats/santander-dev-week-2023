package me.dio.service.impl;

// Importa as classes necessárias para a implementação do serviço e manipulação de exceções
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

// Define a classe como uma implementação do serviço 'UserService'
// @Service é uma anotação que marca a classe como um componente de serviço Spring
@Service
public class UserServiceImpl implements UserService {

    // Injeta o repositório de usuários para operações de acesso a dados
    private final UserRepository userRepository;

    // Construtor que recebe o UserRepository
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Implementa o método para encontrar um usuário pelo ID
    @Override
    public User findById(Long id) {
        // Retorna o usuário encontrado ou lança uma exceção se não for encontrado
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    // Implementa o método para criar um novo usuário
    @Override
    public User create(User userToCreate) {
        // Verifica se já existe um usuário com o número da conta fornecido
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            // Lança uma exceção se o número da conta já existir
            throw new IllegalArgumentException("This Account number already exists.");
        }
        // Salva o novo usuário e o retorna
        return userRepository.save(userToCreate);
    }
}
