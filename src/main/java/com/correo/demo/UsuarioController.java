package com.correo.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        try {
            usuarioService.login(credentials.getUsername(), credentials.getPassword());
            String token = generarTokenDeAcceso(credentials.getUsername());
            String message = "Inicio de sesión exitoso para: " + credentials.getUsername();
            return ResponseEntity.ok(token + "\n" + message);
        } catch (CorreoException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    
    // Método para generar un token de acceso (puedes implementarlo según tus necesidades)
    private String generarTokenDeAcceso(String username) {
        // Lógica para generar un token de acceso
        return "Token de acceso para: " + username;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.crearUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
        } catch (CorreoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear usuario: " + e.getMessage());
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.modificarUsuario(usuario);
            return ResponseEntity.ok("Usuario modificado exitosamente");
        } catch (CorreoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al modificar usuario: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.eliminarUsuario(usuario);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } catch (CorreoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
