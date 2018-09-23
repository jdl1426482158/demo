package interactive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlOperationDemo {

	/**
	 * ����ܳɹ��򿪣�����Tool �����ʧ��,����null
	 */
	private Connection conn;

	public MysqlOperationDemo(String IPAddress, String databaseName, String username, String password)
			throws ClassNotFoundException, SQLException {
//		Process p = Runtime.getRuntime().exec("sc query mysql57");
		//�����������Կ�������
		// �°���������������
		Class.forName("com.mysql.jdbc.Driver");
		// �������ݿ�
		conn = DriverManager.getConnection("jdbc:mysql://" + IPAddress + ":3306/" + databaseName, username, password);
	}

	/**
	 * ���ǲ����õĹ��췽��
	 */
	public MysqlOperationDemo() throws ClassNotFoundException, SQLException {
		this("localhost", "test", "root", "root");
	}

	/**
	 * read������query
	 */
	public String executeQuery(String queryStatement) {
		try {
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(queryStatement);

			rs.last();
			int rowNum = rs.getRow();

			ResultSetMetaData rsmd1 = rs.getMetaData();
			int colNum = rsmd1.getColumnCount();

			String msg = "";
			int i, j;
			rs.beforeFirst();
			for (i = 1; i <= rowNum; i++) {
				rs.next();
				for (j = 1; j <= colNum; j++) {
					msg = msg + rs.getString(j) + "\t";
				}
				msg = msg + "\n";
			}
			sm.close();
			rs.close();
			return msg;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * write������query
	 */
	public int executeUpdate(String updateStatement) {
		try {
			Statement sm = conn.createStatement();
			int l = sm.executeUpdate(updateStatement);
			sm.close();
			return l;
		} catch (SQLException e) {
			return -1;
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MysqlOperationDemo tool = new MysqlOperationDemo();
		System.out.println(tool.executeUpdate("update student set name='Aberdeen' where id=11410002"));
		System.out.print(tool.executeQuery("select * from student"));
		System.out.println(tool.executeUpdate("update student set name='Alice' where id=11410002"));
		System.out.print(tool.executeQuery("select * from student"));
		tool.close();
	}
}
