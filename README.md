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

# DTO: Data Transfer Object
Entidade(privado): Contém todos os dados, inclusíve sensíveis

# Reposítorio
 É uma interface que herda de JpaReposítory. Ela cuida de toda a comunicação com o banco de dados ser precisarmos escrever uma linha de SQL
 ```java
@Repository
public interface CampeaoRepository extends JpaRepository<Campeao, Long>{
  // metodos prontos
}
```
# Service
 É onde fica a regra de negocio. O service decide o que deve ser feito e valida as informações antes de salvar no banco.
 - O Service nunca deve deixar o erro quebrar o sistema. Criamos Exceções Personalizadas para dar retornos claros ao usuário.

# Controller
 É onde as requisições chegam. Ele expõe os endpoints para que o mundo externo possa interagir.

# Relacionamentos e Performance(JPA)
- Fetch Type: EAGER: Traz os dados relacionados imediatamente
- Fetch Type :LAZY : Só traz os dados se você pedir explicitamente

# Spring Security
- Autenticação(Login): Valida se o usuário é que diz ser através de Login e Senha
- Autorização(Roles): Verifica as permissões do usuário. ADMIN vs USER 
