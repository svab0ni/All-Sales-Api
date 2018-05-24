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

        Offer offer1 = new Offer();

        String title = "Vaše mjesto za raskošan odmor: Četverodnevno uživanje za dvije odrasle osobe i dvoje djece u Port 9 Apartmanima";
        offer1.setTitle(title);
        offer1.setAlias(Slug.makeSlug(title));
        offer1.setName("HTP Korčula d.d.");
        offer1.setOfferCity(cityRepository.findByName("Sarajevo"));
        offer1.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
        offer1.setOfferUser(userRepository.findByUsername("admin"));
        offer1.setProcessed(true);
        offer1.setPublished(true);
        offer1.setShortDescription("Pogledajte ponudu moderno obnovljenih Port 9 apartmana na otoku Korčuli i odaberite interijer po svom ukusu. U mirnoj uvali Zaljeva školjki uživajte u mirisima Mediterana okruženi maslinicima i zelenilom s pogledom na Jadransko more. Ljenčarite na plaži, okušajte se u nekom od sportova ili jednostavno prepustite ležernoj zabavi. Uživajte u čaši korčulanskog vina, isprobajte morske delicije uz kapljicu božanskog maslinovog ulja i stvorite trajne uspomene na otok koji inspirira.");
        offer1.setSubtitle("Odaberite tri noćenja za dvije osobe i dvoje djece s doručkom u modernim Apartmanima Port 9 uz mogućnost plaćanja na rate!");
        offer1.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_2_orig.jpg?v=1527076895");

        offerRepository.save(offer1);

        Offer offer2 = new Offer();

        String title2 = "Vaše mjesto za raskošan odmor: Četverodnevno uživanje za dvije odrasle osobe i dvoje djece u Port 9 Apartmanima";
        offer2.setTitle(title2);
        offer2.setAlias(Slug.makeSlug(title2));
        offer2.setName("HTP Korčula d.d.");
        offer2.setOfferCity(cityRepository.findByName("Sarajevo"));
        offer2.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
        offer2.setOfferUser(userRepository.findByUsername("admin"));
        offer2.setProcessed(true);
        offer2.setPublished(true);
        offer2.setShortDescription("Pogledajte ponudu moderno obnovljenih Port 9 apartmana na otoku Korčuli i odaberite interijer po svom ukusu. U mirnoj uvali Zaljeva školjki uživajte u mirisima Mediterana okruženi maslinicima i zelenilom s pogledom na Jadransko more. Ljenčarite na plaži, okušajte se u nekom od sportova ili jednostavno prepustite ležernoj zabavi. Uživajte u čaši korčulanskog vina, isprobajte morske delicije uz kapljicu božanskog maslinovog ulja i stvorite trajne uspomene na otok koji inspirira.");
        offer2.setSubtitle("Odaberite tri noćenja za dvije osobe i dvoje djece s doručkom u modernim Apartmanima Port 9 uz mogućnost plaćanja na rate!");
        offer2.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_1_orig.jpg?v=1527076888");

        offerRepository.save(offer2);

        Offer offer3 = new Offer();

        String title3 = "Vaše mjesto za raskošan odmor: Četverodnevno uživanje za dvije odrasle osobe i dvoje djece u Port 9 Apartmanima";
        offer3.setTitle(title3);
        offer3.setAlias(Slug.makeSlug(title3));
        offer3.setName("HTP Korčula d.d.");
        offer3.setOfferCity(cityRepository.findByName("Sarajevo"));
        offer3.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
        offer3.setOfferUser(userRepository.findByUsername("admin"));
        offer3.setProcessed(true);
        offer3.setPublished(true);
        offer3.setShortDescription("Pogledajte ponudu moderno obnovljenih Port 9 apartmana na otoku Korčuli i odaberite interijer po svom ukusu. U mirnoj uvali Zaljeva školjki uživajte u mirisima Mediterana okruženi maslinicima i zelenilom s pogledom na Jadransko more. Ljenčarite na plaži, okušajte se u nekom od sportova ili jednostavno prepustite ležernoj zabavi. Uživajte u čaši korčulanskog vina, isprobajte morske delicije uz kapljicu božanskog maslinovog ulja i stvorite trajne uspomene na otok koji inspirira.");
        offer3.setSubtitle("Odaberite tri noćenja za dvije osobe i dvoje djece s doručkom u modernim Apartmanima Port 9 uz mogućnost plaćanja na rate!");
        offer3.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_1_orig.jpg?v=1527076888");

        offerRepository.save(offer3);

        Offer offer4 = new Offer();

        String title4 = "Vaše mjesto za raskošan odmor: Četverodnevno uživanje za dvije odrasle osobe i dvoje djece u Port 9 Apartmanima";
        offer4.setTitle(title4);
        offer4.setAlias(Slug.makeSlug(title4));
        offer4.setName("HTP Korčula d.d.");
        offer4.setOfferCity(cityRepository.findByName("Sarajevo"));
        offer4.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
        offer4.setOfferUser(userRepository.findByUsername("admin"));
        offer4.setProcessed(true);
        offer4.setPublished(true);
        offer4.setShortDescription("Pogledajte ponudu moderno obnovljenih Port 9 apartmana na otoku Korčuli i odaberite interijer po svom ukusu. U mirnoj uvali Zaljeva školjki uživajte u mirisima Mediterana okruženi maslinicima i zelenilom s pogledom na Jadransko more. Ljenčarite na plaži, okušajte se u nekom od sportova ili jednostavno prepustite ležernoj zabavi. Uživajte u čaši korčulanskog vina, isprobajte morske delicije uz kapljicu božanskog maslinovog ulja i stvorite trajne uspomene na otok koji inspirira.");
        offer4.setSubtitle("Odaberite tri noćenja za dvije osobe i dvoje djece s doručkom u modernim Apartmanima Port 9 uz mogućnost plaćanja na rate!");
        offer4.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_3_orig.jpg?v=1527076938");
        offerRepository.save(offer4);

        Offer offer5 = new Offer();

        String title5 = "Vrijeme je da zaboravite na sve obaveze i uputite se na dvodnevnu relaksaciju u luksuznom SPA centru Etno sela ČARDACI!";
        offer5.setTitle(title5);
        offer5.setAlias(Slug.makeSlug(title5));
        offer5.setName("HTP Korčula d.d.");
        offer5.setOfferCity(cityRepository.findByName("Sarajevo"));
        offer5.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
        offer5.setOfferUser(userRepository.findByUsername("admin"));
        offer5.setProcessed(true);
        offer5.setPublished(true);
        offer5.setShortDescription("Pogledajte ponudu moderno obnovljenih Port 9 apartmana na otoku Korčuli i odaberite interijer po svom ukusu. U mirnoj uvali Zaljeva školjki uživajte u mirisima Mediterana okruženi maslinicima i zelenilom s pogledom na Jadransko more. Ljenčarite na plaži, okušajte se u nekom od sportova ili jednostavno prepustite ležernoj zabavi. Uživajte u čaši korčulanskog vina, isprobajte morske delicije uz kapljicu božanskog maslinovog ulja i stvorite trajne uspomene na otok koji inspirira.");
        offer5.setSubtitle("Odaberite tri noćenja za dvije osobe i dvoje djece s doručkom u modernim Apartmanima Port 9 uz mogućnost plaćanja na rate!");
        offer5.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_4_orig.jpg?v=1527076943");

        offerRepository.save(offer5);

        for(int i = 0; i < 90; i++)
        {
            Offer offer = new Offer();

            offer.setTitle(title5);
            offer.setAlias(Slug.makeSlug(title5));
            offer.setName(dataFactory.getName());
            offer.setOfferCity(cityRepository.findByName("Sarajevo"));
            offer.setOfferContract(contractRepository.findByEmail("ermin@hotmail.com"));
            offer.setOfferUser(userRepository.findByUsername("admin"));
            offer.setProcessed(random.nextBoolean());
            offer.setPublished(random.nextBoolean());
            offer.setShortDescription(dataFactory.getRandomText(200));
            offer.setSubtitle(dataFactory.getRandomText(100));
            offer.setImageUrl("https://www.ekupon.ba/media/images/offer-image-5965_6_orig.jpg?v=1527076947");

            offerRepository.save(offer);
        }
    }
}
