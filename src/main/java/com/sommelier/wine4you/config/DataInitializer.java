package com.sommelier.wine4you.config;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.Role;
import com.sommelier.wine4you.model.User;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.WineImage;
import com.sommelier.wine4you.model.WineStyle;
import com.sommelier.wine4you.model.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import com.sommelier.wine4you.repository.EventRepository;
import com.sommelier.wine4you.repository.RoleRepository;
import com.sommelier.wine4you.repository.UserRepository;
import com.sommelier.wine4you.repository.WineRepository;
import com.sommelier.wine4you.repository.WineStyleRepository;
import com.sommelier.wine4you.repository.WineTasteRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DataInitializer {
    private static final String PREFIX = "ROLE_";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final WineRepository wineRepository;
    private final PasswordEncoder passwordEncoder;
    private final EventRepository eventRepository;
    private final WineStyleRepository styleRepository;
    private final WineTasteRepository tasteRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           WineRepository wineRepository,
                           PasswordEncoder passwordEncoder,
                           EventRepository eventRepository,
                           WineStyleRepository styleRepository,
                           WineTasteRepository tasteRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.wineRepository = wineRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventRepository = eventRepository;
        this.styleRepository = styleRepository;
        this.tasteRepository = tasteRepository;
    }

    @PostConstruct
    public void injectData() {
        createAdminUser();
        createEvent();
        createWineStyle();
        createWineTaste();
        WineStyle wineStyleFind = styleRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("asd","asd","1")
        );
        WineTaste wineTasteFind = tasteRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("asd","asd","1")
        );
        Event eventFind = eventRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("asd","asd","1")
        );

        wineRepository.saveAll(
                List.of(
                        getWine("ASdadas",
                                "Italy",
                                "sahgdfjsaghdfkjag",
                                BigDecimal.valueOf(123.23),
                                true,
                                "AGF",
                                WineType.RED,
                                wineStyleFind,
                                wineTasteFind,
                                eventFind,
                                0.75,
                                null,
                                "jhgsakdfjgsadf gsdkfh gjksdfhgsdhf"),
                        getWine("AGFDGAFD",
                                "Italy",
                                "sahgdfjsaghdfkjag",
                                BigDecimal.valueOf(1353.23),
                                true,
                                "AGF",
                                WineType.RED,
                                wineStyleFind,
                                wineTasteFind,
                                eventFind,
                                1.5,
                                null,
                                "jhgsakdfjgsadf gsdkfh gjksdfhgsdhf")

                )
        );
    }

    private void createAdminUser() {
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
        log.info("Successfully, create admin");
    }

    private Wine getWine(String brand,
                         String country,
                         String title,
                         BigDecimal price,
                         Boolean inStock,
                         String name,
                         WineType wineType,
                         WineStyle wineStyle,
                         WineTaste wineTaste,
                         Event event,
                         double capacity,
                         WineImage image,
                         String description) {
        Wine wine = new Wine();
        wine.setBrand(brand);
        wine.setCountry(country);
        wine.setTitle(title);
        wine.setPrice(price);
        wine.setInStock(inStock);
        wine.setName(name);
        wine.setWineType(wineType);
        wine.setWineStyle(wineStyle);
        wine.setWineTaste(wineTaste);
        wine.setEvent(event);
        wine.setCapacity(capacity);
        wine.setImage(image);
        wine.setDescription(description);
        return wine;
    }

    private void createEvent() {
        eventRepository.saveAll(List.of(
                new Event("New year"),
                new Event("Party"),
                new Event("Birthday"),
                new Event("Corporate event")));
    }

    private void createWineStyle() {
        styleRepository.saveAll(List.of(
                new WineStyle("Oak"),
                new WineStyle("Brut"),
                new WineStyle("Dry"),
                new WineStyle("Semi sweet"),
                new WineStyle("Sweet"),
                new WineStyle("Concentrated"),
                new WineStyle("Elegant"),
                new WineStyle("Intense"),
                new WineStyle("Crisp"),
                new WineStyle("Off-dry"),
                new WineStyle("Fresh"),
                new WineStyle("Fruity")
        ));
    }

    private void createWineTaste() {
        tasteRepository.saveAll(List.of(
                new WineTaste("Tropical"),
                new WineTaste("Blackberry"),
                new WineTaste("Chocolate"),
                new WineTaste("Vanilla"),
                new WineTaste("Dried Cherry"),
                new WineTaste("Black Currant"),
                new WineTaste("Cherry"),
                new WineTaste("Strawberry"),
                new WineTaste("Black Fruit"),
                new WineTaste("Spice"),
                new WineTaste("Red Berry"),
                new WineTaste("Cranberry"),
                new WineTaste("Currant"),
                new WineTaste("Dark Berry"),
                new WineTaste("Red Fruit"),
                new WineTaste("Violet"),
                new WineTaste("Plum"),
                new WineTaste("Licorice"),
                new WineTaste("Black Cherry"),
                new WineTaste("Sage"),
                new WineTaste("Herb"),
                new WineTaste("Butter"),
                new WineTaste("Pear"),
                new WineTaste("Passionfruit"),
                new WineTaste("Gooseberry"),
                new WineTaste("Citrus"),
                new WineTaste("Apricot"),
                new WineTaste("Stone Fruit"),
                new WineTaste("Peach"),
                new WineTaste("Melon"),
                new WineTaste("Almond"),
                new WineTaste("Apple"),
                new WineTaste("Mango"),
                new WineTaste("Lime"),
                new WineTaste("Floral"),
                new WineTaste("Mineral"),
                new WineTaste("White Peach"),
                new WineTaste("Fig"),
                new WineTaste("White Fruit"),
                new WineTaste("Toast"),
                new WineTaste("Green Apple"),
                new WineTaste("Red Cherry"),
                new WineTaste("Berry"),
                new WineTaste("Fruity"),
                new WineTaste("Raspberry"),
                new WineTaste("Cassis"),
                new WineTaste("Earth"),
                new WineTaste("Coconut"),
                new WineTaste("Cinnamon"),
                new WineTaste("Pepper"),
                new WineTaste("Mulberry"),
                new WineTaste("Tobacco")
        ));
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
