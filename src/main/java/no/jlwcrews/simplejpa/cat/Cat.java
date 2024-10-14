package no.jlwcrews.simplejpa.cat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jlwcrews.simplejpa.owner.Owner;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties("cats")
    private Owner owner;


    public Cat(String name, String breed, int age, Owner owner){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }
}
