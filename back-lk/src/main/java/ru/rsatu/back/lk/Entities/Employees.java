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
import javax.persistence.SequenceGenerator;
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
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeid", query = "SELECT e FROM Employees e WHERE e.employeeid = :employeeid"),
    @NamedQuery(name = "Employees.findByFio", query = "SELECT e FROM Employees e WHERE e.fio = :fio"),
    @NamedQuery(name = "Employees.findByIsavailable", query = "SELECT e FROM Employees e WHERE e.isavailable = :isavailable")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gen")
    @SequenceGenerator(name = "gen",  sequenceName = "\"employees_employeeId_seq\"")
    @Basic(optional = false)
    @Column(name = "employeeid")
    private Integer employeeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fio")
    private String fio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isavailable")
    private boolean isavailable;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    //private List<Schedule> scheduleList;

    public Employees() {
    }

    public Employees(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Employees(Integer employeeid, String fio, boolean isavailable) {
        this.employeeid = employeeid;
        this.fio = fio;
        this.isavailable = isavailable;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.rsatu.back.admin.Entities.Employees[ employeeid=" + employeeid + " ]";
    }
    
}
