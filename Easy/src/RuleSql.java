import java.sql.*;

public class RuleSql
{
	public static void main(String[] args) throws Exception
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/G11?" +
		                                   "user=root&password=0000&serverTimezone=UTC&useSSL=false");

		    // Do something with the Connection
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM g11.rule;");
		    while(rs.next())
			{
				System.out.println(rs.getInt(1) + "\t"
					+ rs.getString(2) + "\t");
			}

		} catch (SQLException ex) {
		    // handle any errors
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}