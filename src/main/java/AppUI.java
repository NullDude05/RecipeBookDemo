import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class AppUI extends JPanel implements ActionListener {
    private JFrame window1, window2;
    private JPanel panel, panel2;
    private JButton newButton, recipeButton, doneButton;
    private JLabel title, recipeName;
    private JTextArea text;

    public void CookBook() {
        window1 = new JFrame("Cook Book");
        window1.pack();

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        title = new JLabel("Welcome to Cook Book!");
        newButton = new JButton("New Recipe");

        newButton.addActionListener(this);

        panel.add(title, "North");
        panel.add(newButton, "South");

        window1.getContentPane().add(panel, "North");
        window1.setSize(500, 500);
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
