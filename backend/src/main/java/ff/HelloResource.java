package ff;

import java.security.Principal;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@PermitAll
@Path("/hello")
public class HelloResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @Inject
    Principal principal;


    @Inject
    HelloMessage messenger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message hello() {

        return new Message(this.messenger.heyJoe(),42);
    }
}