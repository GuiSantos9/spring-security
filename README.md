# Para que serve o CRUD ? 

# Entidade
  A anotação @Entity avisa ao JPA que esta classe deve virar uma tabela no banco. O construtor vazio é exigido pelo Hibernate para criar o objeto quando ele vem vazio.
```Java
  @Entity 
  @Table(name = "nome_tabela")
  public class Campeao{
    public Campeao(){}
    // Atributos 
  }
```
# Identidade Única
- Identity: banco de dados decido o ID (auto-incremento)
- UUID: gera um código gigante e único aleatório
- Sequence: Usa uma tabela de apoio para dar o próximo id
- Auto: O Hibernate escolhe a melhor opção sozinho

