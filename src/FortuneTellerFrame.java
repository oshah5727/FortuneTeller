import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JPanel mainPnl;
    private JPanel iconPnl;
    private JPanel displayPnl;
    private JPanel controlPnl;
    private JLabel iconLbl;
    private ImageIcon FTIcon;
    private JScrollPane scroller;
    private JTextArea fortuneTA;
    private JButton quitBtn;
    private JButton fortuneBtn;
    private int currentFortuneIndex = -1;

   public FortuneTellerFrame() {
       mainPnl = new JPanel();
       mainPnl.setLayout(new BorderLayout());

       createIconPanel();
       mainPnl.add(iconPnl, BorderLayout.NORTH);

       createDisplayPanel();
       mainPnl.add(displayPnl, BorderLayout.CENTER);

       createControlPanel();
       mainPnl.add(controlPnl, BorderLayout.SOUTH);

       add(mainPnl);

       Toolkit kit = Toolkit.getDefaultToolkit();
       Dimension screenSize = kit.getScreenSize();
       int screenHeight = screenSize.height;
       int screenWidth = screenSize.width;

       setSize(screenWidth / 3, screenHeight / 3);
       setLocation(screenWidth / 4, screenHeight / 4);

       Image img = kit.getImage("FortuneTellerImg.jpg");
       setIconImage(img);
       setTitle("CenteredFrame");
   }

   private void createIconPanel() {
       iconPnl = new JPanel();
       iconPnl.setLayout(new FlowLayout());

       FTIcon = new ImageIcon("src/FortuneTellerImg.jpg");
       iconLbl = new JLabel("Fortune Teller", FTIcon, JLabel.CENTER);

       iconLbl.setFont(new Font("Arial", Font.BOLD, 48));
       iconLbl.setVerticalTextPosition(JLabel.BOTTOM);
       iconLbl.setHorizontalTextPosition(JLabel.CENTER);

       iconPnl.add(iconLbl);
       iconPnl.setVisible(true);
   }

    private void createDisplayPanel() {
       displayPnl = new JPanel();
       fortuneTA = new JTextArea(10, 50);
       fortuneTA.setEditable(false);
       fortuneTA.setFont(new Font("Serif", Font.PLAIN, 15));
       scroller = new JScrollPane(fortuneTA);

       displayPnl.add(scroller);
       displayPnl.setVisible(true);
   }

    private void createControlPanel() {
       controlPnl = new JPanel();
       controlPnl.setLayout(new GridLayout(1,4));

        String[] fortuneList  = {"Your fortune is bright. But if you stare into it too long, you'll go blind.",
                "You will have a good day. Unless you spill coffee on your shirt.",
                "You will meet someone special. But they'll be dating someone else.",
                "You will get a raise at work. But then your taxes will go up.",
                "You will win the lottery. But you'll lose the ticket.",
                "You will travel to a new place. But you'll get lost.",
                "You will learn something new. But it will be something you don't need to know.",
                "You will make a new friend. But they'll move away.",
                "You will have a good laugh. But you'll snort.",
                "You will eat something delicious. But you'll get indigestion.",
                "You will sleep well tonight. But you'll wake up with a crick in your neck.",
                "You will wake up feeling refreshed. But then you'll have to go to work.",
                "Your future is full of possibilities. But most of them are bad.",
                "You will find true love. But they'll be a furry animal.",
                "You will achieve all your goals. But you'll be bored afterwards.",
                "You will become a millionaire. But you'll be in debt to your eyeballs.",
                "You will travel the world. But you'll get stuck in a customs line for 12 hours.",
                "You will live a long and happy life. But you'll be bored the last 20 years."
        };

       fortuneBtn = new JButton("Read My Fortune!");
       fortuneBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));

       Random rdm = new Random();

       fortuneBtn.addActionListener((ActionEvent ae) ->
       {
           int newFortuneIndex;
           do {
               newFortuneIndex = (rdm.nextInt(fortuneList.length));
           }
           while (newFortuneIndex == currentFortuneIndex);

           fortuneTA.append(fortuneList[newFortuneIndex] + "\n");
           currentFortuneIndex = newFortuneIndex;

       });

       quitBtn = new JButton("Quit");
       quitBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
       quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

       controlPnl.add(fortuneBtn);
       controlPnl.add(quitBtn);
   }
}
