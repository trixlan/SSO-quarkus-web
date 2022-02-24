package org.acme.security.openid.connect.web.authentication;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.jwt.JsonWebToken;
import io.quarkus.oidc.IdToken;
import io.quarkus.security.Authenticated;

@Path("/web-app")
@Authenticated
public class ProtectedResource {

    @Inject
    @IdToken
    JsonWebToken idToken;

    @GET
    @Path("/name")
    public String getUserName() {
        return idToken.getName();
    }

    @GET
    @Path("/token")
    public String getReservationOnBehalfOfUser() {
        // String rawAccessToken = idToken.getRawToken();
        //or
        //String rawAccessToken = accessTokenCredential.getToken();

        // Use the raw access token to access a remote endpoint
        return idToken.getRawToken();
    }
}
