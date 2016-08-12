package GUISync;

import io.milton.event.EventManager;
import io.milton.event.EventManagerImpl;
import io.milton.sync.SpliffySync;
import io.milton.sync.SyncCommand;
import io.milton.sync.SyncJob;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ibraheem
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    DefaultListModel model;
    final static String JOB = "job";
    final static String sDbFile = "~/syncdb";
    static File file;
    static Properties jobFile;
    int sizeJobs;

    public MainPage() {
        initComponents();
        setLocationRelativeTo(null);

        file = new File("ksync.properties");
        jobFile = new Properties();
        if (!file.exists()) {

            createBlankFile(file);
        } else {
            loadProperties(jobFile);;
        }

        model = new DefaultListModel();
        list_Jobs.setModel(model);

        list_Jobs.setCellRenderer(new JObCellRenderer());

        updateJobList(readObject());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Jobs = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kademi Tool");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sync Jobs ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        list_Jobs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        list_Jobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_Jobs.setAutoscrolls(false);
        jScrollPane1.setViewportView(list_Jobs);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.white));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Delete");
        jButton3.setBorder(null);
        jButton3.setInheritsPopupMenu(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-dark.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        model.add(0, "job \n " + "des");
        java.awt.EventQueue.invokeLater(() -> {
            display();
        });

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = list_Jobs.getSelectedIndex();
        System.out.println(" index getSelectedIndex " + index);
        java.awt.EventQueue.invokeLater(() -> {
            if (index != -1) {
                displaUpdate(index);
            }
        });


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.out.println(" list_Jobs.getSelectedIndex()" + list_Jobs.getSelectedIndex());

        int index = list_Jobs.getSelectedIndex();
        int i = 0;

        if (model.getSize() <= 1) {
            rProperty(i, "localPath");
            rProperty(i, "remoteAddress");
            rProperty(i, "repositry");
            rProperty(i, "branch");
            rProperty(i, "user");
            rProperty(i, "password");
            rProperty(i, "LocalReadonly");
        } else {

            for (i = index; i < model.getSize() - 1; i++) {
                rwProperty(i, "localPath");
                rwProperty(i, "remoteAddress");
                rwProperty(i, "repositry");
                rwProperty(i, "branch");
                rwProperty(i, "user");
                rwProperty(i, "password");
                rwProperty(i, "LocalReadonly");

            }
            rProperty(i, "localPath");
            rProperty(i, "remoteAddress");
            rProperty(i, "repositry");
            rProperty(i, "branch");
            rProperty(i, "user");
            rProperty(i, "password");
            rProperty(i, "LocalReadonly");
        }

        sizeJobs = Integer.parseInt(jobFile.getProperty("sizeJobs", "0"));
        wProperty(-1, "sizeJobs", String.valueOf(Integer.parseInt(jobFile.getProperty("sizeJobs", "0")) - 1));
        saveProperties(jobFile);
        loadProperties(jobFile);
        model.remove(index);

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> list_Jobs;
    // End of variables declaration//GEN-END:variables

    private void display() {

        addJob panel = new addJob(Integer.parseInt(jobFile.getProperty("sizeJobs", "0")));

        int result = JOptionPane.showConfirmDialog(list_Jobs, panel, "Add Job Sync",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("addjob");
            SyncJob job = panel.doAddJob();

            if (job != null) {

                model.addElement(new JobModel(job.getLocalDir().getAbsolutePath(), job.getRemoteAddress()));
                saveProperties(jobFile);
                loadProperties(jobFile);
            }

        } else {
            System.out.println("Cancelled");
        }

    }

    private void displaUpdate(int index) {

        updateJob panel = new updateJob(index);

        int result = JOptionPane.showConfirmDialog(list_Jobs, panel, "Update Job Sync",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            SyncJob job = panel.doUpdateJob();

            if (job != null) {

                model.set(index, new JobModel(job.getLocalDir().getAbsoluteFile().toString(), job.getRemoteAddress()));
                saveProperties(jobFile);
                loadProperties(jobFile);

            }

        } else {
            System.out.println("Cancelled");
        }

    }

    public class JobModel {

        private final String local, remote;
        URL imagePath;
        private ImageIcon image;

        public JobModel(String local, URL imagePath, String remote) {
            this.local = local;
            this.imagePath = imagePath;
            this.remote = remote;
        }

        public JobModel(String local, String remote) {
            this.local = local;
            this.remote = remote;

            imagePath = getClass().getResource("/Images/upload.png");
        }

        public String getLocal() {
            return local;
        }

        public URL getImagePath() {
            return imagePath;
        }

        public String getRemote() {
            return remote;
        }

        public ImageIcon getImage() {
            if (image == null) {
                image = new ImageIcon(imagePath);
            }
            return image;
        }

        // Override standard toString method to give a useful result
    }

    class JObCellRenderer extends JLabel implements ListCellRenderer {

        private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
        Object value;

        public JObCellRenderer() {
            setOpaque(true);
            setIconTextGap(20);
            setFont(new java.awt.Font("Arial", 0, 13));

        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {

            JobModel entry = (JobModel) value;
            setSize(list.getWidth(), 12);
            setToolTipText("Remote host: " + entry.getRemote());
            setText(entry.getLocal());
            setIcon(entry.getImage());

            if (isSelected) {
                setBackground(HIGHLIGHT_COLOR);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            return this;
        }
    }

    public ArrayList<SyncJob> readObject() {

        String localPathProperty = null, repositryProperty = null, branchProperty = null, userProperty = null, passwordProperty = null, LocalReadonlyProperty = null, remoteAddressProperty = null;
        ArrayList<SyncJob> jobs = new ArrayList();

        for (int num = 0; num < sizeJobs; num++) {
            SyncJob job = new SyncJob();
            localPathProperty = jobFile.getProperty(JOB + "." + num + "." + "localPath");
            if (localPathProperty == null) {
                break;
            }

            repositryProperty = jobFile.getProperty(JOB + "." + num + "." + "repositry");
            branchProperty = jobFile.getProperty(JOB + "." + num + "." + "branch");
            userProperty = jobFile.getProperty(JOB + "." + num + "." + "user");
            passwordProperty = jobFile.getProperty(JOB + "." + num + "." + "password");
            LocalReadonlyProperty = jobFile.getProperty(JOB + "." + num + "." + "LocalReadonly");
            remoteAddressProperty = jobFile.getProperty(JOB + "." + num + "." + "remoteAddress");
            job.setLocalDir(new File(localPathProperty));
            job.setLocalReadonly(Boolean.valueOf(LocalReadonlyProperty));
            job.setPwd(passwordProperty);
            job.setUser(userProperty);

            String q_host = remoteAddressProperty + "repositories/" + repositryProperty + "/" + branchProperty + "/";
            job.setRemoteAddress(q_host);
            jobs.add(job);
        }

        return jobs;
    }

    void updateJobList(ArrayList<SyncJob> jobs) {
        if (!jobs.isEmpty() && jobs != null) {

            EventManager eventManager = new EventManagerImpl();
            try {
                SyncCommand.start(new File(sDbFile), jobs, eventManager);
            } catch (Exception ex) {
                System.out.println(" ex " + ex.getMessage());
            }

            jobs.stream().forEach((job) -> {

                model.addElement(new JobModel(job.getLocalDir().getAbsoluteFile().toString(), job.getRemoteAddress()));
            });
        }

    }

    void loadProperties(Properties p) {
        FileInputStream fi;
        try {
            fi = new FileInputStream(file);
            p.load(fi);
            fi.close();
            sizeJobs = Integer.parseInt(jobFile.getProperty("sizeJobs", "0"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(updateJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(updateJob.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("After Loading properties:" + p);
    }

    private static void createBlankFile(File f) {
        try {
            FileOutputStream fout = new FileOutputStream(f);

            byte[] b = "".getBytes();
            fout.write(b);
            fout.close();
        } catch (Throwable e) {
            e
                    = e;
            System.out.println("Couldnt create empty properties file, not big deal");
        } finally {
        }
    }

    static void wProperty(int index, String Property, String value) {
        if ("sizeJobs".equals(Property)) {
            jobFile.setProperty(Property, value);
        } else {
            jobFile.setProperty(JOB + "." + index + "." + Property, value);
        }

    }

    static void rwProperty(int index, String Property) {
        jobFile.setProperty(JOB + "." + index + "." + Property, jobFile.getProperty(JOB + "." + (index + 1) + "." + Property));

    }

    void rProperty(int index, String Property) {

        jobFile.remove(JOB + "." + index + "." + Property);

    }

    void saveProperties(Properties p) {
        FileOutputStream fr;
        try {
            fr = new FileOutputStream(file);
            p.store(fr, "Properties");
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(addJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addJob.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("After saving properties:" + p);
    }

}
