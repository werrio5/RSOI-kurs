/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.schedule.Resources;

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
import ru.rsatu.back.schedule.Entities.Schedule;

/**
 *
 * @author pavel
 */

@Path("/schedule")
@Authenticated
public class ScheduleResource {
    
    @Inject
    EntityManager entityManager; 
    
    @Inject
    EntityManagerFactory emf;
    
    @GET
    @RolesAllowed("dispatcher")
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSchedule() {
        TypedQuery<Schedule> query = entityManager.createNamedQuery("Schedule.findAll", Schedule.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRecord(List<Schedule> schedule) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Schedule record:schedule){
        em.createNativeQuery("INSERT INTO schedule (workorder, route, driver, transport) VALUES (?,?,?,?)")
            .setParameter(1, record.getWorkorder())
            .setParameter(2, record.getRoute())
            .setParameter(3, record.getDriver())
            .setParameter(4, record.getTransport())
            .executeUpdate();
        }
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRecord(List<Schedule> schedule) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Schedule record:schedule){
        em.createNativeQuery("DELETE FROM schedule s WHERE s.recordid = :id")
            .setParameter("id", record.getRecordid())
            .executeUpdate();
        }
        em.getTransaction().commit();
        
        return Response.ok("done").build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response edit(List<Schedule> schedules) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Schedule record:schedules){
            Schedule s = em.find(Schedule.class, record.getRecordid());
            s.setWorkorder(record.getWorkorder());
            s.setDriver(record.getDriver());
            s.setRoute(record.getRoute());
            s.setTransport(record.getTransport());
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}