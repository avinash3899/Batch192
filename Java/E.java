import java.util.HashSet;
 class Test {
    Test(){
        System.out.println("Hi");
    }   
}
class Demo extends Test {

    private Demo(){
        System.out.println("demo");
    }
}
public class E{
    public static void main(String[] args) {
        new Demo();
    }
}
