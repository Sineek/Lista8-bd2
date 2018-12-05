/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sineek
 */
@Entity
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v")
    , @NamedQuery(name = "Vendas.findByCodigo", query = "SELECT v FROM Vendas v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Vendas.findByData", query = "SELECT v FROM Vendas v WHERE v.data = :data")
    , @NamedQuery(name = "Vendas.findByValorTotal", query = "SELECT v FROM Vendas v WHERE v.valorTotal = :valorTotal")
    , @NamedQuery(name = "Vendas.findByCpfVendedor", query = "SELECT v FROM Vendas v WHERE v.cpfVendedor = :cpfVendedor")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @Basic(optional = false)
    @Column(name = "cpf_vendedor")
    private String cpfVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendas")
    private Collection<ItensVenda> itensVendaCollection;

    public Vendas() {
    }

    public Vendas(Integer codigo) {
        this.codigo = codigo;
    }

    public Vendas(Integer codigo, Date data, double valorTotal, String cpfVendedor) {
        this.codigo = codigo;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cpfVendedor = cpfVendedor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    @XmlTransient
    public Collection<ItensVenda> getItensVendaCollection() {
        return itensVendaCollection;
    }

    public void setItensVendaCollection(Collection<ItensVenda> itensVendaCollection) {
        this.itensVendaCollection = itensVendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.Vendas[ codigo=" + codigo + " ]";
    }
    
}
