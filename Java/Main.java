import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Student> student = new ArrayList<Student>();
        
        for (int i = 0; i <2; i++) {
            Student s = new Student();
            s.takeStudentDetails();
            student.add(s);
        }
  
        String searchName="Sita Sinha";

        for (int i = 0; i < student.size(); i++) {

            if(student.get(i).name.equals(searchName) ){
                student.get(i).displayDetails();
                break;                            
            }
            else{
                if(i==student.size()-1)
                System.out.println("Student not found");
            }

            


            
        }

        ListIterator<Student> ls = student.listIterator();

            while (ls.hasNext()) {
                ls.next().displayDetails();
            }

    }
}
