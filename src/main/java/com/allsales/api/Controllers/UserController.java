package com.allsales.api.Controllers;

import com.allsales.api.Models.Role;
import com.allsales.api.Models.RoleName;
import com.allsales.api.Models.User;
import com.allsales.api.Repositories.UserRepository;
import com.allsales.api.Repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import com.allsales.api.security.JwtTokenUtil;
import com.allsales.api.security.JwtUser;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<JwtUser> getAuthenticatedUser(HttpServletRequest request) {

        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user){
        List<Role> roles = new ArrayList<>();

        Role role = roleRepository.findByName(RoleName.ROLE_USER);
        roles.add(role);

        user.setEnabled(true);
        user.setRoles(roles);

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "createAdmin", method = RequestMethod.POST)
    public ResponseEntity<User> createAdmin(@RequestBody User user){
        List<Role> roles = new ArrayList<>();

        Role role = roleRepository.findByName(RoleName.ROLE_ADMIN);
        roles.add(role);

        user.setEnabled(true);
        user.setRoles(roles);

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public HttpStatus destroy(@PathVariable("id") Long id){

        userRepository.deleteById(id);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<List<User>> index(){

        List<User> users = userRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> find(@PathVariable Long id){

        User user = userRepository.findUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
        User newUser = userRepository.findUserById(id);

        newUser.setFirstname(user.getFirstname());
        newUser.setEmail(user.getEmail());
        newUser.setLastname(user.getLastname());

        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @RequestMapping(value = "search/{q}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> search(@PathVariable String q){

        List<User> users = userRepository.findByUsernameIgnoreCaseContaining(q);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
