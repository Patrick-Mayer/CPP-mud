/*
 * @author: Geeksforgeeks
 * @brief: Graph for map system
 */

//https://www.geeksforgeeks.org/implementing-generic-graph-in-java/

//! NOTES FOR USAGE:
//! Graphs should be initialized with Graph<type> name = new Graph<>(); - same syntax as HashMaps.
//! If you want to return a value rather than printing to console, put dummy int as last argument.

package Utilities;

import java.util.*;
 
public class Graph<T> {
 
    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();
 
    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }
 
    // This function adds the edge
    // between source to destination
    public void addEdge(T source,
                        T destination,
                        boolean bidirectional)
    {
 
        if (!map.containsKey(source))
            addVertex(source);
 
        if (!map.containsKey(destination))
            addVertex(destination);
 
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

 //==============================================================================================
 //Utility methods

    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                           + map.keySet().size()
                           + " vertex");
    }
 
    //Patrick's function - return edges count instead of printing it, i is dummy variable just to overload it.
    public int getVertexCount(int i)
    {
        return map.keySet().size();
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                           + count
                           + " edges.");
    }
 
    //Patrick's function - return edges count instead of printing it, i is dummy variable just to overload it.
    public int getEdgesCount(boolean bidirection, int i)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        return count;
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                               + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                               + s + " as a vertex.");
        }
    }
    
    //Patrick's function - returns boolean instead of printing it, i is dummy variable just to overload it.
    public boolean hasVertex(T s, int i)
    {
        if (map.containsKey(s)) {
            return true;
        }
        else {
            return false;
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                               + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                               + s + " and " + d + ".");
        }
    }

    //Patrick's function - returns boolean instead of printing it, i is dummy variable just to overload it.
    public boolean hasEdge(T s, T d, int i)
    {
        if (map.get(s).contains(d)) {
            return true;
        }
        else {
            return false;
        }
    }
 
    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
 
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
 
        return (builder.toString());
    }
    
    //My traversal methods
    
    //in this case, T is most likely a room
    public ArrayList<T> neighbors(T start){
        ArrayList<T> nodes = new ArrayList();
      
        //java lambda expressions/forEach()
        map.forEach((key, value) -> {
            if (hasEdge(start, key, 1)){
                nodes.add(key);
            }
        });

        return nodes;
        //where would you like to go?
        //print list of options
        //(take user input)
    }
};