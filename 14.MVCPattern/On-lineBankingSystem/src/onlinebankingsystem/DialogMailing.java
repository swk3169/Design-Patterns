package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogMailing extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitle;
	private JTextArea txtContent;
	private ClientDatabase clientDB;

	/**
	 * Launch the application.
	 */
	/*
	 * depreciated public static void main(String[] args) { try { DialogMailing
	 * dialog = new DialogMailing();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogMailing(JFrame parent, String title, ClientDatabase clientDB)
	{
		init();

		this.clientDB = clientDB;
	}

	private void init()
	{
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 10, 57, 15);
		contentPanel.add(lblTitle);

		txtTitle = new JTextField();
		txtTitle.setBounds(81, 7, 341, 21);
		contentPanel.add(txtTitle);
		txtTitle.setColumns(10);

		JLabel lblContents = new JLabel("Content:");
		lblContents.setBounds(12, 35, 57, 15);
		contentPanel.add(lblContents);

		txtContent = new JTextArea();
		txtContent.setBounds(81, 32, 341, 186);
		contentPanel.add(txtContent);
		txtContent.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPromote = new JButton("Promote");
				btnPromote.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						String subject = txtTitle.getText();
						String content = txtContent.getText();
						Command mailClient = new MailClient(clientDB, subject, content);
						mailClient.excute();
						dispose();
					}
				});
				btnPromote.setActionCommand("OK");
				buttonPane.add(btnPromote);
				getRootPane().setDefaultButton(btnPromote);
			}
			{
				JButton btnCancle = new JButton("Cancel");
				btnCancle.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				btnCancle.setActionCommand("Cancel");
				buttonPane.add(btnCancle);
			}
		}
	}
}
