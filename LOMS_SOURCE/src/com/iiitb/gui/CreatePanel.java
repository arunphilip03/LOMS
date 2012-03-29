package com.iiitb.gui;

import com.iiitb.config.LOMSProperties;
import com.iiitb.java.CreateImsManifest;
import com.iiitb.java.LOMSCustomFilter;
import com.iiitb.java.ManifestData;
import com.iiitb.java.ZipFolder;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.*;

/**
 *
 * @author ARUN
 */
public class CreatePanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePanel
     */
    public CreatePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createFileChooser = new javax.swing.JFileChooser();
        ScrollPane = new javax.swing.JScrollPane();
        PackageTree = new javax.swing.JTree();
        treeToolBar = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        addFolderButton = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Create Package"));
        setLayout(new java.awt.BorderLayout());

        PackageTree.setEditable(true);
        ScrollPane.setViewportView(PackageTree);

        add(ScrollPane, java.awt.BorderLayout.CENTER);

        treeToolBar.setRollover(true);

        addFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Folder-New-32.png"))); // NOI18N
        addFolderButton.setToolTipText("New Folder");
        addFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderButtonActionPerformed(evt);
            }
        });
        treeToolBar.add(addFolderButton);

        addItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add-Files-To-Archive-32.png"))); // NOI18N
        addItemButton.setToolTipText("Add File");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        treeToolBar.add(addItemButton);

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Emblem-Package-32.png"))); // NOI18N
        createButton.setToolTipText("Create Package");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        treeToolBar.add(createButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Edit-Delete-32.png"))); // NOI18N
        deleteButton.setToolTipText("Delete Selected");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        treeToolBar.add(deleteButton);

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Edit-Clear-32.png"))); // NOI18N
        clearButton.setToolTipText("Clear All");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        treeToolBar.add(clearButton);

        add(treeToolBar, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void addFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderButtonActionPerformed

//        DefaultMutableTreeNode folderNode;
//        folderNode = new DefaultMutableTreeNode("folder");
//        treeModel.add(folderNode);

        addObject("Folder" + nodeSuffix++);
    }//GEN-LAST:event_addFolderButtonActionPerformed

    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = PackageTree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());

        }

        if (!parentNode.equals(rootNode)) {
            JOptionPane.showMessageDialog(this, "New folder can be created only under Root folder", "Error", JOptionPane.ERROR_MESSAGE);
            nodeSuffix--;
            return null;
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child,
            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the new node.
        if (shouldBeVisible) {
            PackageTree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public DefaultMutableTreeNode addFileObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = PackageTree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addFileObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addFileObject(DefaultMutableTreeNode parent,
            Object child,
            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                (DefaultMutableTreeNode) child;

        if (parent == null) {
            parent = rootNode;
        }

        //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the new node.
        if (shouldBeVisible) {
            PackageTree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    /**
     * Remove the currently selected node.
     */
    public void removeCurrentNode() {
        TreePath currentSelection = PackageTree.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }

        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /**
     * Remove all nodes except the root node.
     */
    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        removeCurrentNode();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        TreeModel model = PackageTree.getModel();
        if (model != null) {
            Object root = model.getRoot();
            //System.out.println(root.toString());
            String packageName = root.toString();
            String rootDir = root.toString();
            //System.out.println("Root Dir: " + rootDir);
            rootDir = new LOMSProperties().getTempDirectory() + "\\" + rootDir;
            //System.out.println("Root Dir: " + rootDir);

            /*
             * Create root folder
             */
            boolean createDirStatus = (new File(rootDir)).mkdirs();
            //System.out.println("Status:" + createDirStatus);

            if (!createDirStatus && !new File(rootDir).exists()) {
                //System.out.println("Error creating root directory");
                JOptionPane.showMessageDialog(this, "Error creating temporary directory", "Error", JOptionPane.ERROR_MESSAGE);
            }

            walk(model, root, rootDir);
            copyScormXsds(rootDir);
            CreateImsManifest createImsManifest = new CreateImsManifest();
            createImsManifest.CreateExportImsManifest(rootDir, packageName, imsFileInfo);
            createZipPackage(rootDir);


        } else {
            System.out.println("Tree is empty.");
        }
    }//GEN-LAST:event_createButtonActionPerformed

    protected void walk(TreeModel model, Object o, String rootDir) {
        int cc;
        cc = model.getChildCount(o);

        System.out.println("Count" + cc);
        for (int i = 0; i < cc; i++) {
            Object child = model.getChild(o, i);
            if (model.isLeaf(child)) {
                //System.out.println("Leaf " + child.toString());
                DefaultMutableTreeNode tree = (DefaultMutableTreeNode) child;

                String parentFolder = "";

                if (tree.getParent().equals(tree.getRoot())) {
                    dirPath = rootDir;
                    //tree.getParent().toString();

                } else {
                    dirPath = rootDir + "/" + tree.getParent().toString();
                    parentFolder = tree.getParent().toString();
                }

                FileInfo fileInfObj = (FileInfo) tree.getUserObject();
                //System.out.println("dirPath: " + dirPath);
                if (dirPath == null) {
                    dirPath = rootDir;
                }
                File destFile = new File(dirPath + "/" + fileInfObj.fileName);
                try {
                    copyFile(fileInfObj.fFile, destFile);

                    populateFileList(fileInfObj, parentFolder);
                } catch (IOException ex) {
                    Logger.getLogger(CreatePanel.class.getName()).log(Level.SEVERE, null, ex);
                }


            } else {
                dirPath = rootDir + "/" + child.toString();
                DefaultMutableTreeNode tree = (DefaultMutableTreeNode) child;
                boolean createDirStatus = (new File(dirPath)).mkdirs();
                //System.out.print(child.toString() + "--");
                walk(model, child, rootDir);
            }
        }
    }

    private void populateFileList(FileInfo fileInfObj, String parentFolder) {

        String fileNameNoExtn = fileInfObj.fileName.substring(0, fileInfObj.fileName.lastIndexOf('.'));

        ManifestData mdObj = new ManifestData();
        mdObj.setFileName(fileNameNoExtn);
        if (parentFolder.isEmpty()) {
            mdObj.setHref(fileInfObj.fileName);
        } else {
            mdObj.setHref(parentFolder + "/" + fileInfObj.fileName);
        }
        imsFileInfo.add(mdObj);

    }

    protected void copyScormXsds(String rootDir) {

        String filePath = "scorm12schemadefinition";
        String[] xsdFiles = {"adlcp_rootv1p2.xsd", "ims_xml.xsd", "imscp_rootv1p1p2.xsd", "imsmd_rootv1p2p1.xsd"};

        for (String file : xsdFiles) {
            File srcFile = new File(filePath + "\\" + file);
            //System.out.println("Source File:: "+srcFile);
            File destFile = new File(rootDir + "\\" + file);
            try {
                copyFile(srcFile, destFile);
            } catch (IOException ex) {
                Logger.getLogger(CreatePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            // previous code: destination.transferFrom(source, 0, source.size());
            // to avoid infinite loops, should be:
            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, 0, size - count)) < size);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    protected void createZipPackage(String rootDir) {
        //File input = new File(rootDir);
        //File output = new File(rootDir+".zip");
        String output = rootDir + ".zip";
        try {
            ZipFolder zipFolder = new ZipFolder(rootDir, output);
        } catch (Exception ex) {
            Logger.getLogger(CreatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        FileFilter filterTypes = new LOMSCustomFilter("Resources(*.pdf,*.ppt,*.html)", new String[]{".pdf", ".ppt", ".html"});
        createFileChooser.addChoosableFileFilter(filterTypes);
        createFileChooser.setFileFilter(filterTypes);
        createFileChooser.setFileView(null);
        int returnVal = createFileChooser.showDialog(this, "Select Resource");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File selectedFile = createFileChooser.getSelectedFile();
            try {

                DefaultMutableTreeNode fileNode = null;

                fileNode = new DefaultMutableTreeNode(new FileInfo(selectedFile.getName(), selectedFile.getAbsolutePath(), selectedFile));
                addFileObject(fileNode);
                //System.out.println("File Length: " + selectedFile.length());

            } catch (Exception ex) {
                System.out.println("Problem accessing file");
            }
        } else {
            System.out.println("File access cancelled by user");
        }
    }//GEN-LAST:event_addItemButtonActionPerformed

    private class FileInfo {

        public String fileName;
        public String fileURL;
        public File fFile;

        public FileInfo(String file, String url, File fileObj) {
            fileName = file;
            fileURL = url;
            fFile = fileObj;
        }

        @Override
        public String toString() {
            return fileName;
        }
    }

    class MyTreeModelListener implements TreeModelListener {

        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

            /*
             * If the event lists children, then the changed node is the child
             * of the node we've already gotten. Otherwise, the changed node and
             * the specified node are the same.
             */

            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode) (node.getChildAt(index));

            //System.out.println("The user has finished editing the node.");
            //System.out.println("New value: " + node.getUserObject());
        }

        @Override
        public void treeNodesInserted(TreeModelEvent e) {
        }

        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
        }

        @Override
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree PackageTree;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton addFolderButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton createButton;
    private javax.swing.JFileChooser createFileChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JToolBar treeToolBar;
    // End of variables declaration//GEN-END:variables
    private DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private int nodeSuffix = 1;
    private String dirPath;
    private String scormFolderBase = "src";
    private ArrayList<File> fileList = new ArrayList<File>();
    private ArrayList<ManifestData> imsFileInfo = new ArrayList<ManifestData>();

    public void populateTree(String packageName) {
        rootNode = new DefaultMutableTreeNode(packageName);
        treeModel = new DefaultTreeModel(rootNode);
        treeModel.addTreeModelListener(new MyTreeModelListener());
        PackageTree.setModel(treeModel);
        ScrollPane.setViewportView(PackageTree);
    }
}
