/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.admin.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "routesstops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routesstops.findAll", query = "SELECT r FROM Routesstops r"),
    @NamedQuery(name = "Routesstops.findByRoutesstopsid", query = "SELECT r FROM Routesstops r WHERE r.routesstopsid = :routesstopsid"),
    @NamedQuery(name = "Routesstops.findByStoporder", query = "SELECT r FROM Routesstops r WHERE r.stoporder = :stoporder")})
public class Routesstops implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routesstopsid")
    private Integer routesstopsid;
    @Column(name = "stoporder")
    private Integer stoporder;
    @JoinColumn(name = "routeid", referencedColumnName = "routeid")
    @ManyToOne(optional = false)
    private Routes routeid;
    @JoinColumn(name = "stopid", referencedColumnName = "stopid")
    @ManyToOne(optional = false)
    private Stops stopid;

    public Routesstops() {
    }

    public Routesstops(Integer routesstopsid) {
        this.routesstopsid = routesstopsid;
    }

    public Integer getRoutesstopsid() {
        return routesstopsid;
    }

    public void setRoutesstopsid(Integer routesstopsid) {
        this.routesstopsid = routesstopsid;
    }

    public Integer getStoporder() {
        return stoporder;
    }

    public void setStoporder(Integer stoporder) {
        this.stoporder = stoporder;
    }

    public Routes getRouteid() {
        return routeid;
    }

    public void setRouteid(Routes routeid) {
        this.routeid = routeid;
    }

    public Stops getStopid() {
        return stopid;
    }

    public void setStopid(Stops stopid) {
        this.stopid = stopid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routesstopsid != null ? routesstopsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routesstops)) {
            return false;
        }
        Routesstops other = (Routesstops) object;
        if ((this.routesstopsid == null && other.routesstopsid != null) || (this.routesstopsid != null && !this.routesstopsid.equals(other.routesstopsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Routesstops[ routesstopsid=" + routesstopsid + " ]";
    }
    
}
