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
import ru.rsatu.back.schedule.Entities.Stops;

/**
 *
 * @author pavel
 */
@Path("/stops")
@Authenticated
public class StopsResource {
    
    @Inject
    EntityManagerFactory emf;
    
    @Inject
    EntityManager entityManager; 
    
    @GET
    @RolesAllowed("dispatcher")
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStops() {
        TypedQuery<Stops> query = entityManager.createNamedQuery("Stops.findAll", Stops.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addStops(List<Stops> stops) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Stops stop:stops){
        em.createNativeQuery("INSERT INTO stops (name) VALUES (?)")
            .setParameter(1, stop.getName())
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
    public Response deleteStops(List<Stops> stops) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Stops stop:stops){
        em.createNativeQuery("DELETE FROM stops s WHERE s.stopid = :id")
            .setParameter("id", stop.getStopid())
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
    public Response edit(List<Stops> stops) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Stops stop:stops){
            Stops s = em.find(Stops.class, stop.getStopid());
            s.setName(stop.getName());
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}
