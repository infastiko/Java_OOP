package Homework_1;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter
@Setter
public class GeoTree {
    private HashMap<Node, Node> tree = new HashMap<>();
    public void append(Person parent, Person children) {
        tree.put(new Node( parent, Relationships.PARENT, children ), new Node( children, Relationships.CHILDREN, parent ));
    }

    @Override
    public String toString() {
        return "GeoTree{" +
                "treeKey=" + tree.keySet() +
                '}';
    }
}
