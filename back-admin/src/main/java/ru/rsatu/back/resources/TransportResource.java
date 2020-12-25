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
import ru.rsatu.back.admin.Entities.Transport;

/**
 *
 * @author pavel
 */
@Path("/transport")
@Authenticated
public class TransportResource {
    
    @Inject
    EntityManagerFactory emf;
    
    @Inject
    EntityManager entityManager; 
    
    @GET
    @RolesAllowed({"admin","dispatcher"})
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransport() {
        TypedQuery<Transport> query = entityManager.createNamedQuery("Transport.findAll", Transport.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @POST
    @RolesAllowed("admin")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addTransport(List<Transport> transports) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Transport transport:transports){
        em.createNativeQuery("INSERT INTO transport (number, isavailable) VALUES (?,?)")
            .setParameter(1, transport.getNumber())
            .setParameter(2, transport.getIsavailable())
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
    public Response deleteTransport(List<Transport> transports) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        for(Transport transport:transports){
        em.createNativeQuery("DELETE FROM transport t WHERE t.transportid = :id")
            .setParameter("id", transport.getTransportid())
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
    public Response edit(List<Transport> transports) {
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
        
        for(Transport transport:transports){
            Transport t = em.find(Transport.class, transport.getTransportid());
            t.setNumber(transport.getNumber());
            t.setIsavailable(transport.getIsavailable());
        }        
        em.getTransaction().commit();

        return Response.ok("done").build();
    }
}