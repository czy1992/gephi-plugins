/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.gephi.desktop.streaming;

import org.gephi.streaming.server.StreamingServerConfig;
import org.netbeans.validation.api.builtin.Validators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.ValidationPanel;

/**
 *
 * @author panisson
 */
public class StreamingSettingsPanel extends javax.swing.JPanel {

    private StreamingServerConfig settings;

    /** Creates new form StreamingSettingsPanel */
    public StreamingSettingsPanel(StreamingServerConfig settings) {
        initComponents();
        this.settings = settings;
    }

     public static ValidationPanel createValidationPanel(final StreamingSettingsPanel innerPanel) {
        ValidationPanel validationPanel = new ValidationPanel();
        if (innerPanel == null) {
            throw new NullPointerException();
        }
        validationPanel.setInnerComponent(innerPanel);

        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(innerPanel.portTextField, Validators.REQUIRE_VALID_INTEGER);
        group.add(innerPanel.sslPortTextField, Validators.REQUIRE_VALID_INTEGER);

        return validationPanel;
     }

    public void setup() {
         int port = settings.getPort();
         this.portTextField.setText(port+"");

         // Basic Authentication
         boolean filterEnabled = settings.isBasicAuthentication();
         basicAuthCheckBox.setSelected(filterEnabled);
         usernameLabel.setEnabled(basicAuthCheckBox.isSelected());
         usernameTextField.setEnabled(basicAuthCheckBox.isSelected());
         passwordLabel.setEnabled(basicAuthCheckBox.isSelected());
         passwordField.setEnabled(basicAuthCheckBox.isSelected());
         usernameTextField.setText(settings.getUser());
         passwordField.setText(settings.getPassword());

         // SSL
         boolean sslEnabled = settings.isUseSSL();
         int sslPort = settings.getSslPort();
         sslCheckBox.setSelected(sslEnabled);
         sslPortLabel.setEnabled(sslCheckBox.isSelected());
         sslPortTextField.setEnabled(sslCheckBox.isSelected());
         sslPortTextField.setText(sslPort+"");
    }

    public void unsetup() {
        int port = Integer.valueOf(portTextField.getText());
        settings.setPort(port);

        settings.setBasicAuthentication(basicAuthCheckBox.isSelected());
        settings.setUser(usernameTextField.getText());
        settings.setPassword(new String(passwordField.getPassword()));

        settings.setUseSSL(sslCheckBox.isSelected());
        int sslPort = Integer.valueOf(sslPortTextField.getText());
        settings.setSslPort(sslPort);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        httpServerPanel = new javax.swing.JPanel();
        portLabel = new javax.swing.JLabel();
        basicAuthCheckBox = new javax.swing.JCheckBox();
        portTextField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        sslCheckBox = new javax.swing.JCheckBox();
        sslPortLabel = new javax.swing.JLabel();
        sslPortTextField = new javax.swing.JTextField();

        httpServerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.httpServerPanel.border.title"))); // NOI18N

        portLabel.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.portLabel.text")); // NOI18N

        basicAuthCheckBox.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.basicAuthCheckBox.text")); // NOI18N
        basicAuthCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                basicAuthCheckBoxStateChanged(evt);
            }
        });

        portTextField.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.portTextField.text")); // NOI18N

        usernameLabel.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.usernameLabel.text")); // NOI18N

        usernameTextField.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.usernameTextField.text")); // NOI18N

        passwordLabel.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.passwordLabel.text")); // NOI18N

        passwordField.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.passwordField.text")); // NOI18N

        sslCheckBox.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.sslCheckBox.text")); // NOI18N
        sslCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sslCheckBoxStateChanged(evt);
            }
        });

        sslPortLabel.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.sslPortLabel.text")); // NOI18N

        sslPortTextField.setText(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.sslPortTextField.text")); // NOI18N

        javax.swing.GroupLayout httpServerPanelLayout = new javax.swing.GroupLayout(httpServerPanel);
        httpServerPanel.setLayout(httpServerPanelLayout);
        httpServerPanelLayout.setHorizontalGroup(
            httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(httpServerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(httpServerPanelLayout.createSequentialGroup()
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(httpServerPanelLayout.createSequentialGroup()
                        .addComponent(sslCheckBox)
                        .addGap(39, 39, 39)
                        .addComponent(sslPortLabel)
                        .addGap(7, 7, 7)
                        .addComponent(sslPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(basicAuthCheckBox)
                    .addGroup(httpServerPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        httpServerPanelLayout.setVerticalGroup(
            httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(httpServerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(basicAuthCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(httpServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sslCheckBox)
                    .addComponent(sslPortLabel)
                    .addComponent(sslPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(httpServerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(httpServerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        httpServerPanel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(StreamingSettingsPanel.class, "StreamingSettingsPanel.jPanel1.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void sslCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sslCheckBoxStateChanged
         sslPortLabel.setEnabled(sslCheckBox.isSelected());
         sslPortTextField.setEnabled(sslCheckBox.isSelected());
    }//GEN-LAST:event_sslCheckBoxStateChanged

    private void basicAuthCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_basicAuthCheckBoxStateChanged
        usernameLabel.setEnabled(basicAuthCheckBox.isSelected());
        usernameTextField.setEnabled(basicAuthCheckBox.isSelected());
        passwordLabel.setEnabled(basicAuthCheckBox.isSelected());
        passwordField.setEnabled(basicAuthCheckBox.isSelected());
    }//GEN-LAST:event_basicAuthCheckBoxStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox basicAuthCheckBox;
    private javax.swing.JPanel httpServerPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JCheckBox sslCheckBox;
    private javax.swing.JLabel sslPortLabel;
    private javax.swing.JTextField sslPortTextField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}
