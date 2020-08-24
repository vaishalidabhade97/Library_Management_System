import java.sql.*;

import javax.swing.JOptionPane;
public class LibrarianDao {

	
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			//ps.setInt(1, 1);
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		  }catch(Exception e){System.out.println(e);}
		  return status;
	   
		
	}
	public static int update(int id1,String name1,String password1,String email1,String address1,String city1,String contact1){
		int status=0;
		try{
			Connection con=DB.getConnection();
			String sql="update librarian set name=?, password=?, email=?, address=?, city=?, contact=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name1);
			ps.setString(2,password1);
			ps.setString(3,email1);
			ps.setString(4,address1);
			ps.setString(5,city1);
			ps.setString(6,contact1);
			ps.setInt(7, id1);
			status=ps.executeUpdate();
			con.close();
		  }catch(Exception e){System.out.println(e);}
		  return status;
	}
		
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
