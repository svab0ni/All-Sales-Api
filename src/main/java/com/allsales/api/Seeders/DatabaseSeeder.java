package com.allsales.api.Seeders;

import com.allsales.api.Helpers.Slug;
import com.allsales.api.Models.*;
import com.allsales.api.Repositories.*;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseSeeder {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private CityRepository cityRepository;
    private ContractRepository contractRepository;
    private OfferRepository offerRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository, CityRepository cityRepository,
                          ContractRepository contractRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.cityRepository = cityRepository;
        this.contractRepository = contractRepository;
        this.offerRepository = offerRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRolesTable();
        seedUsersTable();
        seedCitiesTable();
        seedContractsTable();
        seedOffersTable();
    }

    private void seedRolesTable() {
        Role role1 = new Role();

        role1.setName(RoleName.ROLE_SUPER_ADMIN);
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName(RoleName.ROLE_ADMIN);
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName(RoleName.ROLE_USER);
        roleRepository.save(role3);
    }

    private void seedUsersTable() {
            List<Role> roles = new ArrayList<Role>();
            Role role = roleRepository.findByName(RoleName.ROLE_SUPER_ADMIN);
            roles.add(role);

            User user = new User();
            user.setFirstname("Spring Blog");
            user.setLastname("dsaad");
            user.setUsername("admin");
            user.setEmail("test@test.com");
            user.setPassword("test123");
            user.setRoles(roles);
            user.setEnabled(true);
            userRepository.save(user);
    }

    private void seedCitiesTable() {
        City city1 = new City();

        city1.setName("Sarajevo");
        city1.setAcronym("SA");
        city1.setAlias("sarajevo");
        city1.setZipcode("71000");

        cityRepository.save(city1);

        City city2 = new City();

        city2.setName("Mostar");
        city2.setAcronym("MO");
        city2.setAlias("Mostar");
        city2.setZipcode("71000");

        cityRepository.save(city2);
    }

    private void seedContractsTable() {
        Contract contract = new Contract();

        contract.setEmail("ermin@hotmail.com");
        contract.setName("Contract");

        contractRepository.save(contract);
    }

    private void seedOffersTable() {
        DataFactory dataFactory = new DataFactory();
        Random random = new Random();

        for(int i = 0; i < 100; i++)
        {
            Offer offer = new Offer();

            String title = dataFactory.getRandomText(150);
            offer.setTitle(title);
            offer.setAlias(Slug.makeSlug(title));
            offer.setName(dataFactory.getName());
            offer.setOfferCity(cityRepository.findByName("Sarajevo"));
            offer.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
            offer.setOfferUser(userRepository.findByUsername("admin"));
            offer.setProcessed(random.nextBoolean());
            offer.setPublished(random.nextBoolean());
            offer.setShortDescription(dataFactory.getRandomText(200));
            offer.setSubtitle(dataFactory.getRandomText(100));
            offer.setImageUrl("https://pbs.twimg.com/profile_images/469017630796296193/R-bEN4UP.png");

            offerRepository.save(offer);
        }
    }
}
