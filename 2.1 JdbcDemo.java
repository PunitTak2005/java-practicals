import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "root"
            );

            // Insert Data
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO students(name, age) VALUES(?, ?)"
            );
            pst.setString(1, "Ankur");
            pst.setInt(2, 22);
            pst.executeUpdate();

            // Fetch Data
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "  " +
                                rs.getString("name") + "  " +
                                rs.getInt("age")
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

