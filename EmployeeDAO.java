import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public boolean addEmployee(Employee emp) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO employees(name,email,department,salary,role) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getRole());

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
