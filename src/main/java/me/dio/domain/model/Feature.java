package me.dio.domain.model;

// Importa a classe necessária para mapeamento de entidades JPA
import jakarta.persistence.Entity;

// Define a classe como uma entidade JPA mapeada para a tabela "tb_feature"
// Estende a classe base 'BaseItem' para herdar seus atributos e mapeamentos
@Entity(name = "tb_feature")
public class Feature extends BaseItem {

}
