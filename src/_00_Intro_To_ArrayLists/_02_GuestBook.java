package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton AddName = new JButton();
	JButton ViewNames = new JButton();
	
	ArrayList<String> Guests = new ArrayList<String>();
	
	public static void main(String[] args) {
		new _02_GuestBook().run();
	}
	
	void run()
	{
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(AddName);
		panel.add(ViewNames);
		
		AddName.addActionListener(this);
		AddName.setText("Add Name");
		ViewNames.addActionListener(this);
		ViewNames.setText("View Names");
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == AddName)
		{
			String name = JOptionPane.showInputDialog("Add A Name:");
			Guests.add(name);
		}
		else if (arg0.getSource() == ViewNames)
		{
			String Message = "Guests: \n";
			for (int i = 0; i < Guests.size(); i ++)
			{
				Message = Message + "Guest #" + i + ": " + Guests.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, Message);
		}
	}
}
