public class Chicken extends Creature{

    public Chicken(String name, String description, Level.Room room) {
        super(name, description, room);
    }

    @Override
    public void act() {
        getRoom().getRandomNeighbor();
    }
}
