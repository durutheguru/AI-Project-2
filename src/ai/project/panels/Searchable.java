/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.panels;

import ai.project.graph.Node;

/**
 *
 * @author Duru Dumebi Julian
 */
public interface Searchable {
    
    public void doSearch(Node start, Node goal);
    
    public void doSearch(Node start, Node goal, int depthLimit);
    
}
