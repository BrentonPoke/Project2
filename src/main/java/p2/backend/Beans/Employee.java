package p2.backend.Beans;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employee")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="employeeId")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private int role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_Animal", joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "animalId", referencedColumnName = "animalId"))
    @JsonIgnore
    private Set<Animal> animals;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    protected Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
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
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("firstName",firstName)
                .put("lastName",lastName)
                .put("username",username)
                .put("role",role)
                .putPOJO("animals",animals);
        return json.toString();

    }
}
