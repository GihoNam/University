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

	/* DB���� */
	public void DBconnect () {
		String url = "jdbc:mysql://localhost:3306/movie?serverTimezone=UTC";
		String username = "root";
		String passwd = "root"; //�ڽ��� �Է��� ���
		try {
			connection = DriverManager.getConnection(url , username, passwd);
			if(connection == null)
				System.out.println("����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����");
	}

	/* DB���� ���� */
	public void DBdisconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* DB ���� */
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

	/* DB ������� */
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

	/* DB ���� ���� */
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
			String sql = "select * from "+_name+"�¼�";
			Statement selectStatement = connection.createStatement();
			ResultSet rs = selectStatement.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getString("�¼���ȣ"));
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
