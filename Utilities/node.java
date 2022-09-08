/*
 * @author: Delftstack
 * @brief: Tool for implementing trees
 */

 //https://www.delftstack.com/howto/java/java-tree/

package Utilities;

public class node {
    int value;
    node left;
    node right;

    public node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}