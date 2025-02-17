import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
  private JPanel mainPnl, topPnl, midPnl, botPnl;
  private JLabel label;
  private JTextArea textArea;
  private JScrollPane scrollPane;
  private JButton readBtn, quitBtn;
  private ImageIcon icon;

  private ArrayList<String> fortunes;
  private Random random;
  private int lastIndex = -1;

  public FortuneTellerFrame() {
    // Initialize components
    mainPnl = new JPanel(new BorderLayout());
    mainPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));

    createTopPnl();
    createMidPnl();
    createBotPnl();

    mainPnl.add(topPnl, BorderLayout.NORTH);
    mainPnl.add(midPnl, BorderLayout.CENTER);
    mainPnl.add(botPnl, BorderLayout.SOUTH);
    add(mainPnl);

    // Set window properties
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    setSize(screenSize.width / 2, screenSize.height / 2);
    setLocation(screenSize.width / 4, screenSize.height / 4);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    // Initialize fortunes and random generator
    fortunes = new ArrayList<>();
    random = new Random();
    populateFortunes();
  }

  private void createTopPnl() {
    topPnl = new JPanel();
    topPnl.setPreferredSize(new Dimension(100, 300));
    label = new JLabel("Fortune Teller");
    icon = new ImageIcon("src/fortune.png");

    label.setIcon(icon);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.NORTH);
    label.setFont(new Font("Ubuntu Mono", Font.PLAIN, 50));

    topPnl.add(label);
  }

  private void createMidPnl() {
    midPnl = new JPanel(new GridLayout(1, 1));
    midPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));

    textArea = new JTextArea(10, 50);
    textArea.setFont(new Font("Courier", Font.ITALIC, 20));
    textArea.setEditable(false);

    scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    midPnl.add(scrollPane);
  }

  private void createBotPnl() {
    botPnl = new JPanel(new GridLayout(1, 2));
    botPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));
    botPnl.setPreferredSize(new Dimension(50, 50));

    readBtn = new JButton("Read my Fortune!");
    readBtn.setFont(new Font("Arial", Font.BOLD, 36));
    readBtn.addActionListener(this::getFortune);

    quitBtn = new JButton("Quit");
    quitBtn.setFont(new Font("Arial", Font.BOLD, 36));
    quitBtn.addActionListener(e -> System.exit(0));

    botPnl.add(readBtn);
    botPnl.add(quitBtn);
  }

  private void populateFortunes() {
    fortunes.add("You will discover a hidden talent!");
    fortunes.add("You will get free coffee tomorrow!");
    fortunes.add("You will wake up feeling amazing!");
    fortunes.add("You will find something you thought was lost!");
    fortunes.add("You will make a new best friend!");
    fortunes.add("You will have the best meal of your life!");
    fortunes.add("You will receive a surprise gift!");
    fortunes.add("You will get an extra hour of sleep!");
    fortunes.add("You will ace your next test without studying!");
    fortunes.add("You will get front-row seats to your favorite concert!");
    fortunes.add("You will win a free vacation!");
    fortunes.add("You will become famous overnight!");
    fortunes.add("You will unlock a secret level in your favorite game!");
    fortunes.add("You will hear your favorite song on the radio!");
    fortunes.add("You will have the best luck of your life!");
  }

  private void getFortune(ActionEvent e) {
    int index;
    do {
      index = random.nextInt(fortunes.size());
    } while (index == lastIndex);

    lastIndex = index;
    textArea.append("Your Fortune is: " + fortunes.get(index) + "\n");
  }
}
