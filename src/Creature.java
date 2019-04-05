public abstract class Creature extends Entity {
    public Creature(String name, String description, Level.Room room) {
        super(name, description, room);
    }

    public abstract void act();

    public void move(Level.Room newRoom) {
        setRoom(newRoom);
    }
}
