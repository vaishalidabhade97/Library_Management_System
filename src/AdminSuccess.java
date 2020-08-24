import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.sql.*;
public class AdminSuccess extends JFrame {
	static AdminSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSuccess();
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
	public AdminSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//setContentPane(new JLabel(new ImageIcon("//home//vaishali//Downloads//library.jpg")));
		setLayout(new FlowLayout());
		JMenuBar menubar=new JMenuBar();
		JMenu add=new JMenu(" Add ");
		JMenu view=new JMenu(" View ");
		JMenu del=new JMenu(" Delete ");
		JMenu upd=new JMenu(" Update ");
		JMenu log=new JMenu(" Logout ");
		JMenuItem adlib=new JMenuItem("Add Librarian");
		JMenuItem viewlib=new JMenuItem("View Librarian");
		JMenuItem dellib=new JMenuItem("Delete Librarian");
		JMenuItem updlib=new JMenuItem("Update Librarian");
		JMenuItem logout=new JMenuItem("Logout");
		add.add(adlib);
		view.add(viewlib);
		del.add(dellib);
		upd.add(updlib);
		log.add(logout);
		menubar.add(add);
		menubar.add(view);
		menubar.add(del);
		menubar.add(upd);
		menubar.add(log);
		setJMenuBar(menubar);
		
			
		JLabel lblAdminSection = new JLabel("Admin Section");
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblAdminSection.setForeground(Color.GRAY);
		//add(lblAdminSection);
		
		
		adlib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		
		viewlib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewLibrarian.main(new String[]{});
			frame.dispose();
			}
		});
		viewlib.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dellib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteLibrarian.main(new String[]{});
			frame.dispose();
			}
		});
		dellib.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		updlib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UpdateLib.main(new String[]{});
			frame.dispose();
			}
		});
		updlib.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
				logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(300)
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
					
		);
		contentPane.setLayout(gl_contentPane);
	}
}
