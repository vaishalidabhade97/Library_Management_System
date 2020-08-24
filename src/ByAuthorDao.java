import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.*;
import java.sql.*;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class ByAuthorDao extends JFrame {
	static private JPanel contentPane;
	static ByAuthorDao frame=new ByAuthorDao();
@SuppressWarnings("deprecation")
public static int search(String author1){
     frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     frame.setVisible(true);
	frame.setBounds(100, 100, 800, 600);
	frame.contentPane = new PicPanel("images//library.jpg");
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	frame.add(contentPane);
	frame.setContentPane(contentPane);
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("Back");
	JMenuItem Exit=new JMenuItem("Back");
	menu.add(Exit);
	menubar.add(menu);
	frame.setJMenuBar(menubar);
	Exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		LibrarianSuccess.main(new String[]{});
		frame.dispose();
		}
	});
	int status=0;
	
	String data[][]=null;
	String column[]=null;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from books where author like '%"+author1+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=ps.executeQuery();
		
		ResultSetMetaData rsmd=rs.getMetaData();
		int cols=rsmd.getColumnCount();
		column=new String[cols];
		for(int i=1;i<=cols;i++){
			column[i-1]=rsmd.getColumnName(i);
		}
		
		rs.last();
		int rows=rs.getRow();
		rs.beforeFirst();

		data=new String[rows][cols];
		int count=0;
		while(rs.next()){
			status++;
			for(int i=1;i<=cols;i++){
				data[count][i-1]=rs.getString(i);
			}
			count++;
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	
	JTable table = new JTable(data,column);
	JScrollPane sp=new JScrollPane(table);
	contentPane.add(sp,BorderLayout.CENTER);
	return status;
}
}