package start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
	
	private JPanel textFrame;
	private JPanel buttonFrame;
	
	private JTextArea message;
	private ArrayList<String> lines = new ArrayList<String>();
	
	private JButton[] buttons = new JButton[2];
	
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		
		Container mainFrame = getContentPane();
		mainFrame.setLayout(new GridLayout(2,1));
		
		textFrame = new JPanel();
		textFrame.setBackground(Color.BLACK);
		mainFrame.add(textFrame);
		buttonFrame = new JPanel();
		mainFrame.add(buttonFrame);
		
		message = new JTextArea();
		message.setBackground(Color.BLACK);
		message.setForeground(Color.WHITE);
		message.setEditable(false);
		textFrame.add(message);
		
		buttons[0] = new JButton("hoi");
		buttons[1] = new JButton("hoi2");
		
		buttons[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BUTTON ACTIVATED OMYGAAHHHT");
				
			}
		});
		
		buttonFrame.add(buttons[0]);
		buttonFrame.add(buttons[1]);
		
		setVisible(true);
	}
	
	public void changeMessage(String msg){
		if (lines.size() > 6) {
			lines.remove(0);
		}
		lines.add(msg);
		
		String output = "";
		
		for(String line : lines){
			output = output +line + "\n";			
		}
		
		message.setText(output);
		System.out.println(output);
	}
	
	
	// TODO Misschien veranderen
	public void changeButtons(String button1, String button2){
		buttons[0].setText(button1);
		buttons[1].setText(button2);
	}

}
