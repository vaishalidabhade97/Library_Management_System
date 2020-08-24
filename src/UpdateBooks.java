import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.LayoutStyle.ComponentPlacement;

public class UpdateBooks extends JFrame {
	static UpdateBooks frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateBooks();
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
	public UpdateBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddBooks = new JLabel("Update Book Details");
		lblAddBooks.setForeground(Color.WHITE);
		lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel lblid = new JLabel("Book id:");
		lblid.setForeground(Color.WHITE);
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setForeground(Color.WHITE);
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(Color.WHITE);
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setForeground(Color.WHITE);
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.WHITE);
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
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
            	int id1=Integer.parseInt(sid);
            	try{
            		Connection con=DB.getConnection();
            		Statement stmt = con.createStatement();

            	      String sql = "SELECT * FROM books where id like '%"+id1+"%'";
            	      ResultSet rs = stmt.executeQuery(sql);
            	      
            		//System.out.println(rs.next());
            		while(rs.next())
            		{
            			int n=rs.getInt("id");
              			System.out.println(n);
            		textField_0.setText(rs.getString("callno"));
            		textField_1.setText(rs.getString("name"));
            		textField_2.setText(rs.getString("author"));
            		textField_3.setText(rs.getString("publisher"));
            		textField_4.setText(rs.getString("quantity"));
            		
            		}
            		con.close();
            	}catch(Exception e1){System.out.println(e1);}
			
            }
            		});
		btnShow.setForeground(Color.DARK_GRAY);
		
		JButton btnAddBooks = new JButton("Update");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
			String callno=textField_0.getText();
			String name=textField_1.getText();
			String author=textField_2.getText();
			String publisher=textField_3.getText();
			String squantity=textField_4.getText();
			int quantity=Integer.parseInt(squantity);
			int id=Integer.parseInt(sid);
			int i=BookDao.update(id,callno, name, author, publisher, quantity);
			System.out.println(i);
			if(i>0){
				JOptionPane.showMessageDialog(UpdateBooks.this,"Books updated successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(UpdateBooks.this,"Sorry, unable to update!");
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			LibrarianSuccess.main(new String[]{});
			frame.dispose();
		}
		});
		
		
		GroupLayout gl_contentPane= new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
							.addGroup(gl_contentPane.createSequentialGroup()
								
								.addComponent(lblAddBooks))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(250)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblid)
										.addComponent(lblCallNo, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(lblName)
										.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPublisher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
								.addGap(900)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addComponent(textField_0, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
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
									.addGap(48)
									.addComponent(lblAddBooks)
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblid)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnShow))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCallNo)
											.addGap(18)
											.addComponent(lblName))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAuthor)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPublisher)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblQuantity)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAddBooks)
										.addGap(30)
										.addComponent(btnBack))
									.addGap(68))
									);
		
		contentPane.setLayout(gl_contentPane);
	}

}
