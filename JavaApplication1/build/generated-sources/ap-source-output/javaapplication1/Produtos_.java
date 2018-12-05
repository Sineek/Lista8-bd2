package javaapplication1;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produtos.class)
public abstract class Produtos_ {

	public static volatile SingularAttribute<Produtos, Integer> quantEstoque;
	public static volatile SingularAttribute<Produtos, Double> preco;
	public static volatile SingularAttribute<Produtos, Integer> codigo;
	public static volatile CollectionAttribute<Produtos, ItensVenda> itensVendaCollection;
	public static volatile SingularAttribute<Produtos, String> nome;

}

