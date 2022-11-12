import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Elevator {
    public static void main(String[] args)
    {
        Lift l = new Lift();
        Lift.getRequest();
    }

    public void goTo(int level) {
        System.out.println("Goto level " + level);
    }

// Queue

    public void submitRequests(int level) {
        System.out.println("Requested " + level);
        // put this request to queue
    }

    private void processRequest() {
        // process queued requests
        // run algorithms
        goTo(5);
    }

    public Elevator()
    {
        ScheduledExecutorService scheduler
                = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            scheduler.schedule(new sg.dlt.elevator.Elevator.RunnableElevatorRequestProcessor(i), 2, TimeUnit.SECONDS);
            scheduler.schedule(new sg.dlt.elevator.Elevator.RunnableRequestGenerator(), 4, TimeUnit.SECONDS);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        scheduler.shutdown();
    }

    class RunnableRequestGenerator implements Runnable {

        @Override
        public void run() {
            submitRequests(getRandomLevel());
        }

    }

    class RunnableElevatorRequestProcessor implements Runnable {

        private int identifier;

        RunnableElevatorRequestProcessor(int identifier) {
            this.identifier = identifier;
        }

        @Override
        public void run() {
            processRequest();
            System.out.println("Listening for commands " + identifier);
        }


    }

    private int getRandomLevel() {
        Random random = new Random();
        return random.nextInt(5);
    }

    class ElevatorListener extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                System.out.println("Listening for commands..");
            }
        }

    }

    class RequestGenerator extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                System.out.println("Listening for requests..");
                Random random = new Random();
                int level = random.nextInt(5);
                submitRequests(level);
            }
        }

    }

}
