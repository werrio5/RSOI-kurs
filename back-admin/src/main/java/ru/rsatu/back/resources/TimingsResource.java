/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.resources;

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
import ru.rsatu.back.admin.Entities.Stops;
import ru.rsatu.back.admin.Entities.Timings;

/**
 *
 * @author pavel
 */

@Path("/timings")
@Authenticated
public class TimingsResource {
    
    @Inject
    EntityManagerFactory emf;
    
    @Inject
    EntityManager entityManager; 
    
    @GET
    @RolesAllowed("dispatcher")
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimings() {
        TypedQuery<Timings> query = entityManager.createNamedQuery("Timings.findAll", Timings.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addTimings(List<Timings> timings) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Timings timing:timings){
        em.createNativeQuery("INSERT INTO timings (departure, destination, time) VALUES (?,?,?)")
            .setParameter(1, timing.getDeparture())
            .setParameter(2, timing.getDestination())
            .setParameter(3, timing.getTime())
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
    public Response deleteTimings(List<Timings> timings) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Timings timing:timings){
        em.createNativeQuery("DELETE FROM timings t WHERE t.timingid = :id")
            .setParameter("id", timing.getTimingid())
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
    public Response edit(List<Timings> timings) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Timings timing:timings){
            Timings t = em.find(Timings.class, timing.getTimingid());
            t.setDeparture(timing.getDeparture());
            t.setDestination(timing.getDestination());
            t.setTime(timing.getTime());
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}