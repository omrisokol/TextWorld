public class Item extends Entity{


    public Item(String name, String description, Level.Room room) {
        super(name, description, room);
    }

    public Level.Room getCurrentRoom() {
        return getRoom();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" +  + '\'' +
                ", description='" + getName() + " " + getDescription() + '\'' +
                '}';
    }

    public void setCurrentRoom(Level.Room newRoom) {
         setRoom(newRoom);

        newRoom.addItem(this);
    }
}







