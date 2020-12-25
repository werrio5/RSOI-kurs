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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "timings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timings.findAll", query = "SELECT t FROM Timings t"),
    @NamedQuery(name = "Timings.findByTimingid", query = "SELECT t FROM Timings t WHERE t.timingid = :timingid"),
    @NamedQuery(name = "Timings.findByTime", query = "SELECT t FROM Timings t WHERE t.time = :time")})
public class Timings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timingid")
    private Integer timingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private int time;
    @JoinColumn(name = "destination", referencedColumnName = "stopid")
    @ManyToOne
    private Stops destination;
    @JoinColumn(name = "departure", referencedColumnName = "stopid")
    @ManyToOne(optional = false)
    private Stops departure;

    public Timings() {
    }

    public Timings(Integer timingid) {
        this.timingid = timingid;
    }

    public Timings(Integer timingid, int time) {
        this.timingid = timingid;
        this.time = time;
    }

    public Integer getTimingid() {
        return timingid;
    }

    public void setTimingid(Integer timingid) {
        this.timingid = timingid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Stops getDestination() {
        return destination;
    }

    public void setDestination(Stops destination) {
        this.destination = destination;
    }

    public Stops getDeparture() {
        return departure;
    }

    public void setDeparture(Stops departure) {
        this.departure = departure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timingid != null ? timingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timings)) {
            return false;
        }
        Timings other = (Timings) object;
        if ((this.timingid == null && other.timingid != null) || (this.timingid != null && !this.timingid.equals(other.timingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Timings[ timingid=" + timingid + " ]";
    }
    
}
