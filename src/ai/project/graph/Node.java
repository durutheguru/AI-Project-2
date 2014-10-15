/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.graph;

import java.awt.Color;

/**
 *
 * @author Duru Dumebi Julian
 */
public class Node implements Comparable<Node>{
    
    private int state;
    private int cost;
    private int depth;
    private int level;
    private int x, y;
    private boolean goal;
    private boolean selected;
    private Node leftChild;
    private Node rightChild;
    private Node parent;
    
    public static final int WIDTH = 50;
    public static final Color GOAL_COLOR = Color.RED;
    public static final Color SELECTED_COLOR = Color.BLUE;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    
    public Node(int state){
        this.state = state;
        this.parent = null;
        this.depth = 0;
    }
    
    public Node(int state, Node parent){
        this.state = state;
        this.parent = parent;
        if (parent == null)
            this.depth = 0;
        else
            this.depth = parent.depth + 1;
    }
    
    public Node(int state, int cost, Node parent){
        this.state = state;
        this.parent = parent;
        this.cost = cost;
        if (parent == null)
            this.depth = 0;
        else
            this.depth = parent.depth + 1;
    }
    
    public Node(int state, int level){
        this.state = state;
        this.level = level;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getState() {
        return state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public int compareTo(Node o) {
        if (getState() > o.getState())
            return 1;
        else if (getState() < o.getState())
            return -1;
        else
            return 0;
            
    }
    
}

