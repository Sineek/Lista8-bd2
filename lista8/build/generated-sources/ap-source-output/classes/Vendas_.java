package classes;

import classes.ItensVenda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T10:06:20")
@StaticMetamodel(Vendas.class)
public class Vendas_ { 

    public static volatile SingularAttribute<Vendas, Integer> codigo;
    public static volatile SingularAttribute<Vendas, Date> data;
    public static volatile CollectionAttribute<Vendas, ItensVenda> itensVendaCollection;
    public static volatile SingularAttribute<Vendas, String> cpfVendedor;
    public static volatile SingularAttribute<Vendas, Double> valorTotal;

}