package app.service;

import app.model.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Value("${valid.username.regexp}")
    private String validUsernameRegex;

    @Value("${valid.password.regexp}")
    private String validPasswordRegex;

    /**
     * Validates input credentials
     * @param authRequest - request received from client
     * @return boolean - credentials' validity
     */
    public boolean validateCredentials(AuthenticationRequest authRequest) {

        return authRequest.getUsername().matches(validUsernameRegex)
                && authRequest.getPassword().matches(validPasswordRegex);
    }
}
