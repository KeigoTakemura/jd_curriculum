import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
	public static void main(String[] args) {
		final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
		final String USER_NAME = "keigo";
		final String USER_PASS = "Jdpass123";
		
		String sql = "SELECT * FROM student";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.print("id: " + rs.getInt("id") + ", ");
                System.out.print("name: " + rs.getString("name") + ", ");
                System.out.println("score: " + rs.getInt("score") + "点");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}