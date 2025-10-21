package independent_clocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Observable;
import java.util.Observer;

public class Stopwatch extends Widget{
    private JLabel stopwatchLabel;
    private JButton startStopButton;
    private boolean toggle = false;
    private Duration stopwatch =  Duration.ZERO;

    Stopwatch(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 45, 5, 45));
        panel.setPreferredSize(new Dimension(500,120));
        stopwatchLabel = new JLabel();
        stopwatchLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 72));
        stopwatchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(stopwatchLabel);
        JLabel placeLabel = new JLabel();
        placeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        startStopButton = new JButton("Start");
        startStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startStopButtonPressed(); // you program it
            }

        });
        panel.add(startStopButton);
        placeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(placeLabel);

        updateClockLabel();
    }

    private void startStopButtonPressed(){
        toggle = !toggle;

        if (toggle)
            startStopButton.setText("Stop");
        else
            startStopButton.setText("Start");
    }

    private void updateClockLabel() {
        String timeDisplay = DurationToString(stopwatch);
        stopwatchLabel.setText(timeDisplay);
    }
    private String DurationToString(Duration countdown) {
        String formattedCountdown = String.format("%d:%02d:%02d:%03d",
                countdown.toHours(),
                countdown.toMinutesPart(),
                countdown.toSecondsPart(),
                countdown.toMillisPart());

        return formattedCountdown;
    }

    @Override
    public void update(Observable arg0, Object arg1){
        if(toggle) {
            ClockTimer clockTimer = (ClockTimer) arg0;

            int period = clockTimer.getPeriod();
            stopwatch = stopwatch.plusMillis(period);
            updateClockLabel();
        }
    }
}
