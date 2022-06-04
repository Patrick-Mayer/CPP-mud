/*
 * @author: Patrick
 * @brief: main file
 */

/*
TODO:
!Typewriter effect
*myUtilities needs to have a class for everything in the CPP version
*make a while loop that keeps running until user quits (maybe make into GUI menu at some point)
*Figure out how map/rooms system will work
*Find a way to make a chat function` where you see the entire array of players.
*Make NPCs with branching dialogue options controlled by numbering system.
*Sci-Fi western theme
*/

//import java.util.ArrayList;
//import java.util.Scanner;

import Entities.character;
import Entities.entity;
import Entities.player;
import Entities.room;
import Events.events;
import Entities.graph;

public class main {
    public static void main (String[] args) {
        System.out.println("Welcome to David + Patrick\'s MUD!\n\n\n");
        System.out.println("At any time, press \'q\' to quit the game.");

        Scanner s = new Scanner(System.in);

        String userInput = s.nextLine();

        System.out.print("\n\n\n");

        if (userInput.equals("q") || userInput.equals("Q")){
            System.exit(0);
        }
        
        System.out.println(userInput);

        s.close();

        ArrayList<room> map;
        ArrayList<player> players;

    }
}