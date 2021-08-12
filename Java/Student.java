import java.util.Scanner;

public class Student{

    String name;
    int roll;
    int classNo;

    

    public void takeStudentDetails() {

        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();
        this.roll = scan.nextInt();
        this.classNo = scan.nextInt();
        
    }



    public void displayDetails(){
        System.out.println("Roll:"+roll+"-"+name+"-Class:"+classNo);
    }

}