package p2.backend.Beans.Relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Food;

@RelationshipEntity(type = "EATS")
public class Diet {
  @StartNode
  Animal animal;

  @EndNode
  Food food;
}
