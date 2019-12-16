package gui_finaltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DB {
	
		
	Connection connection = null;

	/* DB연결 */
	public void DBconnect () {
		String url = "jdbc:mysql://localhost:3306/movie?serverTimezone=UTC";
		String username = "root";
		String passwd = "root"; //자신이 입력한 비번
		try {
			connection = DriverManager.getConnection(url , username, passwd);
			if(connection == null)
				System.out.println("실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("성공");
	}

	/* DB연결 해제 */
	public void DBdisconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* DB 삽입 */
	public void insertContents(int _age, String _name) {
		DBconnect();
		try {
			String sql = "insert into test values(?,?)";
			PreparedStatement addStatement = connection.prepareStatement(sql);
			
			addStatement.setInt(1, _age);
			addStatement.setString(2, _name);
			
			addStatement.executeUpdate();
			addStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBdisconnect();
	}

	/* DB 내용삭제 */
	public void deleteContentes() {
		DBconnect();
		try {
			String sql = "delete from test where id=";
			PreparedStatement deleteStatement = connection.prepareStatement(sql);
			deleteStatement.executeUpdate();
			deleteStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* DB 내용 수정 */
	public void updateElement(int _age, String _name) {
		DBconnect();
		try {

			String sql = "update test set age = ?, name=? where name =";
			PreparedStatement upStatement= connection.prepareStatement(sql);
			upStatement.setInt(1,_age);
			upStatement.setString(2,_name);
			upStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBdisconnect();
	}
	
	public ArrayList selectContents(String _name) {
		DBconnect();
		ArrayList list = new ArrayList();
		try {
			String sql = "select * from "+_name+"좌석";
			Statement selectStatement = connection.createStatement();
			ResultSet rs = selectStatement.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getString("좌석번호"));
			}
			
			selectStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBdisconnect();
		return list;
	}

}
