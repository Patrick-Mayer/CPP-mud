/*
 * @author: Delftstack
 * @brief: Tool for implementing trees
 */

 //https://www.delftstack.com/howto/java/java-tree/

package Utilities;

public class java_tree {
        node root;
    
        public void traverseRecursionTree(node n) {
            if (n != null) {
                traverseRecursionTree(n.left);
                System.out.print(" " + n.value);
                traverseRecursionTree(n.right);
            }
        }
};