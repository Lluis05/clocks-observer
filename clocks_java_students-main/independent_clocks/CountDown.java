package independent_clocks;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Observable;

public class CountDown extends Widget{
    private Duration countdown;
    private JLabel countdownLabel;

    public CountDown(Duration countdown) {
        this.countdown = countdown;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 45, 5, 45));
        panel.setPreferredSize(new Dimension(500,120));
        countdownLabel = new JLabel();
        countdownLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 72));
        countdownLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(countdownLabel);
        JLabel placeLabel = new JLabel();
        placeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        placeLabel.setText("Countdown");
        placeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(placeLabel);

        updateClockLabel();
    }

    private void updateClockLabel() {
        String timeDisplay = DurationToString(countdown);
        countdownLabel.setText(timeDisplay);
    }
    @Override
    public void update(Observable arg0, Object arg1){
        if(!countdown.equals(Duration.ZERO)) {
            countdown = countdown.minusMillis(10);
            updateClockLabel();
        }
        else{
            countdownLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 50));
            countdownLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            countdownLabel.setText("FINALITZAT");
            arg0.deleteObserver(this);
        }
    }

    private String DurationToString(Duration countdown) {
        String formattedCountdown = String.format("%d:%02d:%02d",
                countdown.toHours(),
                countdown.toMinutesPart(),
                countdown.toSecondsPart());
        return formattedCountdown;
    }
}
