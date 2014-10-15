/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.panels;

import java.util.Queue;
import java.util.ArrayList;
import java.util.PriorityQueue;

import ai.project.graph.Node;
import ai.project.main.Message;

/**
 *
 * @author Duru Dumebi Julian
 */
public class BFSPanel extends BasePanel{

    @Override
    public void doSearch(Node start, Node goal) {
        runner.execute(() -> {
            ArrayList<Node> children = new ArrayList<>();
            PriorityQueue<Node> queue = new PriorityQueue();
            queue.offer(start);

            while(!queue.isEmpty()){
                Node parent = queue.poll();
                System.out.println("Node visited " + parent.getState());
                parent.setSelected(true);

                doRepaint();

                if (parent.getState() == goal.getState()){
                    Message.show(this, "Found goal Node " + goal.getState());
                    break;
                }

                parent.setSelected(false);
                children = graph.getSuccessor(parent);
                if (!children.isEmpty()){
                    for (int i = 0; i < children.size(); i++){
                        Node child = children.get(i);
                        queue.offer(child);
                    }
                }
            }
        });
    }

    @Override
    public void doSearch(Node start, Node goal, int depthLimit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
