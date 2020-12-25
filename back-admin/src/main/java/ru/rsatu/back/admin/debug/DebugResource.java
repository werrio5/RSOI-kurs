/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.back.admin.debug;

import io.quarkus.security.Authenticated;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.rsatu.back.admin.Entities.Employees;
import ru.rsatu.back.admin.Entities.Routes;
import ru.rsatu.back.admin.Entities.Routesstops;
import ru.rsatu.back.admin.Entities.Schedule;
import ru.rsatu.back.admin.Entities.Stops;
import ru.rsatu.back.admin.Entities.Timings;
import ru.rsatu.back.admin.Entities.Transport;

/**
 *
 * @author pavel
 */
@Path("/debug")
public class DebugResource {
    
    @Inject
    EntityManager entityManager;   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employees")
    public Response employees() {
        TypedQuery<Employees> query = entityManager.createNamedQuery("Employees.findAll", Employees.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transport")
    public Response transport() {
        TypedQuery<Transport> query = entityManager.createNamedQuery("Transport.findAll", Transport.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/routes")
    public Response routes() {
        TypedQuery<Routes> query = entityManager.createNamedQuery("Routes.findAll", Routes.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/routesstops")
    public Response routesstops() {
        TypedQuery<Routesstops> query = entityManager.createNamedQuery("Routesstops.findAll", Routesstops.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/schedule")
    public Response schedule() {
        TypedQuery<Schedule> query = entityManager.createNamedQuery("Schedule.findAll", Schedule.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stops")
    public Response stops() {
        TypedQuery<Stops> query = entityManager.createNamedQuery("Stops.findAll", Stops.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/timings")
    public Response timings() {
        TypedQuery<Timings> query = entityManager.createNamedQuery("Timings.findAll", Timings.class);
        List result = query.getResultList();
        return Response.ok(result).build();
    }
    
}
