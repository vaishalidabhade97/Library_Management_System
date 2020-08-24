import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateLib extends JFrame {
	static UpdateLib frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateLib();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateLib() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUpdLibrarian = new JLabel(" Update Librarian Details    ");
		lblUpdLibrarian.setForeground(Color.BLACK);
		lblUpdLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		JLabel lblStudid = new JLabel("Student id:");
		lblStudid.setForeground(Color.WHITE);
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(Color.WHITE);
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setForeground(Color.WHITE);
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_0 = new JTextField();
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
            	int id1=Integer.parseInt(sid);
            	try{
            		Connection con=DB.getConnection();
            		Statement stmt = con.createStatement();

            	      String sql = "SELECT * FROM librarian where id like '%"+id1+"%'";
            	      ResultSet rs = stmt.executeQuery(sql);
            	      
            		//System.out.println(rs.next());
            		while(rs.next())
            		{
            			int n=rs.getInt("id");
              			System.out.println(n);
            		textField_0.setText(rs.getString("name"));
            		passwordField.setText(rs.getString("password"));
            		textField_1.setText(rs.getString("email"));
            		textField_2.setText(rs.getString("address"));
            		textField_3.setText(rs.getString("city"));
            		textField_4.setText(rs.getString("contact"));
            		}
            		con.close();
            	}catch(Exception e1){System.out.println(e1);}
			
            }
            		});
		btnShow.setForeground(Color.DARK_GRAY);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
			String name=textField_0.getText();
			String password=String.valueOf(passwordField.getPassword());
			String email=textField_1.getText();
			String address=textField_2.getText();
			String city=textField_3.getText();
			String contact=textField_4.getText();
            if(contact.length()==10)
            {
            	int id=Integer.parseInt(sid);
			int i=LibrarianDao.update(id,name, password, email, address, city, contact);
			System.out.println(i);
			if(i>0){
				JOptionPane.showMessageDialog(UpdateLib.this,"Librarian updated successfully!");
				AdminSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(UpdateLib.this,"Sorry, unable to update!");
			}
            }
            else
            {
            	textField.setText("");
            	passwordField.setText("");
            	textField_1.setText("");
            	textField_2.setText("");
            	textField_3.setText("");
            	textField_4.setText("");
            	JOptionPane.showMessageDialog(UpdateLib.this,"Enter valid contact number!");
            }
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(1)
								.addComponent(lblUpdLibrarian))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(250)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStudid, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(lblName)
										.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContactNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
								.addGap(1050)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addComponent(textField_0, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addComponent(passwordField)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
										.addComponent(btnShow, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
										.addComponent(btnBack,GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
				                    .addGap(70))
						);
			gl_contentPane.setVerticalGroup(
							gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(lblUpdLibrarian)
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStudid)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									    
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnShow))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblName)
											.addGap(18)
											.addComponent(lblPassword))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									    
										
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmail)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAddress)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCity)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblContactNo)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(28)
									
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton)
										.addGap(30)
										.addComponent(btnBack))
									.addGap(68))
									);
		contentPane.setLayout(gl_contentPane);
	}

}