/*
 * @author: Patrick
 * @brief: Defines character objects such as NPCs and Players
 */

package Entities;

public class character extends entity {
    //? index in array?
    public int position;
    public String inventory[];
    
    public character(){
        super();
        position = 0;
    }
    public character(String nName, String nDescription, int pos, String inv[]){
        super(nName, nDescription, inv);
        position = pos;
    }
};