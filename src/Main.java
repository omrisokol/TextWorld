import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Creature> creatures = null;

        Level g = new Level();
        Creature chicken = new Chicken("chicken", "crazy", g.getRoom("dungeon"));
        Creature popstar = new Popstar("popstar", "fast", g.getRoom("closet"));
        Creature wumpus = new Wumpus("wumpus", "slow", g.getRoom("hall"));

        creatures.add(chicken);
        creatures.add(popstar);
        creatures.add(wumpus);

        for (int i = 0; i < creatures.size(); i++) {
            creatures.get(i).act();
        }



        g.addRoom("hall");
        g.addRoom("closet");
        g.addRoom("dungeon");

        g.addUndirectedRoom("hall", "dungeon");
        g.addUndirectedRoom("hall", "closet");

        Player p = new Player("doubie", "doub");
        p.setCurrentRoom(g.getRoom("hall"));
        Level.Room current = p.getCurrentRoom();

        Item item = new Item("food", "chocolate", g.getRoom("dungeon"));
        Item item1 = new Item("napkin", "clean", g.getRoom("closet"));

        item.setCurrentRoom(g.getRoom("dungeon"));
        item1.setCurrentRoom(g.getRoom("closet"));

        String response;
        Scanner in = new Scanner(System.in);



        String responseChoices = "go, look, add room, add cell, quit, and take are your commands";
        System.out.println(responseChoices);
        do {
            System.out.println("You are currently in the " + current.getName());
            System.out.println("What do you want to do? ");
            response = in.nextLine();
            Level.Room room = current.getNeighbor(response);

            if(response.contains("go")){
                String nextRoom = response.substring(3);
                if (current.getNeighbor(nextRoom) != null) {
                    current = current.getNeighbor(nextRoom);
                    p.setCurrentRoom(current.getNeighbor(nextRoom));
                } else {
                    System.out.println("You can't go there. Try again");
                }
            } else if (response.equals("look")){
                System.out.println(current.getNeighborNames());
                System.out.println("You have items " + p.getItems() + ", the room you are in has items " + current.getItems());
            } else if (response.contains("add room")) {
                String newRoom = response.substring(9);
                g.addRoom(newRoom);
                g.addUndirectedRoom(current.getName(), newRoom);
            } else if (response.equals("quit")) {
                System.out.println("you have quit the game.");
            } else if (response.contains("take")) {
                String itemName = response.substring(5);
                Item removed = current.removeItem(itemName);
                System.out.println("You removed item " + removed + " from room " + current);
                p.addItem(removed);
                System.out.println("You took item " + removed + " and added it to your own personal list");
            } else if (response.contains(("drop"))) {
                Item dropped = p.removeItem(response.substring(5));
                System.out.println("You dropped item " + dropped);
                current.addItem(dropped);
                System.out.println("Now, room " + current + " has " + dropped);
            } else if (response.contains("add cell")){
                String newRoom = response.substring(9);
                g.addRoom(newRoom);
                g.addDirectedEdge(current.getName(), newRoom);
            } else {
                System.out.println(responseChoices);
            }
        } while (!response.equals("quit"));
    }
}


