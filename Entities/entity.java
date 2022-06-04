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

public class entity {
    public String name, description;

    public entity() {
        name = "";
        description = "";
    }

    public entity(String nName, String nDescription){
        name = nName;
        description = nDescription;
    }
};