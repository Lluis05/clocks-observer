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
        super(hoursOffsetTimeZoneOffset, 100);

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
        repaint(LocalDateTime.now());
    }

    @Override
    protected void repaint(LocalDateTime now) {
        updateClockLabel(now);
    }

    private void updateClockLabel(LocalDateTime now) {
        String timeDisplay = now.format(formatter);
        clockLabel.setText(timeDisplay);
    }
}
