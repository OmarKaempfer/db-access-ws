/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vaehnor
 */
@Entity
@Table(name = "Purchasing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchasing.findAll", query = "SELECT p FROM Purchasing p")
    , @NamedQuery(name = "Purchasing.findById", query = "SELECT p FROM Purchasing p WHERE p.id = :id")
    , @NamedQuery(name = "Purchasing.findByLocation", query = "SELECT p FROM Purchasing p WHERE p.location = :location")
    , @NamedQuery(name = "Purchasing.findByCommodity", query = "SELECT p FROM Purchasing p WHERE p.commodity = :commodity")
    , @NamedQuery(name = "Purchasing.findByPrice", query = "SELECT p FROM Purchasing p WHERE p.price = :price")})
public class Purchasing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Commodity")
    private String commodity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;

    public Purchasing() {
    }

    public Purchasing(Integer id) {
        this.id = id;
    }

    public Purchasing(Integer id, String location, String commodity, float price) {
        this.id = id;
        this.location = location;
        this.commodity = commodity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchasing)) {
            return false;
        }
        Purchasing other = (Purchasing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbdata.Purchasing[ id=" + id + " ]";
    }
    
}
