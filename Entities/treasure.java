/*
 * @author: Patrick
 * @brief: Defines usable objects.
 */

package Entities;

public class treasure extends entity{
    //? every item has an ID? Maybe have num be type and letters be subtypes.
    final String ID = "1";
    
    public treasure(){
        super("","");
    }

    public treasure(String nName, String nDescription){
        super(nName, nDescription);
    }
};