package independent_clocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


// adapted from https://stackoverflow.com/questions/67553152/how-do-i-create-a-clock-using-timer
public class DigitalClock extends Clock {
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss S"); // "H:mm:ss a"
  private JLabel clockLabel;


  public DigitalClock(int hoursOffsetTimeZoneOffset, String worldPlace) {
    this.hoursOffsetTimeZone = hoursOffsetTimeZoneOffset;
    this.repaintPeriod = 100;

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(5, 45, 5, 45));
    panel.setPreferredSize(new Dimension(500,120));
    clockLabel = new JLabel();
    clockLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 72));
    clockLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(clockLabel);
    JLabel placeLabel = new JLabel();
    placeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
    placeLabel.setText(worldPlace);
    placeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(placeLabel);

    LocalDateTime now =  LocalDateTime.now();
    repaint(now);
  }

  public void updateClockLabel(LocalDateTime now) {
    //LocalDateTime now = LocalDateTime.now().plus(hoursOffsetTimeZone, ChronoUnit.HOURS);
    // see https://www.geeksforgeeks.org/java/localdatetime-plus-method-in-java-with-examples/

    String timeDisplay = now.format(formatter);
    // see https://www.baeldung.com/java-datetimeformatter
    clockLabel.setText(timeDisplay);
    // repaint();
    // it seems there is no need to explicitly call repaint()

  }

    protected void repaint(LocalDateTime now){
      updateClockLabel(now);
    }

}
