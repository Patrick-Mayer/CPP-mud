/*
 * @author: Patrick
 * @brief: Player handler
 */

package Entities;

public class player extends character {
    static int playerCount;
    
    public String gamertag;
    
    public player() {
        super("", "", 0);
        gamertag = ('@' + name);
        playerCount++;
    }

    public player(String nName, String nDescription, int pos) {
        super(nName, nDescription, pos);
        gamertag = ('@' + name);
        playerCount++;
    }

    public void finalize(){
        playerCount--;
    }
};