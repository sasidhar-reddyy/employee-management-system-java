import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewEmployees {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Salary : " + rs.getDouble("salary"));
                System.out.println("Role : " + rs.getString("role"));

                System.out.println("------------------------");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
