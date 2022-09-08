/*
 * @author: Patrick
 * @brief: Defines map/room system
 */

package Entities;

public class room extends entity {
    public int north, south, east, west;

    public room(){
        super();
        north = 0;
        south = 0;
        east = 0;
        west = 0;
    }
    
    public room(String nName, String nDescrption, int n, int s, int e, int w, String inv[]) {
        super(nName, nDescrption, inv);
        north = n;
        south = s;
        east = e;
        west = w;
    }

    public room(String nName, String nDescription, String inv[]){
        super(nName, nDescription, inv);
        north = 0;
        south = 0;
        east = 0;
        west = 0;
    }
};