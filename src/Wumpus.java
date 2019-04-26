public class Wumpus extends Creature {

    public Wumpus(String name, String description, Level.Room room) {
        super(name, description, room);
    }

    @Override
    public void act() {
        Level.Room next = getRoom().getRandomNeighbor();
        String name = this.getName();

        for(int i = 0; i < getRoom().getNeighborNames().length(); i++) {
            Level.Room neighboringEnemy = getRoom().getNeighbor(name);
            for(int j = 0; j < this.getRoom().getNeighborNames().length(); j++) {
                Level.Room neighbor = this.getRoom().getNeighbor(name);

                if(!neighboringEnemy.equals(neighbor)) {
                    System.out.println(neighboringEnemy);
                }
            }
        }

        int count = 0;
        do {
            next = getRoom().getRandomNeighbor();
            count++;
            if(count == 5) {
                System.out.println(next);
            }
        } while (next==this.getRoom());
    }
}

