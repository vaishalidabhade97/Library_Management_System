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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class SearchBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;
    static SearchBooks frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SearchBooks();
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
	public SearchBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new PicPanel("images//library.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel lblSearchSection = new JLabel("Search Section");
		lblSearchSection.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblSearchSection.setForeground(Color.BLACK);
		JMenuBar menubar=new JMenuBar();
		JMenu search=new JMenu("Search");
		JMenu back=new JMenu("Back");
		JMenuItem byauthor=new JMenuItem("By Author");
		JMenuItem bytitle=new JMenuItem("By Name");
		JMenuItem exit=new JMenuItem("Back");
		search.add(byauthor);
		search.add(bytitle);
		back.add(exit);
		menubar.add(search);
		menubar.add(back);
		setJMenuBar(menubar);
		byauthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SearchByAuthor.main(new String[]{});
			frame.dispose();
			}
		});
		bytitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			searchByTitle.main(new String[]{});
			frame.dispose();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(lblSearchSection)
					.addGap(54))
				
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(lblSearchSection))
					.addGap(18)
					
		);
		contentPane.setLayout(gl_contentPane);
		
	}

}