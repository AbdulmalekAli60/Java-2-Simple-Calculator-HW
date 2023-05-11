import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculator extends JFrame {

  private JLabel firstJLabel;
  private JLabel secondJLabel;
  private JTextField firstJTextField;
  private JTextField secondJTextField;
  private JButton additionJButton;
  private JButton subtractionJButton;
  private JButton multiplyingJButton;
  private JButton divideJButton;
  private JButton calcJButton;

  public Calculator() { // Constructor
    super("Calculator"); //Title for the frame
    setLayout(new FlowLayout()); //To make the layout responsive

    // Adding all components of the frame, labels and buttons
    firstJLabel = new JLabel("Enter First Number: ");
    add(firstJLabel);

    firstJTextField = new JTextField(20);
    add(firstJTextField);

    secondJLabel = new JLabel("Enter Second Number: ");
    add(secondJLabel);

    secondJTextField = new JTextField(20);
    add(secondJTextField);

    additionJButton = new JButton("+");
    add(additionJButton);

    subtractionJButton = new JButton("-");
    add(subtractionJButton);

    multiplyingJButton = new JButton("x");
    add(multiplyingJButton);

    divideJButton = new JButton("/");
    add(divideJButton);

    calcJButton = new JButton("=");
    add(calcJButton);

    // adding events to the buttons
    ButtonHandler handler = new ButtonHandler();
    additionJButton.addActionListener(handler);
    subtractionJButton.addActionListener(handler);
    multiplyingJButton.addActionListener(handler);
    divideJButton.addActionListener(handler);
    calcJButton.addActionListener(handler);

  } // End Constructor

  private class ButtonHandler implements ActionListener {
    private String operation; // to store the operation sign from the if statements on class level

    @Override
    public void actionPerformed(ActionEvent event) {
      try {
        int Textfield1 = Integer.parseInt(firstJTextField.getText());
        int Textfield2 = Integer.parseInt(secondJTextField.getText());
        int result = 0;
        if (event.getSource() == additionJButton) {
          operation = "+";
        } else if (event.getSource() == subtractionJButton) {
          operation = "-";
        } else if (event.getSource() == multiplyingJButton) {
          operation = "*";
        } else if (event.getSource() == divideJButton) {
          operation = "/";
        } else if(event.getSource() == calcJButton) {
          result = calculation(Textfield1, Textfield2, operation);
          JOptionPane.showMessageDialog(rootPane, "The Result is: " + result, "Result", JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception exception) {
        JOptionPane.showMessageDialog(rootPane, exception.getMessage(), "Error occurred", JOptionPane.ERROR_MESSAGE);
      }
    } // End actionPerformed

  } // End action private class

  public int calculation(int firstNumber, int secondNumber, String operation) {

    int Result = 0;
    switch (operation) {
      case "+":
        Result = firstNumber + secondNumber;
        break;
      case "-":
        Result = firstNumber - secondNumber;
        break;
      case "*":
        Result = firstNumber * secondNumber;
        break;
      case "/":
        Result = firstNumber / secondNumber;
        break;
      default:
        break;
    }
    return Result;
  } // End calculation method

} // End Class
