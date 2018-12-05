package classes;

import classes.ItensVendaPK;
import classes.Produtos;
import classes.Vendas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T10:06:20")
@StaticMetamodel(ItensVenda.class)
public class ItensVenda_ { 

    public static volatile SingularAttribute<ItensVenda, Produtos> produtos;
    public static volatile SingularAttribute<ItensVenda, Vendas> vendas;
    public static volatile SingularAttribute<ItensVenda, ItensVendaPK> itensVendaPK;
    public static volatile SingularAttribute<ItensVenda, Integer> quantidade;

}