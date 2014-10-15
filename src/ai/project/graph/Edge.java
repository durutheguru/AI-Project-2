/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.graph;

/**
 *
 * @author Duru Dumebi Julian
 */
public class Edge {
    
    private int x1, y1, x2, y2;
    private Node startNode;
    private Node endNode;

    public Edge(Node startNode, Node endNode){
        this.startNode = startNode;
        this.endNode = endNode;
        
        x1 = this.startNode.getX() + 15;
        y1 = this.startNode.getY() + 15;
        
        x2 = this.endNode.getX() + 15;
        y2 = this.endNode.getY() + 15;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
    
}
