package br.com.eduardo.movieflixtask.controllers;

import br.com.eduardo.movieflixtask.dto.UserDTO;
import br.com.eduardo.movieflixtask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }


    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile() {
        UserDTO dto = null;
        try {
            dto = service.profile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
