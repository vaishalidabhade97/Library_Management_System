import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library extends JFrame {
	static Library frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Library();
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
	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new PicPanel("images//library.jpg");
		//contentPane.add(new JLabel(new ImageIcon("//home//vaishali//Downloads//library.jpg")));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(new FlowLayout());
		JMenuBar menubar=new JMenuBar();
		JMenu file=new JMenu("Admin");
		JMenu file1=new JMenu("Librararian");
		JMenuItem adlog=new JMenuItem("Admin Login");
		JMenuItem liblog=new JMenuItem("Librarian Login");
		file.add(adlog);
		file1.add(liblog);
		menubar.add(file);
		menubar.add(file1);
		setJMenuBar(menubar);
		JLabel LibraryManagement = new JLabel("WELCOME TO DHOLE PATIL COLLEGE OF ENGINEERING");
		LibraryManagement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LibraryManagement.setForeground(Color.BLACK);
	    // add(LibraryManagement);
	     
		    // add(l1);
		JLabel lblLibraryManagement = new JLabel("LIBRARY MANAGEMENT");
		lblLibraryManagement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLibraryManagement.setForeground(Color.WHITE);
	     //add(lblLibraryManagement);
			adlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			frame.dispose();
			}
		});
		adlog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		liblog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianLogin.main(new String[]{});
			}
		});
		liblog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(LibraryManagement))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(250)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblLibraryManagement, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(LibraryManagement)
					.addGap(32)
					.addComponent(lblLibraryManagement, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
							);
		contentPane.setLayout(gl_contentPane);
	}
}
