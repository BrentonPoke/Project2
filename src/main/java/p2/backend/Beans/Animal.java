package p2.backend.Beans;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import p2.backend.Beans.Relationships.Caretaker;
import p2.backend.Beans.Relationships.Diet;

@Getter
@Setter
@NodeEntity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "animalId")
public class Animal {
    @Id
    @GeneratedValue //@Column(name = "animalId")
    private Long animalId;

   // @Column(name = "animalName")
    private String animalName;

   // @Column(name = "scientificName")
    private String scientificName;

   // @Column(name = "funFact",columnDefinition = "text")
    private String funFact;

   // @Column(name = "summary",columnDefinition = "text")
    private String summary;

   // @Column(name = "numOfAnimal")
    private int numOfAnimal;

   // @Column(name = "tracking")
    private int tracking;

   // @Column(name = "notes",columnDefinition = "text")
    private String notes;

   // @ManyToMany(mappedBy = "animalFood")
    @Relationship(type = "EATS")
    private Set<Food> food = new HashSet<>();
    @Relationship(type = "FEEDS", direction = Relationship.INCOMING)
    private Set<Employee> employees = new HashSet<>();

    @Relationship(type = "LOCATED_AT")
    private Location site;


  public Animal(){

    }

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, String notes) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.notes = notes;
    }

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, String notes, Set<Food> food) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.notes = notes;
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                numOfAnimal == animal.numOfAnimal &&
                tracking == animal.tracking &&
                Objects.equals(animalName, animal.animalName) &&
                Objects.equals(scientificName, animal.scientificName) &&
                Objects.equals(funFact, animal.funFact) &&
                Objects.equals(summary, animal.summary) &&
                Objects.equals(notes, animal.notes) &&
                Objects.equals(food, animal.food);
    }

    @Override
    public int hashCode() {

        return Objects.hash(animalId, animalName, scientificName, funFact, summary, numOfAnimal, tracking, notes);
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("animalName",this.animalName)
                    .put("scientificName",scientificName)
                    .put("funFact",funFact)
                    .put("summary",summary)
                    .put("numOfAnimal",numOfAnimal)
                    .put("tracking",tracking)
                    .put("notes",notes);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
