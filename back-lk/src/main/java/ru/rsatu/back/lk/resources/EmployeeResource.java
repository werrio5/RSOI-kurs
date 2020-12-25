/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.lk.resources;

import io.quarkus.security.Authenticated;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.rsatu.back.lk.Entities.Employees;


/**
 *
 * @author pavel
 */
@Path("/employees")
@Authenticated
public class EmployeeResource {
    
    @Inject
    EntityManager entityManager; 
    
    @Inject
    EntityManagerFactory emf;
    
    @GET
    @RolesAllowed({"admin","dispatcher"})
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        TypedQuery<Employees> query = entityManager.createNamedQuery("Employees.findAll", Employees.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("admin")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmployees(List<Employees> employees) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Employees employee:employees){
        em.createNativeQuery("INSERT INTO employees (fio, isavailable) VALUES (?,?)")
            .setParameter(1, employee.getFio())
            .setParameter(2, employee.getIsavailable())
            .executeUpdate();
        }
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
    
    @POST
    @RolesAllowed("admin")
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteEmployee(List<Employees> employees) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Employees employee:employees){
        em.createNativeQuery("DELETE FROM employees e WHERE e.employeeid = :id")
            .setParameter("id", employee.getEmployeeid())
            .executeUpdate();
        }
        em.getTransaction().commit();
        
        return Response.ok("done").build();
    }
    
    @POST
    @RolesAllowed("admin")
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response edit(List<Employees> employees) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Employees employee:employees){
            Employees e = em.find(Employees.class, employee.getEmployeeid());
            e.setFio(employee.getFio());
            e.setIsavailable(employee.getIsavailable());        
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
    
}
