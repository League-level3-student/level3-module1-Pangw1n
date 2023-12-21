package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	HashMap<Integer, String> IDs;
	
	JFrame frame;
	JPanel panel;
	JButton AddButton;
	JButton SearchButton;
	JButton ViewButton;
	JButton RemoveButton;
	
	public static void main(String[] args) {
		new _02_LogSearch().run();
	}
	
	public void run()
	{
		IDs = new HashMap<Integer, String>();
		
		frame = new JFrame();
		panel = new JPanel();
		AddButton = new JButton();
		SearchButton = new JButton();
		ViewButton = new JButton();
		RemoveButton = new JButton();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(AddButton);
		panel.add(SearchButton);
		panel.add(ViewButton);
		panel.add(RemoveButton);
		
		AddButton.setText("Add ID");
		AddButton.addActionListener(this);
		SearchButton.setText("Search For ID");
		SearchButton.addActionListener(this);
		ViewButton.setText("View List");
		ViewButton.addActionListener(this);
		RemoveButton.setText("Remove ID");
		RemoveButton.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == AddButton)
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Add an ID"));
			String name = JOptionPane.showInputDialog("Enter a name");
			IDs.put(id, name);
			JOptionPane.showMessageDialog(null, "Added ID: " + id);
		}
		else if (buttonPressed == SearchButton)
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Search for an ID"));
			if (IDs.get(id) != null)
			{
				JOptionPane.showMessageDialog(null, "ID: " + id + "  Name: " + IDs.get(id));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID does not exist");
			}
		}
		else if (buttonPressed == ViewButton)
		{
			String list = "";
			for (int id : IDs.keySet())
			{
				list = list + "ID: " + id + "  Name: " + IDs.get(id) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		else if (buttonPressed == RemoveButton)
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Remove an ID"));
			if (IDs.get(id) != null)
			{
				IDs.remove(id);
				JOptionPane.showMessageDialog(null, "Removed ID: " + id);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID does not exist");
			}
		}
	}
}
