import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame {
    public TitleScreen() {

        setTitle("Mon Title Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("BetterSoon", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setBackground(Color.DARK_GRAY);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setOpaque(true);

        JButton button = new JButton("Start the Game");
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Main main = new Main();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(title, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);

        setVisible(true);
    }
}
