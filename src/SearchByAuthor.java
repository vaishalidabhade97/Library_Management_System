import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class SearchByAuthor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
    static SearchByAuthor frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SearchByAuthor();
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
	public SearchByAuthor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel delete = new JLabel("Search By Author");
		delete.setFont(new Font("Tahoma", Font.PLAIN, 50));
		delete.setForeground(Color.GRAY);
		JLabel lblEnterId = new JLabel("Enter Author:");
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnterId.setForeground(Color.GRAY);
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Author=textField.getText();
				if(Author==null||Author.trim().equals("")){
					JOptionPane.showMessageDialog(SearchByAuthor.this,"Author can't be blank");
				}else{
					
					int i=ByAuthorDao.search(Author);
					System.out.println(i);
					if(i<=0)
						JOptionPane.showMessageDialog(SearchByAuthor.this,"Books not available");	
					
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(300)
								.addComponent(delete))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(200)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnterId)
						                .addComponent(btnSearch))
								.addGap(58)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
	      		               .addGap(70))
						);
			gl_contentPane.setVerticalGroup(
							gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(50)
									.addComponent(delete)
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEnterId)
											.addGap(18)
											.addComponent(btnSearch))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(18))
									);
		
		contentPane.setLayout(gl_contentPane);
	}

}
