package p2.backend.Beans;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Setter
@Getter
@NodeEntity
//Table(name = "Employee")
@JsonIdentityInfo(
        generator=ObjectIdGenerators.PropertyGenerator.class,
        property="employeeId")
public class Employee {
    @Id
    @GeneratedValue // @Column(name = "employeeId")
    private Long employeeId;

   // @Column(name = "firstName")
    private String firstName;

   // @Column(name = "lastName")
    private String lastName;

   // @Column(name = "username")
    private String username;

   // @Column(name = "password")
    private String password;

   // @Column(name = "role")
    private Integer role;

   /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_Animal", joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "animalId", referencedColumnName = "animalId")) */
   @Relationship(type = "FEEDS")
    private Set<Animal> animals = new HashSet<>();

  public Employee() {
    }

    public Employee(String firstName, String lastName, String username, String password, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Employee(String firstName, String lastName, String username, String password, int role, Set<Animal> animals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.animals = animals;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                role == employee.role &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(username, employee.username) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(animals, employee.animals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeId, firstName, lastName, username, password, role);
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("firstName",firstName)
                    .put("lastName",lastName)
                    .put("username",username)
                    .put("role",role);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();

    }
}
