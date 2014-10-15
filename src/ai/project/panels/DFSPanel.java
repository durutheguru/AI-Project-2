/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.panels;


import java.awt.Graphics;
import java.util.Stack;
import java.util.ArrayList;

import ai.project.graph.Node;
import ai.project.graph.Edge;
import ai.project.graph.Graph;
import ai.project.graph.GetSucc;
import ai.project.main.Message;

/**
 *
 * @author Duru Dumebi Julian
 */
public class DFSPanel extends BasePanel{
    
    public DFSPanel(){
    }
    
    @Override
    public void doSearch(Node start, Node goal){
        runner.execute(() -> {
            ArrayList<Node> children = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(start);

            while(!stack.isEmpty()){
                Node parent = stack.pop();
                System.out.println("Node visited " + parent.getState());
                parent.setSelected(true);

                doRepaint();

                if (parent.getState() == goal.getState()){
                    Message.show(this, "Found Goal Node " + goal.getState());
                    break;
                }

                parent.setSelected(false);
                children = graph.getSuccessor(parent);
                if (!children.isEmpty()){
                    for (int i = children.size() - 1; i >= 0; i--) {
                        Node child = children.get(i);
                        stack.push(child);
                        System.out.println("Child Node for " + parent.getState() + " ___ " + child.getState());
                    }
                }
            }
        });        
    }
    
    public void doSearch(Node start, Node goal, int depth){}
    
}
