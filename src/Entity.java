public abstract class Entity {
    private String name, description;
    private Level.Room room;

    public Entity(String name, String description, Level.Room room) {
        this.name = name;
        this.description = description;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level.Room getRoom() {
        return room;
    }

    public void setRoom(Level.Room room) {
        this.room = room;
    }
}
