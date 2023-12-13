package co.funzies.controllers;

import co.funzies.dtos.UserDTO;
import co.funzies.exceptions.UserCrudExcp;
import co.funzies.models.User;
import co.funzies.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    
    @Inject
    UserService userService;
    
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long userId){
        try {
            User user = userService.readUserById(userId);
            return Response.status(Response.Status.OK).entity(new Object(){
                public String username = user.username;
                public String token = user.jwtToken.token;
            }).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new Object(){
                public String msg = e.getMessage();
            }).build();
        }
    }

    @POST
    @Path("/create")
    @Transactional
    public Response createUser(UserDTO userDTO){
        try {
            return Response.status(Response.Status.CREATED).entity(new Object(){
                public String username = userDTO.getUsername();
            }).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CREATED).entity(new Object(){
                public String msg = e.getMessage();
            }).build();
        }        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long userId, UserDTO userDTO){
        try {
            userService.updateUser(userDTO, userId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.CREATED).entity(new Object(){
                public String msg = e.getMessage();
            }).build();
        }        
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long userId){
        try {
            userService.deleteUser(userId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.CREATED).entity(new Object(){
                public String msg = e.getMessage();
            }).build();
        }        
    }
}
