import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.*;
import java.sql.*;

public class BookDao {
@SuppressWarnings("deprecation")
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	
	
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity,issued) values(?,?,?,?,?,?)");
		//ps.setInt(1,9);
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
		ps.setInt(6,0);
		//ps.setString(7,"2018-07-07");
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int update(int id1,String callno1,String name1,String author1,String publisher1,int quantity1){
	int status=0;
	
	
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("update books set callno=?,name=?,author=?,publisher=?,quantity=? where id=?");
		//ps.setInt(1,9);
		ps.setString(1,callno1);
		ps.setString(2,name1);
		ps.setString(3,author1);
		ps.setString(4,publisher1);
		ps.setInt(5,quantity1);
		ps.setInt(6,id1);
		//ps.setString(7,"2018-07-07");
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
