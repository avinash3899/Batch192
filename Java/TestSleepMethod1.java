class TestMultiPriority1 extends Thread {


    public void run() {
     
        System.out.println("running thread name is:" + Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
      
        

    }

    public static void main(String args[]) {
        TestMultiPriority1 m1 = new TestMultiPriority1();
        TestMultiPriority1 m2 = new TestMultiPriority1();
        m1.setName("m1");
        m2.setName("m2");
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m2.start();
        m1.start();

    }
}
