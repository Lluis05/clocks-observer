package independent_clocks;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Observable;

public class ClockTimer extends Observable {
    private Timer timer;
    private int period; // milliseconds
    public ClockTimer(int period) {
        this.period = period;
        // digital and analog clocks receive the time, but stopwatches prefer the
        // period to add to the elapsed time
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                setChanged();
                notifyObservers(LocalDateTime.now());
            }
        };
        // see https://www.baeldung.com/java-timer-and-timertask
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, period, period);
        // delay is not 0 because then CountdownTimer wouldn't show the initial duration since
        // clocktimer calls update at once
    }
    public int getPeriod() {
        return period;
    }
}
