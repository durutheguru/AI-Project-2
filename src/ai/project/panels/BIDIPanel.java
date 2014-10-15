/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.panels;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

import ai.project.graph.Node;
import ai.project.main.Message;

/**
 *
 * @author Duru Dumebi Julian
 */
public class BIDIPanel extends BasePanel{

    @Override
    public void doSearch(Node start, Node goal) {
        runner.execute(() -> {
            ArrayList<Node> children1 = new ArrayList<>();
            ArrayList<Node> children2 = new ArrayList<>();
            Queue<Node> initialQueue = new ArrayDeque();
            Queue<Node> goalQueue = new ArrayDeque();

            initialQueue.add(start);
            goalQueue.add(goal);

            while ((initialQueue.size() != 0) && goalQueue.size() != 0){
                Node parent1 = (Node) initialQueue.poll();
                System.out.printf("Node %d visited.%n", parent1.getState());

                parent1.setSelected(true);
                doRepaint();
                if ((parent1.getState() == goal.getState()) || contain(goalQueue, parent1)){
                    System.out.println();
                    Message.show(this, "Found common node " + parent1.getState());
                    break;
                }
                children1 = graph.getSuccessor(parent1);
                for (Node child : children1) {
                    initialQueue.add(child);
                }

                Node parent2 = (Node) goalQueue.poll();
                System.out.printf("Node %d visited.%n", parent2.getState());

                parent2.setSelected(true);
                doRepaint();
                if ((parent2.getState() == start.getState()) || contain(initialQueue, parent2)){
                    System.out.println();
                    Message.show(this, "Found common node " + parent2.getState());
                    break;
                }
                children2 = graph.getSuccessorReverse(parent2);
                for (Node child : children2) {
                    goalQueue.add(child);
                }
            }
        });
    }

    public static boolean contain(Queue<Node> queue, Node parent){
        for (Node item : queue) {
            if (item.getState() == parent.getState())
                return true;
        }
        
        return false;
    }
    
    @Override
    public void doSearch(Node start, Node goal, int depthLimit) {
    }
    
}
