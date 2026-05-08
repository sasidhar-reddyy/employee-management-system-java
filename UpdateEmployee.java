import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateEmployee {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "UPDATE employees SET salary=?, role=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, 75000);
            ps.setString(2, "Senior Java Developer");
            ps.setInt(3, 1);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
