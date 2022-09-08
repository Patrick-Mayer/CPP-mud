/*
 * @author: Patrick
 * @brief: Defines characteristics for all entities (includes monsters).
 */

/*
 TODO
 *Make "take item", "drop item", "attack", "run", etc methods.
 *Make inventory system for all entities. 
 */

package Entities;

public abstract class entity {
    public String name, description;
    public String items[];

    public entity() {
        name = "";
        description = "";
        items = new String[]{"You have no items"};
    }

    public entity(String nName, String nDescription, String arr[]){
        name = nName;
        description = nDescription;
        items = arr;
    }
};