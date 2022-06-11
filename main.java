/*
 * @author: Patrick
 * @brief: main file
 */

/*
TODO:
!Figure out how to let user traverse graph.
!Finish developing path class.
!Make functions that perform certain tasks like describing the environment + printing options, dialogue, etc.

*make a while loop that keeps running until user quits (maybe make into GUI menu at some point)
*Find a way to make a chat function` where you see the entire array of players.
*Make NPCs with branching dialogue options controlled by numbering system.
*/

import java.util.ArrayList;
import java.util.Scanner;

import Entities.character;
import Entities.entity;
import Entities.player;
import Entities.room;
import Events.events;
import Utilities.Main;
import Utilities.Graph;
import Utilities.settings;

public class main {

     public static int Input(room... args) {
        Scanner Input = new Scanner(System.in);
        int i = 1;
        for (room arg: args) {
            System.out.println( i+ " ." + arg.name);
            i++;
        }
        return Input.nextInt();
      }
     
    public static int Input(ArrayList<room> r) {
        Scanner Input = new Scanner(System.in);
        int i = 1;
        for (room arg: r) {
            typewriter((i + ". " + arg.name + "\n"));
            i++;
        }
        //input
        System.out.print(">");
        return Input.nextInt();
      }

//game loop 
//continue playing
//

    //created by Andrew on Stack Overflow
    //https://stackoverflow.com/questions/35673302/java-typewriter-effect

    public static void typewriter(String s){
        for(int i = 0; i < s.length(); i++){
            System.out.printf("%c", s.charAt(i));
            try{
                Thread.sleep(settings.typingSpeed);//500 = 0.5s pause between characters
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static String typewriter(String s, int speed){
        for(int i = 0; i < s.length(); i++){
            System.out.printf("%c", s.charAt(i));
            try{
                Thread.sleep(speed);//500 = 0.5s pause between characters
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        return s;
    }

    public static void main (String[] args) {
        
        settings.devMode = true;
        if (settings.devMode){
            settings.typingSpeed = 10;
        }

        typewriter("Welcome to David + Patrick\'s MUD!\n\n\n");
        typewriter("At any time, press \'q\' to quit the game." + "\n\n\n");

        room root = new room("The docking bay", "People dock here");
        room up = new room("The cafeteria", "People eat here");
        room down = new room("The armory", "This place has guns.");
        room up1 = new room("The command center", "This is where important people go.");
        room down1 = new room("The escape pod room", "This is where people go to escape.");

        //from left to right, one root, two branching nodes which each have a child node
        
        Graph<room> roomGraph = new Graph<>();
        roomGraph.addVertex(root);
        
        //branchUp
        roomGraph.addVertex(up);
        roomGraph.addEdge(root, up, true);

        //branchDown
        roomGraph.addVertex(down);
        roomGraph.addEdge(root, down, true);

        //Up-1
        roomGraph.addVertex(up1);
        roomGraph.addEdge(up, up1, true);

        //Down-1
        roomGraph.addVertex(down1);
        roomGraph.addEdge(down, down1, true);

        room currentNode = root;
        
        //&& input.toUpper() != "Q"
        while (currentNode != null) {
            System.out.print("You are currently in " + currentNode.name + ". "/* + typewriter(currentNode.description, 1)*/);
            System.out.println(currentNode.description);
            currentNode = roomGraph.neighbors(currentNode).get((Input(roomGraph.neighbors(currentNode))) - 1);
        }
    }
}