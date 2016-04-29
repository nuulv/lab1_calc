package lab1_calc;

import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;

public class MainWindow {
    private JPanel panel1;
    private JTextField lewyTextField;
    private JComboBox dzialanieComboBox;
    private JTextField prawyTextField;
    private JButton obliczButton;
    private JTextField wynikTextField;
    private JLabel opis;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        // change theme
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainWindow() {
        opis.setText(String.format("Do pól tekstowych należy wprowadzić liczby z zakresu od %d do %d", Range.min, Range.max));
        dzialanieComboBox.setModel(new DefaultComboBoxModel(Dzialania.values()));
        obliczButton.addActionListener(e -> obliczButtonAction());

        lewyTextField.setInputVerifier(new MyInputVerifier());
        prawyTextField.setInputVerifier(new MyInputVerifier());
    }

    private void obliczButtonAction() {
        if (lewyTextField.getInputVerifier().verify(lewyTextField)
                && prawyTextField.getInputVerifier().verify(prawyTextField)) {
            float a = NumberUtils.toFloat(lewyTextField.getText(), 0);
            float b = NumberUtils.toFloat(prawyTextField.getText(), 0);

            switch ((Dzialania) dzialanieComboBox.getSelectedItem()) {
                case DODAWANIE:
                    wynikTextField.setText(String.format("%f", a + b));
                    break;
                case ODEJMOWANIE:
                    wynikTextField.setText(String.format("%f", a - b));
                    break;
                case MNOZENIE:
                    wynikTextField.setText(String.format("%f", a * b));
                    break;
                case DZIELENIE:
                    wynikTextField.setText(String.format("%f", a / b));
                    break;
            }
        }
    }
}
