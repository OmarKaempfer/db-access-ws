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
@Table(name = "Locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "Locations.findByName", query = "SELECT l FROM Locations l WHERE l.name = :name")
    , @NamedQuery(name = "Locations.findByX", query = "SELECT l FROM Locations l WHERE l.x = :x")
    , @NamedQuery(name = "Locations.findByY", query = "SELECT l FROM Locations l WHERE l.y = :y")
    , @NamedQuery(name = "Locations.findByZ", query = "SELECT l FROM Locations l WHERE l.z = :z")
    , @NamedQuery(name = "Locations.findByMaxSize", query = "SELECT l FROM Locations l WHERE l.maxSize = :maxSize")
    , @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "X")
    private float x;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Y")
    private float y;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Z")
    private float z;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MaxSize")
    private String maxSize;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Locations() {
    }

    public Locations(Integer id) {
        this.id = id;
    }

    public Locations(Integer id, String name, float x, float y, float z, String maxSize) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbdata.Locations[ id=" + id + " ]";
    }
    
}
