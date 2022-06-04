/*
 * @author: Patrick
 * @brief: Defines character objects such as NPCs and Players
 */

package Entities;

public class character extends entity {
    //? index in array?
    public int position;
    
    public character(){
        super("", "");
        position = 0;
    }
    public character(String nName, String nDescription, int pos){
        super(nName, nDescription);
        position = pos;
    }
};