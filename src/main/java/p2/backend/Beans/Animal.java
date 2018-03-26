package p2.backend.Beans;

import com.fasterxml.jackson.annotation.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "animal")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "animalId")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "animalId")
    private int animalId;

    @Column(name = "animalName")
    private String animalName;

    @Column(name = "scientificName")
    private String scientificName;

    @Column(name = "funFact",columnDefinition = "text")
    private String funFact;

    @Column(name = "summary",columnDefinition = "text")
    private String summary;

    @Column(name = "numOfAnimal")
    private int numOfAnimal;

    @Column(name = "tracking")
    private int tracking;

    @Column(name = "notes",columnDefinition = "text")
    private String notes;

    @ManyToMany(mappedBy = "animalFood")
    @JsonManagedReference
    private Set<Food> food;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    private Set<Employee> employees;

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

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, String notes, Set<Food> food, Set<Employee> employees) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.notes = notes;
        this.food = food;
        this.employees = employees;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumOfAnimal() {
        return numOfAnimal;
    }

    public void setNumOfAnimal(int numOfAnimal) {
        this.numOfAnimal = numOfAnimal;
    }

    public int getTracking() {
        return tracking;
    }

    public void setTracking(int tracking) {
        this.tracking = tracking;
    }
    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
                Objects.equals(food, animal.food) &&
                Objects.equals(employees, animal.employees);
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
//                    JSONArray foodArray = new JSONArray();
//                    this.food.forEach((Food foodN) -> {
//                        JSONObject food = new JSONObject();
//                        try {
//                            food.put("foodId",foodN.getFoodId());
//                            food.put("foodName",foodN.getFoodName());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        foodArray.put(foodN);
//                    });
//                    json.put("Food",foodArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
