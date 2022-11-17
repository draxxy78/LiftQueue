import java.net.http.WebSocket;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class RunLift {
    public static void main(String[] args) {
        liftProcessor();
    }

    public static void liftProcessor() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++) {
            scheduler.schedule(new LiftMovement(), 5, TimeUnit.SECONDS);
        }
        scheduler.shutdown();

    }


    static class LiftMovement implements Runnable {
        @Override
        public void run() {
            Lift lift = new Lift();
            if (lift.checkload(Math.random() * (1050 + 1) + 0)) {
                Request[] requests = Lift.getRequest();
                Lift.moveTo(requests);
            } else {
                System.out.println("Overweight!");
            }

        }
    }


}
