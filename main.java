/*
 * @authors: Patrick and David
 * @brief: main file
 */

/*
TODO:
!Ask David how to fix input problem. Input functions need to be able to read letters and ints, when I try returning just characters, doesn't work.
!For now skip #2 (until you talk with David about how to do items), and start working on NPC dialogue with node/tree class.
!Finish developing path class.
!Make functions that perform certain tasks like describing the environment + printing options, dialogue, etc.

*make a while loop that keeps running until user quits (maybe make into GUI menu at some point)
*Find a way to make a chat function` where you see the entire array of players.
*Make NPCs with branching dialogue options controlled by numbering system.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;

import Entities.character;
import Entities.entity;
import Entities.player;
import Entities.room;
import Events.events;
import Utilities.Main;
import Utilities.Graph;
import Utilities.settings;
import Utilities.node;
import Utilities.java_tree;
import Utilities.sound;

public class main {

    //general functions
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
        System.out.print("~");

        return Input.nextInt();
    }

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
        
        //just flip boolean to turn devmode off
        settings.devMode = true;
        if (settings.devMode){
            settings.typingSpeed = 10;
        }

        //sound crap
        ArrayList<sound> sounds = new ArrayList<>();

        File music = new File("Assets/Sci Fi Music.wav");
        sound musicSound = new sound("music", music);
        sounds.add(musicSound);

        //!Intro

        musicSound.play();

        typewriter("Welcome to David + Patrick\'s MUD!\n\n\n");
        typewriter("Press any key to begin!\n~");

        Scanner temp = new Scanner(System.in);
        
        String s = temp.nextLine();

        musicSound.stop();
        System.out.print("\n\n\n");
        typewriter("At any time, press \'q\' to quit the game.\n\n\n");

        //?ask David what the right way to incorporate item system is. Should it be a class, functions?
        String arr1[] = {"Item 1"};
        room root = new room("The docking bay", "People dock here", arr1);
        String arr2[] = {"Item 2"};
        room up = new room("The cafeteria", "People eat here", arr2);
        String arr3[] = {"Item 3"};
        room down = new room("The armory", "This place has guns.", arr3);
        String arr4[] = {"Item 1"};
        room up1 = new room("The command center", "This is where important people go.", arr4);
        String arr5[] = {"Item 1"};
        room down1 = new room("The escape pod room", "This is where people go to escape.", arr5);

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
        
        //!Do something similar here for NPCs

        //!game loop

        //&& input.toUpper() != "Q"
        while (currentNode != null) {
            System.out.print("You are currently in " + currentNode.name + ". "/* + typewriter(currentNode.description, 1)*/);
            System.out.println(currentNode.description);
            
            try{
                currentNode = roomGraph.neighbors(currentNode).get((Input(roomGraph.neighbors(currentNode))) - 1);
            }
            catch(IndexOutOfBoundsException i){
                System.out.println("Your option was not valid, check the options again!\n");
            }
            catch(InputMismatchException e){
                String check = e.toString();

                if (check.toUpperCase() == "Q") {
                    break;
                }else{
                    System.out.println("\nYour input is not one of the available options, please try again.\n");
                }
            }
            catch(Exception e){
                System.out.println("Something went wrong with your input :(");
            }
        }
    }
}