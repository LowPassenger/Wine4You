package com.sommelier.wine4you.config;

import com.sommelier.wine4you.model.Role;
import com.sommelier.wine4you.model.User;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.repository.RoleRepository;
import com.sommelier.wine4you.repository.UserRepository;
import com.sommelier.wine4you.repository.WineRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private static final String PREFIX = "ROLE_";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final WineRepository wineRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           WineRepository wineRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.wineRepository = wineRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void injectData() {
        Role adminRole = getRole(PREFIX + "ADMIN");
        Role userRole = getRole(PREFIX + "USER");
        roleRepository.saveAll(List.of(adminRole, userRole));
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN").get();
        Role roleUser = roleRepository.findByName("ROLE_USER").get();

        User den = getUser(
                "Den",
                "Shl",
                "7860@gmail.com",
                "147147147",
                LocalDate.now(),
                "+30501321212",
                "Street",
                "Cv",
                Collections.singleton(roleAdmin));
        User dmt = getUser(
                "Dmt",
                "Lem",
                "123@gmail.com",
                "1523652145",
                LocalDate.now(),
                "+30501595959",
                "Street",
                "Od",
                Collections.singleton(roleUser));
        userRepository.saveAll(List.of(den, dmt));
    }

    private Wine getWine() {
        Wine wine = new Wine();
        return wine;
    }

    private User getUser(String firstName, String lastName, String email,
                         String password, LocalDate birthday,
                         String phone, String address, String city,
                         Set<Role> roles) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCity(city);
        user.setRoles(roles);
        user.setRegistrationDate(LocalDateTime.now());
        return user;
    }

    private Role getRole(String name) {
        Role role = new Role();
        role.setName(name);
        return role;
    }
}
