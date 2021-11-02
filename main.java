//Joseph Anthony Caruso
//Program that converts numbers into different bases
//For example base 10 to binary



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Frame;

public class main
{
	public static void main (String[] args)
	{
		new MyFrameClass();
	}
}

class MyFrameClass extends JFrame implements ActionListener, ChangeListener, DocumentListener
{
	JButton exitButton;
	JLabel inputLabel;
	JSpinner countSpin;
	JTextField inputField;
	JTextField outputField;
	int spinnerNum;

	MyFrameClass()
	{
		inputField = new JTextField(10);
		inputField.getDocument().addDocumentListener(this);

		outputField = new JTextField(10);
		outputField.setEditable(false);

		inputLabel = new JLabel("Input");

		JPanel myPanel;


		exitButton = new JButton("Exit");

		exitButton.setActionCommand ("EXIT");
		exitButton.addActionListener(this);

		countSpin = new JSpinner(new SpinnerNumberModel(5, 2, 20, 1));
		countSpin.addChangeListener(this);

		getRootPane().setDefaultButton(exitButton);

		myPanel = new JPanel(new FlowLayout());
		myPanel.add(inputLabel);
		myPanel.add(inputField);
		myPanel.add(countSpin);
		myPanel.add(outputField);
		myPanel.add(exitButton);
		myPanel.setBackground(Color.cyan);

		add(myPanel, BorderLayout.CENTER);

		setMainFrame();
	}

	void setMainFrame()
	{
		Toolkit tk;
		Dimension d;

		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		setSize(d.width/3, d.height/3);
		setLocation(d.width/3, d.height/3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Project One");

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("EXIT"))
		{
			System.exit(1);
		}
	}

	public void stateChanged(ChangeEvent e)
	{
		spinnerNum = (Integer) countSpin.getValue();

		int i = 0;
		try
		{
			i = Integer.parseInt(inputField.getText());
		}
		catch(NumberFormatException a)
		{
			if(i == 0)
			{
				outputField.setText("");
			}
			else
			{
				outputField.setText("Error");
			}
		}

		String textField = String.valueOf(i);
		if(i != 0)
		{
			outputField.setText(Integer.toString(i, (Integer)countSpin.getValue()));
		}

	}

	public void changedUpdate(DocumentEvent e)
	{
		int i = 0;
		try
		{
			i = Integer.parseInt(inputField.getText());
		}
		catch(NumberFormatException a)
		{
			outputField.setText("Error");
		}

		String textField = String.valueOf(i);
		if(i != 0)
		{
			outputField.setText(Integer.toString(i, (Integer)countSpin.getValue()));
		}
	}

	public void insertUpdate(DocumentEvent e)
	{
		int i = 0;
		try
		{
			i = Integer.parseInt(inputField.getText());
		}
		catch(NumberFormatException a)
		{
			outputField.setText("Error");
		}

		String textField = String.valueOf(i);
		if(i != 0)
		{
			outputField.setText(Integer.toString(i, (Integer)countSpin.getValue()));
		}
	}

	public void removeUpdate(DocumentEvent e)
	{
		int i = 0;
		try
		{
			i = Integer.parseInt(inputField.getText());
		}
		catch(NumberFormatException a)
		{
			if(i == 0)
			{
				outputField.setText("");
			}
			else
			{
				outputField.setText("Error");
			}
		}

		String textField = String.valueOf(i);
		if(i != 0)
		{
			outputField.setText(Integer.toString(i, (Integer)countSpin.getValue()));
		}
	}
}


