package tw.com.elf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.elf.dao.JwtResponse;
import tw.com.elf.dao.LoginRequest;
import tw.com.elf.dao.RegisterRequest;
import tw.com.elf.dao.Response;
import tw.com.elf.service.RegisterService;
import tw.com.elf.utils.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    	
    	System.err.println(loginRequest.getUsername());
    	System.err.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken((UserDetails) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    
    @PostMapping("/register")
    public ResponseEntity<Response<Object>> register(@RequestBody RegisterRequest registerRequest) {
    	
    	System.err.println(registerRequest.getEmail());
    	System.err.println(registerRequest.getPassword());
    	return ResponseEntity.ok(registerService.register(registerRequest));

    }
}
