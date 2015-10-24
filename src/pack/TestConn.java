package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConn {
	public static void main(String[] s){
		int d=0;
		String user="root";
		String pass="1234";
		String url="jdbc:mysql://localhost:3306/thuvien";
		Connection cnn=null;
		Statement st=null;
		String sql="select * from book";
		ResultSet res=null;
		try {
			cnn=DriverManager.getConnection(url, user, pass);
			st= cnn.createStatement();
			res=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(res.next()){
				d++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cnn==null);
		System.out.println(d);
		try {
			res.close();
			st.close();
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
