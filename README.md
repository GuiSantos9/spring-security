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
