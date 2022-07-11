package tech.anjolaakindipe.springsecuritypractice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tech.anjolaakindipe.springsecuritypractice.domain.Role;
import tech.anjolaakindipe.springsecuritypractice.domain.User;
import tech.anjolaakindipe.springsecuritypractice.repository.RoleRespository;
import tech.anjolaakindipe.springsecuritypractice.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    final private UserRepository userRepository;
    final private RoleRespository roleRepository;
    final private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElseThrow(()->{
            log.error("User not found in the database");
            return new UsernameNotFoundException("User not found in the database");
        });
        log.info("User found in database: {}", username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach((role)-> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        log.info("Saving new User {} to Database", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        log.info("Saving new Role {} to Database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // TODO Auto-generated method stub
        log.info("Adding Role {} to  User to {} ", roleName, username);
        Optional<User> user  = userRepository.findByUsername(username);
        Optional<Role> role = roleRepository.findByName(roleName);
        user.ifPresent((existingUser)->{
            if(role.isPresent()){
                existingUser.getRoles().add(role.get());
                this.userRepository.save(existingUser);
            }
        });
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        log.info("Fetching User {} from Database", username);
        Optional<User> optionalUser =  userRepository.findByUsername(username);
        return optionalUser.get();
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        log.info("Fetching all Users");
        return userRepository.findAll();
    }


    
}
