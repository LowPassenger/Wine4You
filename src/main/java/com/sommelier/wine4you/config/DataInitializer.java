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
import com.sommelier.wine4you.repository.WineImageRepository;
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
    private final WineImageRepository wineImageRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           WineRepository wineRepository,
                           PasswordEncoder passwordEncoder,
                           EventRepository eventRepository,
                           WineStyleRepository styleRepository,
                           WineTasteRepository tasteRepository,
                           WineImageRepository wineImageRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.wineRepository = wineRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventRepository = eventRepository;
        this.styleRepository = styleRepository;
        this.tasteRepository = tasteRepository;
        this.wineImageRepository = wineImageRepository;
    }

    @PostConstruct
    public void injectData() {
        createAdminUser();
        createEvent();
        createWineStyle();
        createWineTaste();
        createImage();
        WineStyle wineStyleFind = styleRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("WineStyle","id","1")
        );
        WineTaste wineTasteFind = tasteRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("WineTaste","id","1")
        );
        Event eventFind = eventRepository.findById(1L).orElseThrow(
                () -> new ResourceNotFoundException("Event","id","1")
        );

        wineRepository.saveAll(
                List.of(
                        getWine("Ed Edmundo",
                                "Argentina",
                                "Ed Edmundo Cabernet Sauvignon, 2021",
                                BigDecimal.valueOf(710.23),
                                true,
                                "Cabernet Sauvignon",
                                WineType.RED,
                                styleRepository.findById(5L).get(),
                                tasteRepository.findById(6L).get(),
                                eventRepository.findById(2L).get(),
                                0.75,
                                wineImageRepository.findById(1L).get(),
                                "jJames Suckling-Mendoza, Argentina - "
                                        + "\"Savory sweet tobacco, blackcurrants and some thyme"
                                        + " and white pepper on the nose. The chunk of powdery"
                                        + " tannins really grabs your palate, wrapping the fruit"
                                        + " tightly before a long, savory finish.\""),
                        getWine("Pietramerana",
                                "Italy",
                                "Pietramerana Sangiovese Toscana IGT, 2019",
                                BigDecimal.valueOf(622.74),
                                true,
                                "Sangiovese Toscana IGT",
                                WineType.RED,
                                styleRepository.findById(6L).get(),
                                tasteRepository.findById(23L).get(),
                                eventRepository.findById(1L).get(),
                                0.75,
                                wineImageRepository.findById(2L).get(),
                                "James Suckling-Italy - Tuscany - Toscana -"
                                        + " \"This has aromas of raspberries, redcurrants, "
                                        + "lavender and dried herbs. Some cinnamon and anise,"
                                        + " too. Medium-bodied with fine, firm tannins. Fragrant"
                                        + " and spicy finish. \""),
                        getWine("URO",
                                "Spain",
                                "Uro Toro La Enfermera Tempranillo, 2020",
                                BigDecimal.valueOf(488.02),
                                true,
                                "Toro La Enfermera Tempranillo",
                                WineType.RED,
                                styleRepository.findById(7L).get(),
                                tasteRepository.findById(17L).get(),
                                eventRepository.findById(4L).get(),
                                0.75,
                                wineImageRepository.findById(3L).get(),
                                "James Suckling-Toro, Spain - \"Aromas of smoke,"
                                        + " berry and cracked pepper. Medium to full body, "
                                        + "round and juicy tannins and a delicious, fruity finish."
                                        + " It's a bigger wine, but the tannins show focus and"
                                        + " softness. 100% tinta de toro.\""),
                        getWine("Meleto",
                                "Italy",
                                "Castello Meleto Borgaio Rosso di Toscana, 2019",
                                BigDecimal.valueOf(1310.77),
                                false,
                                "Borgaio Rosso di Toscana",
                                WineType.RED,
                                styleRepository.findById(6L).get(),
                                tasteRepository.findById(23L).get(),
                                eventRepository.findById(1L).get(),
                                0.75,
                                wineImageRepository.findById(4L).get(),
                                "James Suckling-Toscana IGT, Tuscany, Italy -"
                                        + " \"A fruity red with plenty of dried-berry, walnut"
                                        + " and wet-earth character. Medium body, ripe tannins"
                                        + " and a flavorful finish.\" Perfect to accompany first"
                                        + " courses and grilled red meats and cheeses."),
                        getWine("Altaland",
                                "Argentina",
                                "Altaland Malbec Mendoza, 2020",
                                BigDecimal.valueOf(219.99),
                                true,
                                "Malbec Mendoza",
                                WineType.RED,
                                styleRepository.findById(7L).get(),
                                tasteRepository.findById(15L).get(),
                                eventRepository.findById(2L).get(),
                                0.75,
                                wineImageRepository.findById(5L).get(),
                                "James Suckling-Italy - Tuscany - Toscana -"
                                        + " \"This has aromas of raspberries, redcurrants, "
                                        + "lavender and dried herbs. Some cinnamon and anise,"
                                        + " too. Medium-bodied with fine, firm tannins. Fragrant"
                                        + " and spicy finish. \""),
                        getWine("Marchese dell'Elsa",
                                "Italy",
                                "Marchese dell'Elsa Moscato d'Asti",
                                BigDecimal.valueOf(854.73),
                                true,
                                "Moscato d'Asti",
                                WineType.CHAMPAGNE_SPARKLING,
                                styleRepository.findById(5L).get(),
                                tasteRepository.findById(28L).get(),
                                eventRepository.findById(1L).get(),
                                0.75,
                                wineImageRepository.findById(6L).get(),
                                "Asti, Piedmont, Italy - A fruit-driven people pleaser."
                                        + " Hints of peach blossoms and fresh citrus make it"
                                        + " a natural to pair with a fruit plate. Or sip on the"
                                        + " porch after dinner."),
                        getWine("Louis Bouillot",
                                "France",
                                "Louis Bouillot Perle de Vigne Brut",
                                BigDecimal.valueOf(772.83),
                                true,
                                "Perle de Vigne",
                                WineType.CHAMPAGNE_SPARKLING,
                                styleRepository.findById(7L).get(),
                                tasteRepository.findById(31L).get(),
                                eventRepository.findById(1L).get(),
                                0.375,
                                wineImageRepository.findById(7L).get(),
                                "Wine & Spirits-Burgundy, France - This is a blend"
                                        + " of Chardonnay, Pinot Noir, Aligote and Gamay, aged 12"
                                        + " months on lees in bottle. It's fragrant with notes of"
                                        + " toasty lees and chalk, a simple sparkler that feels"
                                        + " focused and clean. The bubbles are ready to take on any"
                                        + " raw shellfish."),
                        getWine("Cruse",
                                "France",
                                "Cruse Brut",
                                BigDecimal.valueOf(312.93),
                                true,
                                "Brut",
                                WineType.CHAMPAGNE_SPARKLING,
                                styleRepository.findById(3L).get(),
                                tasteRepository.findById(31L).get(),
                                eventRepository.findById(4L).get(),
                                0.75,
                                wineImageRepository.findById(8L).get(),
                                "An easy-drinking sparkling wine that has nice pear notes."
                                        + " All the acidity and smooth texture serves to"
                                        + " brighten it. Easy and light, the bubbles are nice"
                                        + " and peppy, giving this wine energy."),
                        getWine("Albino Armani",
                                "Italy",
                                "Armani Prosecco",
                                BigDecimal.valueOf(902.37),
                                true,
                                "Prosecco",
                                WineType.CHAMPAGNE_SPARKLING,
                                styleRepository.findById(7L).get(),
                                tasteRepository.findById(26L).get(),
                                eventRepository.findById(2L).get(),
                                0.75,
                                wineImageRepository.findById(9L).get(),
                                "Beverage Dynamics-Valdadige, Italy- \"A plush and refreshing"
                                        + " Prosecco with an expressive mix of apple blossom,"
                                        + " and lemon zest. Ripe and bold fruit combine with"
                                        + " savory acidity to give the wine balance, texture"
                                        + " and depth.\"."),
                        getWine("La Vostra",
                                "Italy",
                                "La Vostra Prosecco Rose",
                                BigDecimal.valueOf(920.23),
                                true,
                                "Prosecco Rose",
                                WineType.CHAMPAGNE_SPARKLING,
                                styleRepository.findById(11L).get(),
                                tasteRepository.findById(8L).get(),
                                eventRepository.findById(3L).get(),
                                0.75,
                                wineImageRepository.findById(10L).get(),
                                "Beverage Dynamics-Italy - \"Slight cherry"
                                        + " and strawberry notes on the nose and palate drive"
                                        + " this plush sparkler. Sweet, ripe peach flavor and a"
                                        + " zesty character give this wine structure and fun.\"")

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

    private void createImage() {
        wineImageRepository.saveAll(List.of(
                new WineImage("redwine/1/min.jpg", "redwine/1/max.jpg",
                        "redwine/1/maximax.jpg"),
                new WineImage("redwine/2/min.jpg", "redwine/2/max.jpg",
                        "redwine/2/maximax.jpg"),
                new WineImage("redwine/3/min.jpg", "redwine/3/max.jpg",
                        "redwine/3/maximax.jpg"),
                new WineImage("redwine/4/min.jpg", "redwine/4/max.jpg",
                        "redwine/4/maximax.jpg"),
                new WineImage("redwine/5/min.jpg", "redwine/5/max.jpg",
                "redwine/5/maximax.jpg"),
                new WineImage("champagne/1/min.jpg", "champagne/1/max.jpg",
                        "champagne/1/maximax.jpg"),
                new WineImage("champagne/2/min.jpg", "champagne/2/max.jpg",
                        "champagne/2/maximax.jpg"),
                new WineImage("champagne/3/min.jpg", "champagne/3/max.jpg",
                        "champagne/3/maximax.jpg"),
                new WineImage("champagne/4/min.jpg", "champagne/4/max.jpg",
                        "champagne/4/maximax.jpg"),
                new WineImage("champagne/5/min.jpg", "redwine/5/max.jpg",
                        "redwine/5/maximax.jpg")));
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
