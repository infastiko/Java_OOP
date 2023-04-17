package Homework_1;

import lombok.ToString;
import java.util.HashMap;
@ToString
public class Research {
    HashMap<Node, Node> tree;
    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }
    public String findChildren(Person person) {
        StringBuilder result = new StringBuilder();
        for (Node t : tree.keySet()) {
            if (t.p1.getFirstName() == person.getFirstName()) {
                result.append( t.p2 ).append( " " );
            }
        }
        return String.format( "Children %s : %s", person, result );
    }
    public String  findParent(Person person) {
        StringBuilder result = new StringBuilder();
        for (Node t : tree.values()) {
            if (t.p1.getFirstName() == person.getFirstName()) {
                result.append( t.p2 ).append( " " );
            }
        }
        return String.format( "Parent %s : %s", person, result );
    }
}