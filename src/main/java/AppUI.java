import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class AppUI extends JPanel implements ActionListener {
    private JFrame window1, window2;
    private JPanel panel, panel2, welcome;
    private JButton newButton, recipeButton, doneButton, sampleButton;
    private JLabel title, recipeName;
    private JTextArea text;

    public void CookBook() {
        window1 = new JFrame("Cook Book");
        window1.pack();
        panel = new JPanel(new GridBagLayout());
        panel.setLayout(new GridBagLayout());
        newButton = new JButton("New Recipe");
        sampleButton = new JButton("TEST");
        title = new JLabel("Welcome to Cook Book!");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5,5, 5);

        newButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(newButton, c);

//        welcome = new JPanel(new GridBagLayout());
//        GridBagConstraints d = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
//        welcome.add(sampleButton, c);
        panel.add(title);

        window1.getContentPane().add(panel);
//        window1.getContentPane().add(welcome, "South");
         window1.setSize(400, 400);
        window1.setVisible(true);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void WriteRecipe() {
        window2 = new JFrame("New Recipe");
        window2.pack();

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        text = new JTextArea(40, 45);
        doneButton = new JButton("Done");

        doneButton.addActionListener(this);

        panel2.add(text);
        panel2.add(doneButton);

        window2.getContentPane().add(panel2);
        window2.setSize(700, 700);
        window2.setVisible(true);
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void writeInFile() {
        try {
            FileWriter fw = new FileWriter("Recipe.txt");
            String input = text.getText();
            fw.write(input);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newButton) {
            WriteRecipe();
        }
        if(e.getSource() == doneButton) {
            writeInFile();
            JOptionPane.showMessageDialog(null, "Your Recipe has been officially saved!");
        }
    }
}
