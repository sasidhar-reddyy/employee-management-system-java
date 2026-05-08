import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployees")

public class ViewEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Employees</title>");

        out.println("<style>");
        out.println("table{width:80%;margin:auto;border-collapse:collapse;}");
        out.println("th,td{border:1px solid black;padding:10px;text-align:center;}");
        out.println("th{background-color:lightgray;}");
        out.println("h2{text-align:center;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<h2>Employee List</h2>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Department</th>");
        out.println("<th>Salary</th>");
        out.println("<th>Role</th>");
        out.println("</tr>");

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("department") + "</td>");
                out.println("<td>" + rs.getDouble("salary") + "</td>");
                out.println("<td>" + rs.getString("role") + "</td>");

                out.println("</tr>");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
