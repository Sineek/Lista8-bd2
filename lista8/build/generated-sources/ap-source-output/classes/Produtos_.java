package classes;

import classes.ItensVenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T10:06:20")
@StaticMetamodel(Produtos.class)
public class Produtos_ { 

    public static volatile SingularAttribute<Produtos, Integer> quantEstoque;
    public static volatile SingularAttribute<Produtos, Double> preco;
    public static volatile SingularAttribute<Produtos, Integer> codigo;
    public static volatile CollectionAttribute<Produtos, ItensVenda> itensVendaCollection;
    public static volatile SingularAttribute<Produtos, String> nome;

}