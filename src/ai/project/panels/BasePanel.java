/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.panels;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import ai.project.graph.Node;
import ai.project.graph.Edge;
import ai.project.graph.Graph;

/**
 *
 * @author Duru Dumebi Julian
 */
public abstract class BasePanel extends JPanel implements Searchable{
    
    protected Graph graph;
    protected ExecutorService runner = Executors.newCachedThreadPool();
    
    public BasePanel(){
        graph = new Graph();
        
        Node node1 = new Node(1);
        node1.setX(300);
        node1.setY(100);
        
        Node node2 = new Node(2, node1);
        node2.setX(200);
        node2.setY(200);
        
        Node node3 = new Node(3, node1);
        node3.setX(400);
        node3.setY(200);
        
        Node node4 = new Node(4, node2);
        node4.setX(150);
        node4.setY(300);
        
        Node node5 = new Node(5, node2);
        node5.setX(300);
        node5.setY(300);
        
        Node node6 = new Node(6, node3);
        node6.setX(350);
        node6.setY(300);
        
        Node node7 = new Node(7, node3);
        node7.setX(470);
        node7.setY(300);
        
        Node node8 = new Node(8, node4);
        node8.setX(50);
        node8.setY(400);
        
        Node node9 = new Node(9, node4);
        node9.setX(180);
        node9.setY(400);
        
        Node node10 = new Node(10, node5);
        node10.setX(250);
        node10.setY(400);
        
        Edge edge1 = new Edge(node1, node2);
        Edge edge2 = new Edge(node1, node3);
        Edge edge3 = new Edge(node2, node4);
        Edge edge4 = new Edge(node2, node5);
        Edge edge5 = new Edge(node3, node6);
        Edge edge6 = new Edge(node3, node7);
        Edge edge7 = new Edge(node4, node8);
        Edge edge8 = new Edge(node4, node9);
        Edge edge9 = new Edge(node5, node10);
        
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);
        graph.addNode(node9);
        graph.addNode(node10);
        
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        graph.addEdge(edge4);
        graph.addEdge(edge5);
        graph.addEdge(edge6);
        graph.addEdge(edge7);
        graph.addEdge(edge8);
        graph.addEdge(edge9);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(Node node : graph.getNodes()){
            g.setColor(node.isSelected() ? Node.SELECTED_COLOR : node.isGoal() ? Node.GOAL_COLOR : Node.DEFAULT_COLOR);
            g.fillOval(node.getX(), node.getY(), 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(node.getState()), node.getX() + 15, node.getY() + 15);
        }
        
        g.setColor(Color.BLACK);
        for (Edge edge : graph.getEdges()){            
            g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
        }
    }
    
    public void doRepaint(){
        repaint();
        try{ Thread.sleep(1400); } catch(InterruptedException ex) { ex.printStackTrace(); }
    }
    
    public Graph getGraph(){
        return graph;
    }
    
}
