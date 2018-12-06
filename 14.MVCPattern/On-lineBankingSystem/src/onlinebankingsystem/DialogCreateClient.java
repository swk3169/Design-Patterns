package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogCreateClient extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtBirth;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private ClientDatabase clientDB;

	/**
	 * Launch the application.
	 */
	//
	/*
	 * depreciated public static void main(String[] args) { try {
	 * RegisterUserDialog dialog = new RegisterUserDialog();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogCreateClient(ClientDatabase clientDB)
	{
		init();
		this.clientDB = clientDB;
	}

	public void init()
	{
		setTitle("Register User");
		setBounds(100, 100, 304, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 13, 57, 15);
		contentPanel.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(126, 10, 150, 21);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Personal Number:");
		lblNewLabel.setBounds(12, 38, 116, 15);
		contentPanel.add(lblNewLabel);

		txtBirth = new JTextField();
		txtBirth.setBounds(126, 35, 150, 21);
		contentPanel.add(txtBirth);
		txtBirth.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(12, 63, 43, 15);
		contentPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(126, 60, 150, 21);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 88, 51, 15);
		contentPanel.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(126, 85, 150, 21);
		contentPanel.add(txtAddress);
		txtAddress.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String name = txtName.getText();
						String birth = txtBirth.getText();
						String email = txtEmail.getText();
						String address = txtAddress.getText();

						if (name.equals("") || birth.equals("") || email.equals("") || address.equals(""))
						{
							JOptionPane.showMessageDialog(null, "정보를 입력해주세요!");
						} else
						{
							Command createClient = new CreateClient(clientDB, name, birth, email, address);
							createClient.execute();
							JOptionPane.showMessageDialog(null, "회원이 등록되었습니다!");
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
