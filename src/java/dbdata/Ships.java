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
@Table(name = "Ships")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ships.findAll", query = "SELECT s FROM Ships s")
    , @NamedQuery(name = "Ships.findByName", query = "SELECT s FROM Ships s WHERE s.name = :name")
    , @NamedQuery(name = "Ships.findByCapacity", query = "SELECT s FROM Ships s WHERE s.capacity = :capacity")
    , @NamedQuery(name = "Ships.findBySize", query = "SELECT s FROM Ships s WHERE s.size = :size")
    , @NamedQuery(name = "Ships.findBySpeed", query = "SELECT s FROM Ships s WHERE s.speed = :speed")
    , @NamedQuery(name = "Ships.findByFuel", query = "SELECT s FROM Ships s WHERE s.fuel = :fuel")
    , @NamedQuery(name = "Ships.findById", query = "SELECT s FROM Ships s WHERE s.id = :id")})
public class Ships implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Speed")
    private float speed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fuel")
    private int fuel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Ships() {
    }

    public Ships(Integer id) {
        this.id = id;
    }

    public Ships(Integer id, String name, int capacity, String size, float speed, int fuel) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.speed = speed;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
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
        if (!(object instanceof Ships)) {
            return false;
        }
        Ships other = (Ships) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbdata.Ships[ id=" + id + " ]";
    }
    
}
