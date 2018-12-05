/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
    @Column(name = "codvendas")
    private int codvendas;
    @Basic(optional = false)
    @Column(name = "codprodutos")
    private int codprodutos;

    public ItensVendaPK() {
    }

    public ItensVendaPK(int codvendas, int codprodutos) {
        this.codvendas = codvendas;
        this.codprodutos = codprodutos;
    }

    public int getCodvendas() {
        return codvendas;
    }

    public void setCodvendas(int codvendas) {
        this.codvendas = codvendas;
    }

    public int getCodprodutos() {
        return codprodutos;
    }

    public void setCodprodutos(int codprodutos) {
        this.codprodutos = codprodutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codvendas;
        hash += (int) codprodutos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensVendaPK)) {
            return false;
        }
        ItensVendaPK other = (ItensVendaPK) object;
        if (this.codvendas != other.codvendas) {
            return false;
        }
        if (this.codprodutos != other.codprodutos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.ItensVendaPK[ codvendas=" + codvendas + ", codprodutos=" + codprodutos + " ]";
    }
    
}
