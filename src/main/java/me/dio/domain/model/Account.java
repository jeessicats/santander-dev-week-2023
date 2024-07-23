package me.dio.domain.model;

// Importa as classes necessárias para persistência com JPA
import jakarta.persistence.*;
import java.math.BigDecimal;

// Define a classe como uma entidade JPA mapeada para a tabela "tb_account"
@Entity(name = "tb_account")
public class Account {

    // Define o campo 'id' como a chave primária da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o campo 'number' como uma coluna única na tabela
    @Column(unique = true)
    private String number;

    // Define o campo 'agency' como uma coluna padrão na tabela
    private String agency;

    // Define o campo 'balance' com precisão e escala para valores decimais
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    // Define o campo 'limit' com um nome personalizado, precisão e escala para valores decimais
    @Column(name = "additional_limit", precision = 13, scale = 2)
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

    // Getter para o campo 'agency'
    public String getAgency() {
        return agency;
    }

    // Setter para o campo 'agency'
    public void setAgency(String agency) {
        this.agency = agency;
    }

    // Getter para o campo 'balance'
    public BigDecimal getBalance() {
        return balance;
    }

    // Setter para o campo 'balance'
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
