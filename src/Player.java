import java.util.ArrayList;

public class Player {
    String name, description;
    ArrayList<Item> items;
    Level.Room currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room newRoom) {
        currentRoom = newRoom;
    }
}
