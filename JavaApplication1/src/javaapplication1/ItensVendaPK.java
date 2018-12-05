/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sineek
 */
@Embeddable
public class ItensVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_vendas")
    private int codVendas;
    @Basic(optional = false)
    @Column(name = "cod_produtos")
    private int codProdutos;

    public ItensVendaPK() {
    }

    public ItensVendaPK(int codVendas, int codProdutos) {
        this.codVendas = codVendas;
        this.codProdutos = codProdutos;
    }

    public int getCodVendas() {
        return codVendas;
    }

    public void setCodVendas(int codVendas) {
        this.codVendas = codVendas;
    }

    public int getCodProdutos() {
        return codProdutos;
    }

    public void setCodProdutos(int codProdutos) {
        this.codProdutos = codProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codVendas;
        hash += (int) codProdutos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensVendaPK)) {
            return false;
        }
        ItensVendaPK other = (ItensVendaPK) object;
        if (this.codVendas != other.codVendas) {
            return false;
        }
        if (this.codProdutos != other.codProdutos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.ItensVendaPK[ codVendas=" + codVendas + ", codProdutos=" + codProdutos + " ]";
    }
    
}
