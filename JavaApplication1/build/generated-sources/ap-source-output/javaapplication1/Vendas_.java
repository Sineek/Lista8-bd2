package javaapplication1;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendas.class)
public abstract class Vendas_ {

	public static volatile SingularAttribute<Vendas, Integer> codigo;
	public static volatile SingularAttribute<Vendas, Date> data;
	public static volatile CollectionAttribute<Vendas, ItensVenda> itensVendaCollection;
	public static volatile SingularAttribute<Vendas, String> cpfVendedor;
	public static volatile SingularAttribute<Vendas, Double> valorTotal;

}

