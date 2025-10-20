package independent_clocks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    ClockTimer clockTimer = new ClockTimer(100);
    List<Widget> clocks = new ArrayList<>(List.of(
        new AnalogClock(0, "Cerdanyola, Catalonia"),
        new DigitalClock(-9, "Anchorage, Alaska"),
        new AnalogClock(3, "Moscow, Russia"),
        new DigitalClock(-7, "Sonora, Mexico"),
        new AnalogClock(-1, "Berlin, Germany"),
        new DigitalClock(-4, "Yerevan, Armenia"),
        new CountDown(Duration.ofSeconds(30))
    ));
    // see https://www.geeksforgeeks.org/java/initialize-an-arraylist-in-java/
    for (Widget w : clocks) {
      clockTimer.addObserver(w);
      w.show();
    }
  }
}