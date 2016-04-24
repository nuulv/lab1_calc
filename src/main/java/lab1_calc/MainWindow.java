package lab1_calc;

import javax.swing.*;

public class MainWindow {
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton obliczButton;
    private JTextField textField3;

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
        comboBox1.setModel(new DefaultComboBoxModel(Dzialania.values()));
    }
}
