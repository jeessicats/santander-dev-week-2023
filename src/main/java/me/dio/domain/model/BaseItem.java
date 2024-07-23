package me.dio.domain.model;

// Importa as classes necessárias para mapeamento de entidades JPA
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// Define a classe como uma classe base para outras entidades
// Anotada com @MappedSuperclass para indicar que não é uma entidade em si, mas fornece mapeamento para subclasses
@MappedSuperclass
public abstract class BaseItem {

    // Define o campo 'id' como a chave primária da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o campo 'icon' para armazenar um ícone associado ao item
    private String icon;

    // Define o campo 'description' para armazenar uma descrição do item
    private String description;

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o campo 'icon'
    public String getIcon() {
        return icon;
    }

    // Setter para o campo 'icon'
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // Getter para o campo 'description'
    public String getDescription() {
        return description;
    }

    // Setter para o campo 'description'
    public void setDescription(String description) {
        this.description = description;
    }

}
