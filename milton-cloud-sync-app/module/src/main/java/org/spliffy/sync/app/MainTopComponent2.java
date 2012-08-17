package org.spliffy.sync.app;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.ettrema.cloudsync//main//EN",autostore = false)
@TopComponent.Description(preferredID = "mainTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.spliffy.sync.MainTopComponent2")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "SpliffySync", preferredID = "mainTopComponent")
@Messages({
    "CTL_mainAction=main",
    "CTL_mainTopComponent=main Window",
    "HINT_mainTopComponent=This is a main window"
})
public final class MainTopComponent2 extends TopComponent {

    public MainTopComponent2() {
        System.out.println("--- STARTING SPLIFFY SYNC ---");

        try {
            initComponents();
            setName("SpliffySync");
            setToolTipText("SpliffySync");
            putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
            putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

            SyncFactory moduleFactory = SyncFactory.get();
            System.out.println("initialied: " + moduleFactory);
            moduleFactory.startAll();
        } catch (Exception e) {
//            JOptionPane.showInputDialog("Couldnt start: " + e.toString());
//            System.exit(9);
            e.printStackTrace();
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        pnlOuter = new javax.swing.JPanel();
        pnlInner = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        lblComment = new javax.swing.JLabel();
        lblHeading1 = new javax.swing.JLabel();
        lblHeading2 = new javax.swing.JLabel();
        lblTimeRemainingVal = new javax.swing.JLabel();
        lblCurrentVal = new javax.swing.JLabel();
        lblHeading3 = new javax.swing.JLabel();
        lblOverallProgressVal = new javax.swing.JLabel();
        lblUsageVal = new javax.swing.JLabel();
        lblHeading4 = new javax.swing.JLabel();
        lblHeading5 = new javax.swing.JLabel();
        progCurrent = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        pnlOuter.setBackground(new java.awt.Color(255, 255, 255));

        pnlInner.setBackground(new java.awt.Color(255, 255, 255));

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/spliffy/sync/app/tick.jpg"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblStatus, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblStatus.text_1")); // NOI18N

        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(127, 176, 50));
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading.text_1")); // NOI18N

        lblComment.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblComment, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblComment.text_1")); // NOI18N

        lblHeading1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeading1.setForeground(new java.awt.Color(127, 176, 50));
        lblHeading1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading1, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading1.text_1")); // NOI18N

        lblHeading2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeading2.setForeground(new java.awt.Color(127, 176, 50));
        lblHeading2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading2, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading2.text_1")); // NOI18N

        lblTimeRemainingVal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblTimeRemainingVal, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblTimeRemainingVal.text_1")); // NOI18N

        lblCurrentVal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblCurrentVal, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblCurrentVal.text_1")); // NOI18N

        lblHeading3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeading3.setForeground(new java.awt.Color(127, 176, 50));
        lblHeading3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading3, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading3.text_1")); // NOI18N

        lblOverallProgressVal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblOverallProgressVal, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblOverallProgressVal.text_1")); // NOI18N

        lblUsageVal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblUsageVal, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblUsageVal.text_1")); // NOI18N

        lblHeading4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeading4.setForeground(new java.awt.Color(127, 176, 50));
        lblHeading4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading4, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading4.text_1")); // NOI18N

        lblHeading5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeading5.setForeground(new java.awt.Color(127, 176, 50));
        lblHeading5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblHeading5, org.openide.util.NbBundle.getMessage(MainTopComponent2.class, "MainTopComponent2.lblHeading5.text_1")); // NOI18N

        javax.swing.GroupLayout pnlInnerLayout = new javax.swing.GroupLayout(pnlInner);
        pnlInner.setLayout(pnlInnerLayout);
        pnlInnerLayout.setHorizontalGroup(
            pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlInnerLayout.createSequentialGroup()
                .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addComponent(lblHeading5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(progCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlInnerLayout.createSequentialGroup()
                            .addComponent(lblHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTimeRemainingVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlInnerLayout.createSequentialGroup()
                            .addComponent(lblHeading2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCurrentVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addComponent(lblHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOverallProgressVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addComponent(lblHeading4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsageVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
        );
        pnlInnerLayout.setVerticalGroup(
            pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInnerLayout.createSequentialGroup()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimeRemainingVal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeading2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrentVal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOverallProgressVal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeading4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsageVal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHeading5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInnerLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(progCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(pnlInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInnerLayout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(143, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlOuterLayout = new javax.swing.GroupLayout(pnlOuter);
        pnlOuter.setLayout(pnlOuterLayout);
        pnlOuterLayout.setHorizontalGroup(
            pnlOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOuterLayout.setVerticalGroup(
            pnlOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlOuter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblCurrentVal;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblHeading1;
    private javax.swing.JLabel lblHeading2;
    private javax.swing.JLabel lblHeading3;
    private javax.swing.JLabel lblHeading4;
    private javax.swing.JLabel lblHeading5;
    private javax.swing.JLabel lblOverallProgressVal;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTimeRemainingVal;
    private javax.swing.JLabel lblUsageVal;
    private javax.swing.JPanel pnlInner;
    private javax.swing.JPanel pnlOuter;
    private javax.swing.JProgressBar progCurrent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    @Override
    public boolean canClose() {
        return false;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
