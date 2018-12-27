import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class HexaInterface extends UserInterface {
	static JCheckBox checkBoxHex;
	JPanel buttonPanel;
	
	public HexaInterface(CalcEngine engine) {
		super(engine);
		
	}

	public void makeFrame() {
		super.makeFrame();
		JPanel contentPane = (JPanel) frame.getContentPane();
		buttonPanel = new JPanel(new GridLayout(6, 6));
		addButton(buttonPanel, "A");
		addButton(buttonPanel, "B");
		addButton(buttonPanel, "C");
		addButton(buttonPanel, "D");
		addButton(buttonPanel, "E");
		addButton(buttonPanel, "F");
		checkBoxHex = new JCheckBox("Hex", true);
		checkBoxHex.addActionListener(this);
		buttonPanel.add(checkBoxHex);
		contentPane.add(buttonPanel, BorderLayout.EAST);
		contentPane.add(checkBoxHex, BorderLayout.WEST);
		frame.pack();
		frame.setSize(460, 300);
	}
	
	public void actionPerformed(ActionEvent event) {
		super.actionPerformed(event);
		String command = event.getActionCommand();
		if (command.equals("A") || 
			command.equals("B") || 
			command.equals("C") || 
			command.equals("D") || 
			command.equals("E") || 
			command.equals("F")) {
		
			int number = Integer.parseInt(command,16);
			calc.numberPressed(number,true);
			
		}
		if (command.equals("Hex")) {
			if (checkBoxHex.isSelected()) {
				buttonPanel.setVisible(true);
			} else {
				buttonPanel.setVisible(false);
			}
		}
		

		redisplayHex();
	}
		
protected void redisplayHex()
		    {
		    	
		    	if (checkBoxHex.isSelected()) {
		    		int number = calc.getDisplayValue();
		    		String s=Integer.toHexString(number).toUpperCase();
		    		display.setText("" + s);	
				} else {
					display.setText("" + calc.getDisplayValue());	
				}

		

}
}
