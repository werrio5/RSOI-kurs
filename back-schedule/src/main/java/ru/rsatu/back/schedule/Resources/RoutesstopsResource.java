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
import ru.rsatu.back.schedule.Entities.Routesstops;

/**
 *
 * @author pavel
 */
@Path("/routesstops")
@Authenticated
public class RoutesstopsResource {
    
    @Inject
    EntityManager entityManager; 
    
    @Inject
    EntityManagerFactory emf;
    
    @GET
    @RolesAllowed("dispatcher")
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoutesstops() {
        TypedQuery<Routesstops> query = entityManager.createNamedQuery("Routesstops.findAll", Routesstops.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRoutesstops(List<Routesstops> routesstops) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Routesstops routestop:routesstops){
        em.createNativeQuery("INSERT INTO routesstops (routeid, stopid, stoporder) VALUES (?,?,?)")
            .setParameter(1, routestop.getRouteid())
            .setParameter(2, routestop.getStopid())
            .setParameter(3, routestop.getStoporder())
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
    public Response deleteRoutesstops(List<Routesstops> routesstops) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Routesstops routestop:routesstops){
        em.createNativeQuery("DELETE FROM routesstops r WHERE r.routesstopid = :id")
            .setParameter("id", routestop.getRoutesstopsid())
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
    public Response edit(List<Routesstops> routesstops) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Routesstops routestop:routesstops){
            Routesstops r = em.find(Routesstops.class, routestop.getRouteid());
            r.setRouteid(routestop.getRouteid());
            r.setStopid(routestop.getStopid());      
            r.setStoporder(routestop.getStoporder());  
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}