/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.schedule.Entities;

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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByRecordid", query = "SELECT s FROM Schedule s WHERE s.recordid = :recordid"),
    @NamedQuery(name = "Schedule.findByWorkorder", query = "SELECT s FROM Schedule s WHERE s.workorder = :workorder")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recordid")
    private Integer recordid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "workorder")
    private int workorder;
    @JoinColumn(name = "driver", referencedColumnName = "employeeid")
    @ManyToOne(optional = false)
    private Employees driver;
    @JoinColumn(name = "route", referencedColumnName = "routeid")
    @ManyToOne(optional = false)
    private Routes route;
    @JoinColumn(name = "transport", referencedColumnName = "transportid")
    @ManyToOne(optional = false)
    private Transport transport;

    public Schedule() {
    }

    public Schedule(Integer recordid) {
        this.recordid = recordid;
    }

    public Schedule(Integer recordid, int workorder) {
        this.recordid = recordid;
        this.workorder = workorder;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public int getWorkorder() {
        return workorder;
    }

    public void setWorkorder(int workorder) {
        this.workorder = workorder;
    }

    public Employees getDriver() {
        return driver;
    }

    public void setDriver(Employees driver) {
        this.driver = driver;
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordid != null ? recordid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.recordid == null && other.recordid != null) || (this.recordid != null && !this.recordid.equals(other.recordid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Schedule[ recordid=" + recordid + " ]";
    }
    
}
