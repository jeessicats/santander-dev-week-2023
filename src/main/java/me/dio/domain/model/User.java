package me.dio.domain.model;

// Importa as classes necessárias para mapeamento de entidades JPA e manipulação de listas
import jakarta.persistence.*;
import java.util.List;

// Define a classe como uma entidade JPA mapeada para a tabela "tb_user"
@Entity(name = "tb_user")
public class User {

    // Define o campo 'id' como a chave primária da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o campo 'name' para armazenar o nome do usuário
    private String name;

    // Define um relacionamento um-para-um com a entidade 'Account'
    // A operação de cascade ALL permite que todas as operações realizadas na entidade 'User'
    // sejam propagadas para a entidade 'Account'
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    // Define um relacionamento um-para-um com a entidade 'Card'
    // A operação de cascade ALL permite que todas as operações realizadas na entidade 'User'
    // sejam propagadas para a entidade 'Card'
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    // Define um relacionamento um-para-muitos com a entidade 'Feature'
    // A operação de cascade ALL permite que todas as operações realizadas na entidade 'User'
    // sejam propagadas para a entidade 'Feature'
    // O tipo de carregamento EAGER garante que a lista de features seja carregada imediatamente
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    // Define um relacionamento um-para-muitos com a entidade 'News'
    // A operação de cascade ALL permite que todas as operações realizadas na entidade 'User'
    // sejam propagadas para a entidade 'News'
    // O tipo de carregamento EAGER garante que a lista de notícias seja carregada imediatamente
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o campo 'name'
    public String getName() {
        return name;
    }

    // Setter para o campo 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter para o campo 'account'
    public Account getAccount() {
        return account;
    }

    // Setter para o campo 'account'
    public void setAccount(Account account) {
        this.account = account;
    }

    // Getter para o campo 'card'
    public Card getCard() {
        return card;
    }

    // Setter para o campo 'card'
    public void setCard(Card card) {
        this.card = card;
    }

    // Getter para o campo 'features'
    public List<Feature> getFeatures() {
        return features;
    }

    // Setter para o campo 'features'
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    // Getter para o campo 'news'
    public List<News> getNews() {
        return news;
    }

    // Setter para o campo 'news'
    public void setNews(List<News> news) {
        this.news = news;
    }

}
