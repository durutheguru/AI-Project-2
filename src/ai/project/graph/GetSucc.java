/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.graph;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * 
 * @author Duru Dumebi Julian
 */
public class GetSucc {
    
    /*
    * Gets the downward successor or child of a node.
    */
    public ArrayList getSuccessor(int state){
        ArrayList result = new ArrayList();
        result.add(2 * state);
        result.add(2 * state + 1);
        
        return result;
    }
    
    /*
    * Gets the upward successor or parent of a node.
    */
    public ArrayList getSuccessorReverse(int state){
        ArrayList result = new ArrayList();
        if (state % 2 == 0){
            int p = state / 2;
            result.add(p);
        }
        else{
            int sib = state + 1;
            result.add(sib / 2 - 1);
        }
        
        return result;
    }
    
    /*
    * Gets the successor of a given parent node with its state specified.
    */
    public ArrayList getSuccessor(int state, Node parent){
        ArrayList result = new ArrayList();
        Random rand = new Random();
        result.add(new Node(2 * state, rand.nextInt(100) + parent.getCost(), parent));
        result.add(new Node(2 * state + 1, rand.nextInt(100) + parent.getCost(), parent));
        
        result.sort(new NodeComparator());
        return result;
    }
    
}
