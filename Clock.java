package independent_clocks;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;

public abstract class Clock extends Widget{
  // this is just to have in Main.java a list with digital and analog clocks
  protected int hoursOffsetTimeZone;
  protected int repaintPeriod;
  protected String worldPlace;
  protected LocalDateTime lastTimeRepaint;

  @Override
  public void update(Observable arg0, Object arg1){
      LocalDateTime now = (LocalDateTime) arg1;
      now = now.plusHours(hoursOffsetTimeZone);
      if(isTimeToRepaint(now)){
          repaint(now);
          lastTimeRepaint = now;
      }
  }

  private boolean isTimeToRepaint(LocalDateTime now){
    return (this.lastTimeRepaint == null
            || (now.minus(this.repaintPeriod, ChronoUnit.MILLIS)
            .isAfter(this.lastTimeRepaint)));
  }

  protected abstract void repaint(LocalDateTime now);
}
