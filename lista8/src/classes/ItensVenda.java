/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sineek
 */
@Entity
@Table(name = "itens_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensVenda.findAll", query = "SELECT i FROM ItensVenda i")
    , @NamedQuery(name = "ItensVenda.findByCodvendas", query = "SELECT i FROM ItensVenda i WHERE i.itensVendaPK.codvendas = :codvendas")
    , @NamedQuery(name = "ItensVenda.findByCodprodutos", query = "SELECT i FROM ItensVenda i WHERE i.itensVendaPK.codprodutos = :codprodutos")
    , @NamedQuery(name = "ItensVenda.findByQuantidade", query = "SELECT i FROM ItensVenda i WHERE i.quantidade = :quantidade")})
public class ItensVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensVendaPK itensVendaPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "codprodutos", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produtos produtos;
    @JoinColumn(name = "codvendas", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendas vendas;

    public ItensVenda() {
    }

    public ItensVenda(ItensVendaPK itensVendaPK) {
        this.itensVendaPK = itensVendaPK;
    }

    public ItensVenda(ItensVendaPK itensVendaPK, int quantidade) {
        this.itensVendaPK = itensVendaPK;
        this.quantidade = quantidade;
    }

    public ItensVenda(int codvendas, int codprodutos) {
        this.itensVendaPK = new ItensVendaPK(codvendas, codprodutos);
    }

    public ItensVendaPK getItensVendaPK() {
        return itensVendaPK;
    }

    public void setItensVendaPK(ItensVendaPK itensVendaPK) {
        this.itensVendaPK = itensVendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensVendaPK != null ? itensVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensVenda)) {
            return false;
        }
        ItensVenda other = (ItensVenda) object;
        if ((this.itensVendaPK == null && other.itensVendaPK != null) || (this.itensVendaPK != null && !this.itensVendaPK.equals(other.itensVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.ItensVenda[ itensVendaPK=" + itensVendaPK + " ]";
    }
    
}
