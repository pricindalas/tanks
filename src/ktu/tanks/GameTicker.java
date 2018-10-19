package ktu.tanks;

public class GameTicker {

    private boolean isRunning;
    private Tickable tickable;
    private long interval;

    private Runnable runnable = () -> {
        while (isRunning) {
            long t1 = System.currentTimeMillis();
            tickable.tick();
            long t = System.currentTimeMillis() - t1;

            if (t < interval) {
                try {
                    Thread.sleep(interval-t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public GameTicker(Tickable tickable, long interval) {
        this.tickable = tickable;
        this.interval = interval;
    }

    public void start() {
        this.isRunning = true;
        new Thread(runnable).start();
    }

    public void stop() {
        this.isRunning = false;
    }
}