package p2.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//import javax.persistence.*;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Setter
@Getter
@NodeEntity
//@Table(name="Location")
public class Location {

    @Id
    @GeneratedValue //@Column(name = "locationId")
    private Long locationId;

   // @Column(name = "latitude")
    private Double latitude;

   // @Column(name = "longitude")
    private Double longitude;

   /* @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "animalId")
    @JsonManagedReference */
   @Relationship(type = "LOCATED_AT", direction = Relationship.INCOMING)
   Animal animal;

  public Location() {
    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId &&
                Objects.equals(latitude, location.latitude) &&
                Objects.equals(longitude, location.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(locationId, latitude, longitude);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("id",locationId)
                .put("latitude",latitude)
                .put("longitude",longitude);
        return json.toString();
    }
}
