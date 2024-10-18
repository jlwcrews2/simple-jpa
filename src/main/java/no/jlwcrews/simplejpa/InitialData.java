package no.jlwcrews.simplejpa;

import com.github.javafaker.Faker;
import no.jlwcrews.simplejpa.cat.Cat;
import no.jlwcrews.simplejpa.cat.CatService;
import no.jlwcrews.simplejpa.owner.Owner;
import no.jlwcrews.simplejpa.owner.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitialData implements CommandLineRunner {

    private final CatService catService;
    private final OwnerService ownerService;
    private final Faker faker = Faker.instance();

    public InitialData(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) {
        for (long i = 0; i < 25; i++) {
            Owner owner = ownerService.saveOwner(
               new Owner(faker.name().lastName(),
                       faker.name().firstName(),
                       faker.internet().emailAddress())
            );

            List<Cat> cats = new ArrayList<>();
            for (long j = 0; j < new Random().nextInt(1, 4); j++) {
                Cat cat = catService.addCat(new Cat(
                        faker.cat().name(),
                        faker.cat().breed(),
                        new Random().nextInt(1, 18),
                        owner
                ));
                cats.add(cat);
            }
            owner.setCats(cats);
            ownerService.saveOwner(owner);
        }
    }
}
