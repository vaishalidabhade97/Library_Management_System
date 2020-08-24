import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianSuccess extends JFrame {
	static LibrarianSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianSuccess();
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
	public LibrarianSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JMenuBar menubar=new JMenuBar();
		JMenu add=new JMenu(" Add ");
		JMenu view=new JMenu(" View ");
		JMenu search=new JMenu(" Search ");
		JMenu iss=new JMenu(" Issue ");
		JMenu viss=new JMenu(" View_Issue ");
		JMenu ret=new JMenu(" Return ");
		JMenu upd=new JMenu(" Update ");
		JMenu log=new JMenu(" Logout ");
		JMenuItem adbook=new JMenuItem("Add Books");
		JMenuItem viewbook=new JMenuItem("View Books");
		JMenuItem searchbook=new JMenuItem("Search Books");
		JMenuItem issbook=new JMenuItem("Issue Book");
		JMenuItem vissbook=new JMenuItem("View Issue Book");
		JMenuItem retbook=new JMenuItem("Return Book");
		JMenuItem updbook=new JMenuItem("Update Book");
		JMenuItem logout=new JMenuItem("Logout");
		add.add(adbook);
		view.add(viewbook);
		search.add(searchbook);
		iss.add(issbook);
		viss.add(vissbook);
		ret.add(retbook);
		upd.add(updbook);
		log.add(logout);
		menubar.add(add);
		menubar.add(view);
		menubar.add(search);
		menubar.add(iss);
		menubar.add(viss);
		menubar.add(ret);
		menubar.add(upd);
		menubar.add(log);
		setJMenuBar(menubar);
		
			
		JLabel lblLibSection = new JLabel("Librarian Section");
		lblLibSection.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblLibSection.setForeground(Color.BLACK);
		//add(lblAdminSection);
		
		
		adbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		adbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		viewbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewBooks.main(new String[]{});
			frame.dispose();
			}
		});
		viewbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		searchbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			SearchBooks.main(new String[]{});
			frame.dispose();
			}
		});
		searchbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		issbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IssueBookForm.main(new String[]{});
			frame.dispose();
			}
		});
		issbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vissbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewIssuedBooks.main(new String[]{});
			frame.dispose();
			}
		});
		vissbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		retbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
	    retbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    
	    updbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateBooks.main(new String[]{});
				frame.dispose();
			}
		});
	    updbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
				logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
	    logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(lblLibSection)
					.addGap(54))
				
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(lblLibSection))
					.addGap(18)
					
		);
		contentPane.setLayout(gl_contentPane);
	}

}
