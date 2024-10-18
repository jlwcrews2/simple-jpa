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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cat_gen")
    @SequenceGenerator(name = "cat_gen", sequenceName = "cat_seq", allocationSize = 1)
    @Column(name = "cat_id")
    private long id;
    @Column(name = "cat_name")
    private String name;
    @Column(name = "cat_breed")
    private String breed;
    @Column(name = "cat_age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "cat_owner_id")
    @JsonIgnoreProperties("cats")
    private Owner owner;


    public Cat(String name, String breed, int age, Owner owner){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }
}
