package p2.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Setter
@Getter
@NodeEntity
//@Table(name = "Events")
public class Events {
    @Id
    @GeneratedValue // @Column(name = "eventId")
    private Long eventId;

   // @Column(name = "what")
    private String what;

   // @Column(name = "location")
    private String where;

   // @Column(name = "time")
    private String when;

    public Events(){

    }

    public Events(String what, String where, String when) {
        this.what = what;
        this.where = where;
        this.when = when;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return eventId == events.eventId &&
                Objects.equals(what, events.what) &&
                Objects.equals(where, events.where) &&
                Objects.equals(when, events.when);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventId, what, where, when);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("what",what).put("where",where).put("when",when);
        return json.toString();
    }
}
