import java.sql.*;
import java.util.*;

public class JdbcAssignment {

    public static void main(String[] args) throws Exception {
        int empId, salary;
        String name, address, dept;
        Scanner scan = new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xepdb1", "AVINASH",
                "avinash3899");
        outerloop: while (true) {

            System.out.println("1.Create and Insert Employee to Database");
            System.out.println("2.Update salary of an existing employee");
            System.out.println("3.Delete an employee");
            System.out.println("4.Display employees");
            System.out.println("5.Exit the program");
            System.out.print("\nEnter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter employee ID:");
                    empId = scan.nextInt();
                    System.out.print("Enter employee name:");
                    name = scan.next();
                    System.out.print("Enter employee address:");
                    address = scan.next();
                    System.out.print("Enter employee salary:");
                    salary = scan.nextInt();
                    System.out.print("Enter employee department:");
                    dept = scan.next();

                    PreparedStatement ins = con.prepareStatement("insert into employee values(?,?,?,?,?)");

                    ins.setInt(1, empId);
                    ins.setString(2, name);
                    ins.setString(3, address);
                    ins.setInt(4, salary);
                    ins.setString(5, dept);
                    ins.execute();

                    System.out.println("\nEmployee successfully added to database.\n");
                    break;
                case 2:
                    System.out.print("\nEnter employee ID:");
                    empId = scan.nextInt();
                    System.out.print("Enter new salary:");
                    salary = scan.nextInt();

                    PreparedStatement upd = con.prepareStatement("update employee set salary=? where accno=?");

                    upd.setInt(1, salary);
                    upd.setInt(2, empId);
                    upd.execute();

                    System.out.println("\nSalary of employee " + empId + " updated to " + salary + ".\n");
                    break;
                case 3:
                    System.out.print("\nEnter employee ID:");
                    empId = scan.nextInt();

                    PreparedStatement del = con.prepareStatement("delete from employee where accno=?");

                    del.setInt(1, empId);
                    del.execute();

                    System.out.println("\nEmployee " + empId + " deleted.\n");
                    break;
                case 4:
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from employee");
                    ResultSetMetaData rsmd=rs.getMetaData();

                    System.out.println("\n");
                    while (rs.next())
                    System.out.println(rsmd.getColumnName(1)+"->"+rs.getInt(1) + "  "+rsmd.getColumnName(2)+"->"+ rs.getString(2) + "  " +rsmd.getColumnName(3)+"->"+ rs.getString(3)+"  "+rsmd.getColumnName(4)+"->"+rs.getString(4)+"  "+rsmd.getColumnName(5)+"->"+rs.getString(5));
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.println("Exiting program....");
                    break outerloop;

                default:
                    System.out.println("Enter correct choice");
                    break;
            }

        }

    }

}
