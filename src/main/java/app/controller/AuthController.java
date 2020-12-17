package app.controller;


import app.model.AuthenticationRequest;
import app.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth/")
public class AuthController {

    @Autowired
    private AuthenticationService authService;

    /**
     * Controller method to authenticate user
     * @param authRequest Request Object from client
     * @return responseEntity with authenticated/unauthenticated response status
     */
    @ApiOperation(value = "Authenticate User", notes = "Authenticate User")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User authenticated successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping("/v1/authenticate")
    private ResponseEntity authenticate(@RequestBody AuthenticationRequest authRequest){

        if(authService.validateCredentials(authRequest))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
