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
import ru.rsatu.back.schedule.Entities.Routes;

/**
 *
 * @author pavel
 */

@Path("/routes")
@Authenticated
public class RoutesResource {
    
    @Inject
    EntityManager entityManager; 
    
    @Inject
    EntityManagerFactory emf;
    
    @GET
    @RolesAllowed("dispatcher")
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoutes() {
        TypedQuery<Routes> query = entityManager.createNamedQuery("Routes.findAll", Routes.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("dispatcher")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRoutes(List<Routes> routes) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Routes route:routes){
        em.createNativeQuery("INSERT INTO routes (sign, transportneeded) VALUES (?,?)")
            .setParameter(1, route.getSign())
            .setParameter(2, route.getTransportneeded())
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
    public Response deleteRoutes(List<Routes> routes) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Routes route:routes){
        em.createNativeQuery("DELETE FROM routes r WHERE r.routeid = :id")
            .setParameter("id", route.getRouteid())
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
    public Response edit(List<Routes> routes) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Routes route:routes){
            Routes r = em.find(Routes.class, route.getRouteid());
            r.setSign(route.getSign());
            r.setTransportneeded(route.getTransportneeded());        
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}