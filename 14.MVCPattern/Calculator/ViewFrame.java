package CalculatorMVCPattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFrame extends JFrame implements ActionListener, Observer
{
	private JPanel panel;
	private JTextField resultTextField;
	private ControllerInterface controller;
	private Subject model;
	private JTextField numATextField, numBTextField;
	private JButton plusBtn;
	private JButton minusBtn;
	private JLabel operatorLabel;

	public ViewFrame(ControllerInterface controller, Subject model)
	{
		this.controller = controller;
		this.model = model;

		init();
		run();
		setVisible(true);

		model.registerObserver(this);
	}

	private void init()
	{
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 300, 110);

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		setContentPane(panel);
		JPanel expressionPanel = new JPanel();
		panel.add(expressionPanel);
		expressionPanel.setLayout(new FlowLayout());

		JPanel operationPanel = new JPanel();
		panel.add(operationPanel);

		plusBtn = new JButton("+");
		operationPanel.add(plusBtn);

		minusBtn = new JButton("-");
		operationPanel.add(minusBtn);

		resultTextField = new JTextField(Integer.toString(model.getValue()));
		resultTextField.setColumns(5);
		resultTextField.setEditable(false);

		numATextField = new JTextField();
		numBTextField = new JTextField();

		operatorLabel = new JLabel(" ? ");
		JLabel label2 = new JLabel(" = ");

		expressionPanel.add(numATextField);
		numATextField.setColumns(5);
		expressionPanel.add(operatorLabel);
		expressionPanel.add(numBTextField);
		numBTextField.setColumns(5);
		expressionPanel.add(label2);
		expressionPanel.add(resultTextField);
	}

	private void run()
	{
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (plusBtn == e.getSource())
		{
			try
			{
				int numA = Integer.parseInt(numATextField.getText());
				int numB = Integer.parseInt(numBTextField.getText());
				operatorLabel.setText(" + ");
				controller.push(numA + numB);
			} 
			catch (NumberFormatException err)
			{
				JOptionPane.showMessageDialog(null, "Wrong Input!!");
			} 
			catch (Exception err)
			{
				JOptionPane.showMessageDialog(null, "Unknown Error!!");
			}
		}

		if (minusBtn == e.getSource())
		{
			try
			{
				int numA = Integer.parseInt(numATextField.getText());
				int numB = Integer.parseInt(numBTextField.getText());
				operatorLabel.setText(" - ");
				controller.push(numA - numB);
			} 
			catch (NumberFormatException err)
			{
				JOptionPane.showMessageDialog(null, "Wrong Input!!");
			} 
			catch (Exception err)
			{
				JOptionPane.showMessageDialog(null, "Unknown Error!!");
			}
		}
	}

	public void update(int value)
	{
		resultTextField.setText(Integer.toString(value));
	}
}