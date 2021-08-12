import java.io.*;

public class B {
    public int b = 20;

    public void display() {
        System.out.println("B class");
    }

    public static void main(String args[]) throws Exception {
        DataInputStream dis = new DataInputStream(System.in);// reading the data from the keyboard
        FileOutputStream fos = new FileOutputStream("lol.txt");// writing the data into the file
        System.out.println("enter the text");
        int ch;
        while ((ch = dis.read()) != '\n') {
            fos.write(ch);
        }
        fos.close();
    }
}
