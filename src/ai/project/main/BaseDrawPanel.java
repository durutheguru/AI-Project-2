/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.project.main;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ai.project.graph.Node;
import ai.project.graph.Graph;
import ai.project.graph.Edge;

/**
 *
 * @author Duru Dumebi Julian
 */
public class BaseDrawPanel extends JPanel implements Observer {

    int lastLevel;
    Node lastNode;
    Graph graph;

    public BaseDrawPanel() {
        graph = new Graph();
        lastLevel = 0;

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Node clickedNode = getNode(e.getX(), e.getY());
                
                if (clickedNode == null){
                    System.out.println("Clicked Node is null");
                }
                else{
                    System.out.println("Clicked Node is not null");
                }
                    
                
                Node node = clickedNode == null ? new Node(lastLevel + 1) : clickedNode;
                node.setX(e.getX());
                node.setY(e.getY());

                if (lastNode != null) {
//                    Edge edge = new Edge();
//                    edge.setStartNode(lastNode);
//                    edge.setEndNode(node);
//                    
//                    edge.setX1(lastNode.getX() + 15);
//                    edge.setY1(lastNode.getY() + 15);
//
//                    edge.setX2(node.getX() + 15);
//                    edge.setY2(node.getY() + 15);
//
//                    graph.addEdge(edge);
                }
                
                graph.addNode(node);
                lastNode = node;
                
                repaint();
            }
            
            private boolean containsNode(Node n, int x, int y){
                return n.getX() - x > 0 && n.getY() - y > 0 && n.getX() - x < 30 && n.getY() - y < 30;
            }
            
            private Node getNode(int x, int y){
                ArrayList<Node> nodes = graph.getNodes();
                for (Node node : nodes) {
                    if (containsNode(node, x, y))
                        return node;
                }
                
                return null;
            }

        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Node> nodes = graph.getNodes();
        ArrayList<Edge> edges = graph.getEdges();

        nodes.stream().forEach((n) -> {
            g.fillOval(n.getX(), n.getY(), 30, 30);
        });

        edges.stream().forEach((e) -> {
            g.drawLine(e.getX1(), e.getY1(), e.getX2(), e.getY2());
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public void clear() {
        graph.removeAllNodes();
        graph.removeAllEdges();

        repaint();
    }

}
