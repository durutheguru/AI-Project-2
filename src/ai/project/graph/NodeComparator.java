/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.graph;

import java.util.Comparator;

/**
 *
 * @author Duru Dumebi Julian
 */
public class NodeComparator implements Comparator<Node>{

    @Override
    public int compare(Node node1, Node node2) {
        int val1 = node1.getCost();
        int val2 = node2.getCost();
        
        if (val1 <= val2){
            return 1;
        }
        else
            return 0;
    }

    
}
