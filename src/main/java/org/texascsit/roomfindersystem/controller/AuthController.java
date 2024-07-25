package org.texascsit.roomfindersystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.texascsit.roomfindersystem.dto.AuthRequestDto;
import org.texascsit.roomfindersystem.dto.AuthResponseDto;
import org.texascsit.roomfindersystem.jwt.JwtTokenFilter;
import org.texascsit.roomfindersystem.jwt.JwtTokenUtil;
import org.texascsit.roomfindersystem.model.Renter;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );

            Renter renter = (Renter) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(renter);
            AuthResponseDto response = new AuthResponseDto(accessToken, jwtUtil.EXPIRE_DURATION);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    } }
