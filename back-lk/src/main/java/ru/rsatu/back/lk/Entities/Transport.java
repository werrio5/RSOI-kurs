/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.lk.Entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "transport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findByTransportid", query = "SELECT t FROM Transport t WHERE t.transportid = :transportid"),
    @NamedQuery(name = "Transport.findByNumber", query = "SELECT t FROM Transport t WHERE t.number = :number"),
    @NamedQuery(name = "Transport.findByIsavailable", query = "SELECT t FROM Transport t WHERE t.isavailable = :isavailable")})
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transportid")
    private Integer transportid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isavailable")
    private boolean isavailable;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transport")
//    private List<Schedule> scheduleList;

    public Transport() {
    }

    public Transport(Integer transportid) {
        this.transportid = transportid;
    }

    public Transport(Integer transportid, String number, boolean isavailable) {
        this.transportid = transportid;
        this.number = number;
        this.isavailable = isavailable;
    }

    public Integer getTransportid() {
        return transportid;
    }

    public void setTransportid(Integer transportid) {
        this.transportid = transportid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

//    @XmlTransient
//    public List<Schedule> getScheduleList() {
//        return scheduleList;
//    }
//
//    public void setScheduleList(List<Schedule> scheduleList) {
//        this.scheduleList = scheduleList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transportid != null ? transportid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transport)) {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.transportid == null && other.transportid != null) || (this.transportid != null && !this.transportid.equals(other.transportid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Transport[ transportid=" + transportid + " ]";
    }
    
}
