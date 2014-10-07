/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xiaofan.module.ftp.client;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Administrator
 */
public class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    
    public FileTreeCellRenderer(){}

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        if( node.getUserObject() instanceof String ){
            System.out.println( node.getUserObject() );
        }
        FileNode fileNode = (FileNode)node.getUserObject();
        FileSystemView fsv = FileSystemView.getFileSystemView();
	Icon smallIcon = fsv.getSystemIcon( fileNode.getFile() );
        if( fileNode.getFile().isHidden() ){
            
        }
        if( smallIcon != null )
            setIcon( smallIcon );
        return this;
    }
    
    
}
