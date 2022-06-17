package br.com.eduardo.movieflixtask.services;

import br.com.eduardo.movieflixtask.services.exceptions.ResourceNotFoundException;
import br.com.eduardo.movieflixtask.dto.UserDTO;
import br.com.eduardo.movieflixtask.entities.User;
import br.com.eduardo.movieflixtask.repositories.UserRepository;
import br.com.eduardo.movieflixtask.services.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Transactional(readOnly = true)
    public UserDTO profile() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User byEmail = repository.findByEmail(username);
            return new UserDTO(byEmail);


        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }

    }

    public void findBYEmail(String username) {
        User email = repository.findByEmail(username);
        String s = email.getEmail().toString();
    }


    public UserDTO findById(Long id){
        Optional<User> userOptional = repository.findById(id);
        User entity = userOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
        return new UserDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;

    }
}
