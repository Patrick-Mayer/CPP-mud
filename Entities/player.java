/*
 * @author: Patrick
 * @brief: Player handler
 */

package Entities;

public class player extends character {
    static int playerCount;
    public String inventory[];
    
    public String gamertag;
    
    public player() {
        super();
        gamertag = ('@' + name);
        playerCount++;
    }

    public player(String nName, String nDescription, int pos, String inv[]) {
        super(nName, nDescription, pos, inv);
        gamertag = ('@' + name);
        playerCount++;
    }

    public void finalize(){
        playerCount--;
    }
};