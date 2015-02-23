package br.edu.ifce.postit.client.util;

import javax.swing.*;

import br.edu.ifce.postit.client.controller.PostitClientController;

public class JOptionPanelLoginInput {
   public static void main(String[] args) {
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Username:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15));
      myPanel.add(new JLabel("Password:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Informe o seu usário e senha", JOptionPane.OK_CANCEL_OPTION);
      PostitClientController.login(xField.getText(), yField.getText());

   }
}