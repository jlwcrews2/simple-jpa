package no.jlwcrews.simplejpa.cat;

import no.jlwcrews.simplejpa.owner.Owner;
import no.jlwcrews.simplejpa.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepo catRepo;
    private final OwnerService ownerService;

    @Autowired
    public CatService(CatRepo catRepo, OwnerService ownerService){
        this.catRepo = catRepo;
        this.ownerService = ownerService;
    }

    public List<Cat> getCats(){
        return catRepo.findAll();
    }

    public List<Cat> getCatsBelowAge(int age) {
        return catRepo.findCatsByAgeBefore(age);
    }

    public Cat getCatById(long id) {
        return catRepo.findById(id).orElse(null);
    }

    public Cat addCat(Cat cat) {
        return catRepo.save(cat);
    }

    public void deleteCat(long id) {
        catRepo.deleteById(id);
    }

    public Cat updateCat(Cat cat) {
        return catRepo.save(cat);
    }
}
