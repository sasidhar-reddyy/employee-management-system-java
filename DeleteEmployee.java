import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteEmployee {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM employees WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 1);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
