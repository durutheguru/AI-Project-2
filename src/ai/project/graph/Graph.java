/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.graph;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;


/**
 *
 * @author Duru Dumebi Julian
 */
public class Graph extends Observable{
    
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    
    public Graph(){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
    public void addNode(Node n){
        nodes.add(n);
    }
    
    public void addEdge(Edge v){
        edges.add(v);
    }
    
    public Node getNode(int state){
        for (Node n : nodes)
            if (n.getState() == state)
                return n;
        
        return null;
    }
    
    public Node getStartNode(){
        return nodes.get(0);
    }
    
    public Edge getEdge(int index){
        return edges.get(index);
    }
    
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    
    public ArrayList<Node> getNodes(){
        return nodes;
    }
    
    public void removeEdge(int index){
        edges.remove(index);
    }
    
    public void removeNode(int index){
        nodes.remove(index);
    }
    
    public void removeAllNodes(){
        for(int i = 0; i < nodes.size(); i++){
            removeNode(i);
        }
    }
    
    public void removeAllEdges(){
        for(int i = 0; i < nodes.size(); i++){
            removeEdge(i);
        }
    }
    
    public ArrayList<Node> getSuccessor(Node node){
        ArrayList<Node> result = new ArrayList<>();
        
        Node node1 = getNode(2 * node.getState());
        Node node2 = getNode(2 * node.getState() + 1);
        
        if (node1 != null)
            result.add(node1);
        
        if (node2 != null)
            result.add(node2);
        
        return result;
    }
    
    public ArrayList<Node> getSuccessorReverse(Node node){
        ArrayList<Node> result = new ArrayList<>();
        int state = node.getState();
        if (state % 2 == 0){
            int p = state / 2;
            result.add(getNode(p));
        }
        else{
            int p = (state - 1) / 2;
            result.add(getNode(p));
        }
        
        return result;
    }
    
    public void refresh(){
        for (Node node : nodes) {
            node.setSelected(false);
            node.setGoal(false);
        }
    }
    
}
