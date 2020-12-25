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
@Table(name = "routes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Routes r"),
    @NamedQuery(name = "Routes.findByRouteid", query = "SELECT r FROM Routes r WHERE r.routeid = :routeid"),
    @NamedQuery(name = "Routes.findBySign", query = "SELECT r FROM Routes r WHERE r.sign = :sign"),
    @NamedQuery(name = "Routes.findByTransportneeded", query = "SELECT r FROM Routes r WHERE r.transportneeded = :transportneeded")})
public class Routes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routeid")
    private Integer routeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sign")
    private String sign;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transportneeded")
    private int transportneeded;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
//    private List<Schedule> scheduleList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeid")
//    private List<Routesstops> routesstopsList;

    public Routes() {
    }

    public Routes(Integer routeid) {
        this.routeid = routeid;
    }

    public Routes(Integer routeid, String sign, int transportneeded) {
        this.routeid = routeid;
        this.sign = sign;
        this.transportneeded = transportneeded;
    }

    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getTransportneeded() {
        return transportneeded;
    }

    public void setTransportneeded(int transportneeded) {
        this.transportneeded = transportneeded;
    }

//    @XmlTransient
//    public List<Schedule> getScheduleList() {
//        return scheduleList;
//    }
//
//    public void setScheduleList(List<Schedule> scheduleList) {
//        this.scheduleList = scheduleList;
//    }
//
//    @XmlTransient
//    public List<Routesstops> getRoutesstopsList() {
//        return routesstopsList;
//    }
//
//    public void setRoutesstopsList(List<Routesstops> routesstopsList) {
//        this.routesstopsList = routesstopsList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeid != null ? routeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routes)) {
            return false;
        }
        Routes other = (Routes) object;
        if ((this.routeid == null && other.routeid != null) || (this.routeid != null && !this.routeid.equals(other.routeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Routes[ routeid=" + routeid + " ]";
    }
    
}
