/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.schedule.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "stops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stops.findAll", query = "SELECT s FROM Stops s"),
    @NamedQuery(name = "Stops.findByStopid", query = "SELECT s FROM Stops s WHERE s.stopid = :stopid"),
    @NamedQuery(name = "Stops.findByName", query = "SELECT s FROM Stops s WHERE s.name = :name")})
public class Stops implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stopid")
    private Integer stopid;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "destination")
    private List<Timings> timingsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departure")
    private List<Timings> timingsList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stopid")
    private List<Routesstops> routesstopsList;

    public Stops() {
    }

    public Stops(Integer stopid) {
        this.stopid = stopid;
    }

    public Integer getStopid() {
        return stopid;
    }

    public void setStopid(Integer stopid) {
        this.stopid = stopid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Timings> getTimingsList() {
        return timingsList;
    }

    public void setTimingsList(List<Timings> timingsList) {
        this.timingsList = timingsList;
    }

    @XmlTransient
    public List<Timings> getTimingsList1() {
        return timingsList1;
    }

    public void setTimingsList1(List<Timings> timingsList1) {
        this.timingsList1 = timingsList1;
    }

    @XmlTransient
    public List<Routesstops> getRoutesstopsList() {
        return routesstopsList;
    }

    public void setRoutesstopsList(List<Routesstops> routesstopsList) {
        this.routesstopsList = routesstopsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stopid != null ? stopid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stops)) {
            return false;
        }
        Stops other = (Stops) object;
        if ((this.stopid == null && other.stopid != null) || (this.stopid != null && !this.stopid.equals(other.stopid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Stops[ stopid=" + stopid + " ]";
    }
    
}
