class ReserTicket {
    private int total;

    public ReserTicket(int t) {
        this.total = t;
    }

    public synchronized boolean sellTicket() {
        if (this.total > 0) {
            this.total = this.total - 1;
            return true;
        } else {
            return false;
        }
    }
}

class Friend extends Thread {
    private static int threadID = 0;

    private ReserTicket release;
    private int count = 0;
    String name;

    public Friend(ReserTicket r, String name) {
        super("Friend:" + (++threadID));
        this.release = r;
        this.name = name;
    }

    public void run() {

        if (this.release.sellTicket()) {
            this.count = this.count + 1;
            System.out.println(this.getName() + ": got ticket 1");
            try {
                sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else
            System.out.println(this.getName() + "  got tickets:" + count);
    }
}

public class Movie {
    public static void main(String[] args) {
        ReserTicket r = new ReserTicket(2);
        Friend b1 = new Friend(r, "Friend1");
        Friend b2 = new Friend(r, "Friend2");
        Friend b3 = new Friend(r, "Friend3");
        b1.start();
        b2.start();
        b3.start();
    }
}