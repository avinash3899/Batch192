import java.sql.*;
import java.util.*;

class box{

}
/**
 * A
 */
class A {

    public static void main(String[] args) {
        System.out.println("lol");
    }

    
}


// public class A {
//     public static void main(String[] args) throws Exception {
//         Class.forName("oracle.jdbc.driver.OracleDriver");// loading the driver
//         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xepdb1", "AVINASH",
//                 "avinash3899");
//         // Statement st = con.createStatement();
//         // // String name = "'Pawan K'";
//         // PreparedStatement pst = con.prepareStatement("insert into mp192student(name)
//         // values ("+ name+")");
//         // pst.execute();
//         // String dob, address;
//         // int empno;
//         // long phoneno;
//         // //name = "Rahul";
//         // address = "hyderabad";
//         // dob = "12-05-1997";
//         // empno = 116;
//         // phoneno = 9473428795L;
//         // String qu = "insert into mp192student values(" + String.valueOf(empno) + ','
//         // + name + ',' + address + ',' + dob+ ',' + String.valueOf(phoneno) + ")";
//         // // System.out.println(qu);
//         // st.execute(qu);
//         // System.out.println("the row inserted successfully");
//         // st.execute("UPDATE mp192student SET address='BIHAR' WHERE EMPNO=111");
//         // System.out.println("the row updated successfully");
//         // st.execute("DELETE FROM MP192STUDENT WHERE EMPNO=111");
//         // // System.out.println("the row DELETED successfully");
//         // PreparedStatement lol = con.prepareStatement("update mp192student set
//         // empno=?,address=?,dob=?,phone=? where name like 'Savita'");

//         // lol.setInt(1, empno);
//         // lol.setString(2, address);
//         // lol.setString(3, dob);
//         // lol.setLong(4, phoneno);

//         // lol.execute();

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter salary,empno");
//         int empno = sc.nextInt();
//         // String name = sc.next();
//         // long phoneno = sc.nextLong();
//         int salary = sc.nextInt();
//         // String dept = sc.next();
//         PreparedStatement st = con.prepareStatement("update employee set salary = ? where accno = ?");
//         st.setInt(1, salary);
//         st.setInt(2, empno);
//         st.execute();
//         System.out.println("row updated");

//     }
// }