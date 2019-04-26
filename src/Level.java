import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> nodes;

    public Level() {
        nodes = new HashMap<String, Room>();
    }

    public void addRoom(String name) {
        Room n = new Room(name);
        nodes.put(name, n);
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedRoom(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Room getRoom(String name) {
        if (nodes.containsKey(name)){
            return nodes.get(name);
        }
        return null;
    }

    public class Room {
        private String name;
        private HashMap<String, Room> neighbors;
        private ArrayList<Item> items;
        private String description;
        private ArrayList<Creature> creatures;

        Room(String name){
            neighbors = new HashMap<String, Room>();
            this.name = name;
            items = new ArrayList<>();
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public Item removeItem(String name) {
            Item removed;
            for (Item i : items) {
                if (i.getName().equals(name)) {
                    removed = i;
                    items.remove(i);
                    return removed;
                }
            }
            return null;
        }

        public void addNeighbor (Room n) {
            neighbors.put(n.getName(), n);
        }

        public Room getNeighbor(String name){
            if (neighbors.containsKey(name)){
                return neighbors.get(name);
            }
            return null;
        }
       public Room getRandomNeighbor() {
            int randNeighbor = (int)(Math.random()*neighbors.size());
            return neighbors.get(randNeighbor);
        }

        public String getName(){
            return name;
        }

        public String getNeighborNames(){
            String names = "";
            for(Room room : neighbors.values()) {
                names += room.getName() + " ";
            }
            return names;
        }

        public String toString() {
            return getName();
        }
    }
}
