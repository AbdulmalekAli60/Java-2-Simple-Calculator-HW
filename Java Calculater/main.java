import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(230, 260);
        calculator.setVisible(true);
    }
}