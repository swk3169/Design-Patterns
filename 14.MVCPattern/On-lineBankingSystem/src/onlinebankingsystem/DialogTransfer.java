package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogTransfer extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JTextField txtAccNumber;
	private JTextField txtRemarks;

	private AccountDatabase accountDB;
	private int account_number;
	private long amount;
	private boolean isOK = false;
	private String remarks;

	/**
	 * Launch the application.
	 */

	/*
	 * depreciated public static void main(String[] args) { try { DialogTransfer
	 * dialog = new DialogTransfer();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 */
	public DialogTransfer(JFrame parent, String title, AccountDatabase accountDB)
	{
		super(parent, title, true);
		setTitle("Transfer");

		init();

		this.accountDB = accountDB;
	}

	private void init()
	{
		setBounds(100, 100, 273, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAccountNumber = new JLabel("Account Number: ");
			lblAccountNumber.setBounds(12, 35, 112, 15);
			contentPanel.add(lblAccountNumber);
		}
		{
			JLabel lblAmount = new JLabel("Amount:");
			lblAmount.setBounds(12, 10, 57, 15);
			contentPanel.add(lblAmount);
		}
		{
			txtAmount = new JTextField();
			txtAmount.setBounds(124, 7, 116, 21);
			contentPanel.add(txtAmount);
			txtAmount.setColumns(10);
		}
		{
			txtAccNumber = new JTextField();
			txtAccNumber.setBounds(124, 32, 116, 21);
			contentPanel.add(txtAccNumber);
			txtAccNumber.setColumns(10);
		}
		{
			JLabel lblRemarks = new JLabel("Remarks:");
			lblRemarks.setBounds(12, 60, 57, 15);
			contentPanel.add(lblRemarks);
		}
		{
			txtRemarks = new JTextField();
			txtRemarks.setBounds(124, 57, 116, 21);
			contentPanel.add(txtRemarks);
			txtRemarks.setColumns(10);
		}
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
						String accNumber = txtAccNumber.getText();
						account_number = Integer.parseInt(accNumber);
						amount = Long.parseLong(txtAmount.getText());
						remarks = txtRemarks.getText();
						if (accountDB.checkAccount(account_number))
						{
							isOK = true;
							dispose();
						} else
						{
							JOptionPane.showMessageDialog(null, "존재하지 않는 계좌입니다!");
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

	public boolean isOK()
	{
		return isOK;
	}

	public long getAmount()
	{
		return amount;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public int getAccNumber()
	{
		return account_number;
	}
}
