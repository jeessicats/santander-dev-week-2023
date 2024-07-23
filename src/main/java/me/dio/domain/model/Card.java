package me.dio.domain.model;

// Importa as classes necessárias para mapeamento de entidades JPA
import jakarta.persistence.*;
import java.math.BigDecimal;

// Define a classe como uma entidade JPA mapeada para a tabela "tb_card"
@Entity(name = "tb_card")
public class Card {

    // Define o campo 'id' como a chave primária da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o campo 'number' como uma coluna única na tabela
    @Column(unique = true)
    private String number;

    // Define o campo 'limit' com um nome personalizado, precisão e escala para valores decimais
    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o campo 'number'
    public String getNumber() {
        return number;
    }

    // Setter para o campo 'number'
    public void setNumber(String number) {
        this.number = number;
    }

    // Getter para o campo 'limit'
    public BigDecimal getLimit() {
        return limit;
    }

    // Setter para o campo 'limit'
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
