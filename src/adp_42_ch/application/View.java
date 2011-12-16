package adp_42_ch.application;

import static adp_42_ch.implementations.Images.*;
import adp_42_ch.implementations.NaRP;
import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;
import adp_42_ch.interfaces.RandomPoints;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Dec 13, 2011, 12:13:20 PM
 */
/**
 *
 * @author panos
 */
public class View extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public View() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectAlgorithmButtonGroup = new javax.swing.ButtonGroup();
        imagePanel = new javax.swing.JPanel()        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                if (xFactor*yFactor!=0.0) {
                    g.setColor(Color.lightGray);
                    g.drawLine(0, (int)(yMax*yFactor+Config.PIXEL_RADIUS), this.getWidth(), (int)(yMax*yFactor+Config.PIXEL_RADIUS));
                    g.drawLine((int)(-xMin*xFactor+Config.PIXEL_RADIUS), 0, (int)(-xMin*xFactor+Config.PIXEL_RADIUS), this.getHeight());
                }
                if (innerPoints!=null) {
                    g.setColor(Color.blue);
                    for (adp_42_ch.interfaces.Point point:innerPoints) {
                        g.fillOval((int)((point.x()-xMin)*xFactor), (int)((yMax-point.y())*yFactor), 2*Config.PIXEL_RADIUS, 2*Config.PIXEL_RADIUS);
                    }
                }
                if (convexHull!=null) {
                    g.setColor(Color.red);
                    int[] convexHullX=new int[convexHull.size()+1];
                    int[] convexHullY=new int[convexHull.size()+1];
                    int index=0;
                    for (adp_42_ch.interfaces.Point point:convexHull) {
                        int x=(int)((point.x()-xMin)*xFactor);
                        int y=(int)((yMax-point.y())*yFactor);
                        convexHullX[index]=x+Config.PIXEL_RADIUS;
                        convexHullY[index]=y+Config.PIXEL_RADIUS;
                        g.fillOval(x, y, 2*Config.PIXEL_RADIUS, 2*Config.PIXEL_RADIUS);
                        index++;
                    }
                    convexHullX[index]=convexHullX[0];
                    convexHullY[index]=convexHullY[0];
                    g.setColor(Color.black);
                    g.drawPolyline(convexHullX, convexHullY, convexHull.size()+1);
                }
            }
        }
        ;
        controlPanel = new javax.swing.JPanel();
        randomSeedLabel = new javax.swing.JLabel();
        xMinLabel = new javax.swing.JLabel();
        xMaxLabel = new javax.swing.JLabel();
        yMinLabel = new javax.swing.JLabel();
        yMaxLabel = new javax.swing.JLabel();
        numberOfPointsLabel = new javax.swing.JLabel();
        randomSeedTextField = new javax.swing.JTextField();
        xMaxTextField = new javax.swing.JTextField();
        yMinTextField = new javax.swing.JTextField();
        yMaxTextField = new javax.swing.JTextField();
        numberOfPointsTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        restoreDefaultsButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        xMinTextField = new javax.swing.JTextField();
        consoleOutputButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListHistory = new javax.swing.JList();
        historyLabel = new javax.swing.JLabel();
        historyButton = new javax.swing.JButton();
        grahamScanRadioButton = new javax.swing.JRadioButton();
        monotoneChainRadioButton = new javax.swing.JRadioButton();
        selectAlgorithmLabel = new javax.swing.JLabel();
        fileButton = new javax.swing.JButton();
        statusTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagePanel.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        randomSeedLabel.setText("random seed");

        xMinLabel.setText("x-minimum");

        xMaxLabel.setText("x-maximum");

        yMinLabel.setText("y-minimum");

        yMaxLabel.setText("y-maximum");

        numberOfPointsLabel.setText("number of points");

        randomSeedTextField.setText("");

        xMaxTextField.setText(String.valueOf(Config.DEFAULT_X_MAXIMUM));

        yMinTextField.setText(String.valueOf(Config.DEFAULT_Y_MINIMUM));

        yMaxTextField.setText(String.valueOf(Config.DEFAULT_Y_MAXIMUM));

        numberOfPointsTextField.setText(String.valueOf(Config.DEFAULT_NUMBER_OF_POINTS));

        okButton.setText("go");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        restoreDefaultsButton.setText("restore defaults");
        restoreDefaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreDefaultsButtonActionPerformed(evt);
            }
        });

        quitButton.setText("quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        xMinTextField.setText(String.valueOf(Config.DEFAULT_X_MINIMUM));

        consoleOutputButton.setText("console output");
        consoleOutputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consoleOutputButtonActionPerformed(evt);
            }
        });

        jListHistory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListHistory);

        historyLabel.setText("history");

        historyButton.setText("paint selected entry");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        selectAlgorithmButtonGroup.add(grahamScanRadioButton);
        grahamScanRadioButton.setSelected(true);
        grahamScanRadioButton.setText("graham scan");

        selectAlgorithmButtonGroup.add(monotoneChainRadioButton);
        monotoneChainRadioButton.setText("monotone chain");

        selectAlgorithmLabel.setText("select algorithm:");

        fileButton.setText("Paint from file");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfPointsLabel)
                    .addComponent(yMaxLabel)
                    .addComponent(yMinLabel)
                    .addComponent(xMaxLabel)
                    .addComponent(xMinLabel)
                    .addComponent(randomSeedLabel))
                .addGap(18, 18, 18)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(randomSeedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(yMinTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(yMaxTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(numberOfPointsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(xMinTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(xMaxTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                        .addGap(13, 13, 13)))
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consoleOutputButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(restoreDefaultsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addGap(155, 155, 155))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(historyButton)
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyLabel)
                .addContainerGap(466, Short.MAX_VALUE))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectAlgorithmLabel)
                .addGap(18, 18, 18)
                .addComponent(grahamScanRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monotoneChainRadioButton)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(fileButton)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomSeedLabel)
                    .addComponent(randomSeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xMinLabel)
                    .addComponent(xMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xMaxLabel)
                    .addComponent(xMaxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yMinLabel)
                    .addComponent(yMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yMaxLabel)
                    .addComponent(yMaxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfPointsLabel)
                    .addComponent(numberOfPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restoreDefaultsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consoleOutputButton)
                .addGap(11, 11, 11)
                .addComponent(historyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(historyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectAlgorithmLabel)
                    .addComponent(grahamScanRadioButton)
                    .addComponent(monotoneChainRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(fileButton))
        );

        statusTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(629, Short.MAX_VALUE)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_quitButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            boolean withSeed = false;
            long seed = 0;
            if (!randomSeedTextField.getText().isEmpty()) {
                seed = Long.parseLong(randomSeedTextField.getText());
                withSeed = true;
            }
            int xMin = Integer.parseInt(xMinTextField.getText());
            int xMax = Integer.parseInt(xMaxTextField.getText());
            int yMin = Integer.parseInt(yMinTextField.getText());
            int yMax = Integer.parseInt(yMaxTextField.getText());
            int numberOfPoints = Integer.parseInt(numberOfPointsTextField.getText());
            statusTextField.setText("");
            RandomPoints rp;
            if (withSeed) {
                rp = randomPoints(seed, numberOfPoints, xMin, xMax, yMin, yMax);
            } else {
                rp = randomPoints(numberOfPoints, xMin, xMax, yMin, yMax);
            }
            if (rp instanceof NaRP) {
                statusTextField.setText("Precondition violated!");
            } else {
                updateHistory(rp);
                setImage(rp);
            }

        } catch (NumberFormatException e) {
            statusTextField.setText("Error: Bad number format: " + e.getMessage());
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void restoreDefaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreDefaultsButtonActionPerformed
        randomSeedTextField.setText("");
        xMinTextField.setText(String.valueOf(Config.DEFAULT_X_MINIMUM));
        xMaxTextField.setText(String.valueOf(Config.DEFAULT_X_MAXIMUM));
        yMinTextField.setText(String.valueOf(Config.DEFAULT_Y_MINIMUM));
        yMaxTextField.setText(String.valueOf(Config.DEFAULT_Y_MAXIMUM));
        numberOfPointsTextField.setText(String.valueOf(Config.DEFAULT_NUMBER_OF_POINTS));
        statusTextField.setText("Default values restored");
    }//GEN-LAST:event_restoreDefaultsButtonActionPerformed

    private void consoleOutputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consoleOutputButtonActionPerformed
        if (currentImage != null) {
            System.out.println("Convex hull:");
            System.out.println(currentImage.convexHullLexicographically());
            System.out.println("Inner points:");
            System.out.println(currentImage.innerPoints());
        }
    }//GEN-LAST:event_consoleOutputButtonActionPerformed

