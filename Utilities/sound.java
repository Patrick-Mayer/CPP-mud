/*
 * @authors: Patrick
 * @brief: Handles sound files
 */

package Utilities;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class sound {
    public String name; 
    public File filePath;
    
    //no default constructors
    
    public sound(String n, File f){
        //pass lowercase argument
        name = n + "Sound";
        filePath = f;
    }
    public sound(String n, String path){
        //pass lowercase argument
        name = n + "Sound";
        filePath = new File(path);
    }
    public void play(){
        AudioInputStream AS;
        try {
            Scanner scanner = new Scanner(System.in);
            
            AS = AudioSystem.getAudioInputStream(filePath);
            Clip c = AudioSystem.getClip();
            c.open(AS);
            c.start();
        } 
        catch (Exception e) {
            System.out.println("Something went wrong with the sound");
            e.printStackTrace();
        }
    }
    public void stop(){
        AudioInputStream AS;
        try {
            Scanner scanner = new Scanner(System.in);
            
            AS = AudioSystem.getAudioInputStream(filePath);
            Clip c = AudioSystem.getClip();
            c.open(AS);
            c.stop();
        } 
        catch (Exception e) {
            System.out.println("Something went wrong with the sound");
            e.printStackTrace();
        }
    }
};