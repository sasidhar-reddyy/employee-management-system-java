public class AddEmployee {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Rahul");
        emp.setEmail("rahul@gmail.com");
        emp.setDepartment("IT");
        emp.setSalary(50000);
        emp.setRole("Java Developer");

        EmployeeDAO dao = new EmployeeDAO();

        boolean status = dao.addEmployee(emp);

        if(status) {
            System.out.println("Employee Added Successfully");
        } else {
            System.out.println("Failed");
        }
    }
}
