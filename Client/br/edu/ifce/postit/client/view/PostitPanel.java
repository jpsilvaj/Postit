package br.edu.ifce.postit.client.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class PostitPanel extends JPanel{

	/**
	 * TODO:Not implemented
	 */
	private static final long serialVersionUID = -4030816348444626229L;
	
	JScrollPane historyMessageScrolledPane;
	private JTextArea historyMessage;
	JPanel sendMessagePanel;
	private JTextField textBox;

	public PostitPanel(){
		this.configureChat();
	}

	private void configureChat(){
		historyMessage = new JTextArea(35,90);
		historyMessage.setEditable(false);
		historyMessage.setLineWrap(true);
		historyMessage.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		historyMessageScrolledPane = new JScrollPane(historyMessage);
		historyMessageScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		historyMessageScrolledPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
		
		textBox = new JTextField(80);
		textBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		textBox.setActionCommand("send_message");
		textBox.addActionListener(new ChatListener());
		
		JButton send = new JButton("Send");
		send.setActionCommand("send_message");
		send.addActionListener(new ChatListener());
		
		sendMessagePanel = new JPanel();
		sendMessagePanel.setLayout(new FlowLayout());
		sendMessagePanel.add(textBox);
		sendMessagePanel.add(send);
	
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(historyMessageScrolledPane);
		this.add(sendMessagePanel);
		this.setVisible(true);
		
	}

	public JTextArea getHistoryMessage() {
		return historyMessage;
	}

	public void setHistoryMessage(JTextArea historyMessage) {
		this.historyMessage = historyMessage;
	}
	
	public JTextField getTextBox() {
		return textBox;
	}

	public void setTextBox(JTextField textBox) {
		this.textBox = textBox;
	}

}