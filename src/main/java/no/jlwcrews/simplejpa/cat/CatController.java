package no.jlwcrews.simplejpa.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getCats() {
        return ResponseEntity.ok(catService.getCats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable Long id) {
        return ResponseEntity.ok(catService.getCatById(id));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Cat>> getCatsBelowAge(@PathVariable int age) {
        return ResponseEntity.ok(catService.getCatsBelowAge(age));
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        return ResponseEntity.ok(catService.addCat(cat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCatById(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.ok("Your cat is deleted");
    }
}