private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
    if (!jListHistory.isSelectionEmpty()) {
        RandomPoints rp = history.get(jListHistory.getSelectedIndex());
        setImage(rp);
        statusTextField.setText("Entry from history restored");
        randomSeedTextField.setText(String.valueOf(rp.seed()));
        xMinTextField.setText(String.valueOf(rp.minX()));
        xMaxTextField.setText(String.valueOf(rp.maxX()));
        yMinTextField.setText(String.valueOf(rp.minY()));
        yMaxTextField.setText(String.valueOf(rp.maxY()));
        numberOfPointsTextField.setText(String.valueOf(rp.size()));
    } else {
        statusTextField.setText("Nothing Selected");
    }
}//GEN-LAST:event_historyButtonActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        fileChooser=new JFileChooser();
        int returnVal=fileChooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
        Parser parser=Parser.create(fileChooser.getSelectedFile());
        if (grahamScanRadioButton.isSelected()) {
            setImage(imageGrahamScan(parser.points()),parser.minX(),parser.maxX(),parser.minY(),parser.maxY());
        } else if (monotoneChainRadioButton.isSelected()) {
            setImage(imageMonotoneChain(parser.points()),parser.minX(),parser.maxX(),parser.minY(),parser.maxY());
        }   
        statusTextField.setText("File opened");
        }
        else{
            statusTextField.setText("No File selected");
        }
        
    }//GEN-LAST:event_fileButtonActionPerformed

    private void setImage(Image image, int minX, int maxX, int minY, int maxY) {
        currentImage=image;
        convexHull = currentImage.convexHull();
        innerPoints = currentImage.innerPoints();
        this.yMax = maxY;
        this.xMin = minX;
        xFactor = ((double) imagePanel.getWidth() - 2 * Config.PIXEL_RADIUS) / (maxX - minX);
        yFactor = ((double) imagePanel.getHeight() - 2 * Config.PIXEL_RADIUS) / (maxY - minY);
        imagePanel.repaint();
    }
    
    private void setImage(RandomPoints rp) {
        Image image=null;
        if (grahamScanRadioButton.isSelected()) {
            image = imageGrahamScan(rp.points());
        } else if (monotoneChainRadioButton.isSelected()) {
            image = imageMonotoneChain(rp.points());
        }
        setImage(image,rp.minX(),rp.maxX(),rp.minY(),rp.maxY());
//        convexHull = currentImage.convexHull();
//        innerPoints = currentImage.innerPoints();
//        this.yMax = rp.maxY();
//        this.xMin = rp.minX();
//        xFactor = ((double) imagePanel.getWidth() - 2 * Config.PIXEL_RADIUS) / (rp.maxX() - rp.minX());
//        yFactor = ((double) imagePanel.getHeight() - 2 * Config.PIXEL_RADIUS) / (rp.maxY() - rp.minY());

//        imagePanel.repaint();
        statusTextField.setText("Seed: " + String.valueOf(rp.seed()));

    }

    private void updateHistory(RandomPoints rp) {
        history.add(rp);
        DefaultListModel listmodel = new DefaultListModel();
        int i = 1;
        for (RandomPoints entry : history) {
            listmodel.addElement(i++ + ".: " + entry.seed());
        }
        jListHistory.setModel(listmodel);
        controlPanel.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new View().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton consoleOutputButton;
    javax.swing.JPanel controlPanel;
    javax.swing.JButton fileButton;
    javax.swing.JRadioButton grahamScanRadioButton;
    javax.swing.JButton historyButton;
    javax.swing.JLabel historyLabel;
    javax.swing.JPanel imagePanel;
    javax.swing.JList jListHistory;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JRadioButton monotoneChainRadioButton;
    javax.swing.JLabel numberOfPointsLabel;
    javax.swing.JTextField numberOfPointsTextField;
    javax.swing.JButton okButton;
    javax.swing.JButton quitButton;
    javax.swing.JLabel randomSeedLabel;
    javax.swing.JTextField randomSeedTextField;
    javax.swing.JButton restoreDefaultsButton;
    javax.swing.ButtonGroup selectAlgorithmButtonGroup;
    javax.swing.JLabel selectAlgorithmLabel;
    javax.swing.JTextField statusTextField;
    javax.swing.JLabel xMaxLabel;
    javax.swing.JTextField xMaxTextField;
    javax.swing.JLabel xMinLabel;
    javax.swing.JTextField xMinTextField;
    javax.swing.JLabel yMaxLabel;
    javax.swing.JTextField yMaxTextField;
    javax.swing.JLabel yMinLabel;
    javax.swing.JTextField yMinTextField;
    // End of variables declaration//GEN-END:variables
    private List<Point> convexHull;
    private Collection<Point> innerPoints;
    private int xMin;
    private int yMax;
    private double xFactor;
    private double yFactor;
    private final List<RandomPoints> history = new LinkedList<RandomPoints>();
    private Image currentImage;
    private JFileChooser fileChooser;
}
