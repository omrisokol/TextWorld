public class Popstar extends Creature {

    public Popstar(String name, String description, Level.Room room) {
        super(name, description, room);
    }

    @Override
    public void act() {
        String name = this.getName();
        Level.Room next = getRoom().getRandomNeighbor();
        if(getRoom().equals(this.getRoom())) {
            System.out.println(next);
        }

        for(int i = 0; i < getRoom().getNeighborNames().length(); i++) {
            Level.Room neighboringEnemy = getRoom().getNeighbor(name);

            if(neighboringEnemy.equals(this.getRoom())) {
                System.out.println(neighboringEnemy);
            }
        }

        for(int i = 0; i < getRoom().getNeighborNames().length(); i++) {
            Level.Room neighboringEnemy = getRoom().getNeighbor(name);

            for(int j = 0; j < this.getRoom().getNeighborNames().length(); j++) {
                Level.Room neighbor = this.getRoom().getNeighbor(name);

                if(neighboringEnemy.equals(neighbor)) {
                    System.out.println(neighboringEnemy);
                }
            }
        }

    }
}
