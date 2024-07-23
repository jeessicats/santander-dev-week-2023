package me.dio.controller.exception;

// Importa as classes necessárias para logging e manipulação de exceções HTTP
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

// Anotação para definir uma classe que trata globalmente exceções de controladores REST
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Cria uma instância de Logger para registrar informações sobre exceções
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Manipula exceções do tipo IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        // Retorna uma resposta HTTP 422 Unprocessable Entity com a mensagem da exceção
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // Manipula exceções do tipo NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        // Retorna uma resposta HTTP 404 Not Found com uma mensagem padrão
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }

    // Manipula qualquer outra exceção que não tenha um manipulador específico
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        // Define uma mensagem genérica para erros inesperados
        var message = "Unexpected server error, see the logs.";
        // Registra o erro inesperado nos logs
        logger.error(message, unexpectedException);
        // Retorna uma resposta HTTP 500 Internal Server Error com a mensagem genérica
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
