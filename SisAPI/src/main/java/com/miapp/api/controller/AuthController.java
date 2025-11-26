package com.miapp.api.controller;
import com.miapp.api.model.Usuario;
import com.miapp.api.security.JwtService;
import com.miapp.api.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;
    private final JwtService jwtService;


    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario user) {
        Usuario created = authService.register(user);
// no devolver password
        created.setPassword(null);
        return ResponseEntity.ok(created);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        return authService.authenticate(username, password)
                .map(u -> {
                    String token = jwtService.generateToken(u.getNombreUsuario());
                    return ResponseEntity.ok(Map.of("token", token));
                }).orElse(ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas")));
    }
}
