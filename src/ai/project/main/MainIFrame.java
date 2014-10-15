/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.main;

import java.awt.BorderLayout;

import ai.project.graph.Graph;
import ai.project.graph.Node;
import ai.project.main.Message;
import ai.project.panels.BasePanel;
import ai.project.panels.DLSPanel;

/**
 *
 * @author Duru Dumebi Julian
 */
public class MainIFrame extends javax.swing.JInternalFrame {

    private BasePanel panel;
    private static MainIFrame instance;
    
    /**
     * Creates new form MainIFrame
     */
    private MainIFrame() {
        initComponents();
        setSize(800, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(600, 600));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(clearButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        int nodeState = Integer.parseInt(Message.showInput(this, "Enter node to search"));
        Graph graph = panel.getGraph();
        
        Node startNode = graph.getStartNode();
        Node searchNode = graph.getNode(nodeState);
        searchNode.setGoal(true);
        
        System.out.println("Doing search: " + startNode.getState() + " to " + searchNode.getState());
        if (panel instanceof DLSPanel){
            int depth = Integer.parseInt(Message.showInput(this, "Enter search depth"));
            panel.doSearch(startNode, searchNode, depth);
        }
        else{
            panel.doSearch(startNode, searchNode);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        panel.getGraph().refresh();
        panel.doRepaint();
    }//GEN-LAST:event_clearButtonActionPerformed

    public void removePanel(){
        if (panel != null)
            remove(panel);
    }
    
    public void addPanel(BasePanel panel){
        removePanel();
        
        this.panel = panel;
        add(panel, BorderLayout.CENTER);
        
        repaint();
        panel.repaint();
        
        revalidate();
    }
    
    public BasePanel getPanel(){
        return panel;
    }
    
    public static synchronized MainIFrame getInstance(){
        if (instance == null)
            instance = new MainIFrame();
        
        return instance;
    }
    
    public void setFrameTitle(String title){
        setTitle(title);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
