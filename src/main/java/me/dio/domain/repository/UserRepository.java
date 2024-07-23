package me.dio.domain.repository;

// Importa as classes necessárias para manipulação de dados e definição de repositório JPA
import me.dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Define a interface como um repositório Spring Data JPA para a entidade 'User'
// @Repository é uma anotação que marca a interface como um componente de repositório Spring
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Declara um método para verificar se existe um usuário com um número de conta específico
    // O Spring Data JPA gera a implementação desse método automaticamente com base no nome
    boolean existsByAccountNumber(String accountNumber);
}
