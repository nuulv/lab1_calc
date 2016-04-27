package lab1_calc;

import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyInputVerifier extends InputVerifier implements Range {
    private Border defultborder = null;
    @Override
    public boolean verify(JComponent input) {
        if (defultborder == null)
            defultborder = input.getBorder();

        String text = ((JTextField) input).getText();
        if (NumberUtils.isNumber(text) || text.equals("")){
            float number = NumberUtils.toFloat(text, 0);
            if (number >= min && number <= max){
                input.setBorder(defultborder);
                return true;
            }
            input.setBorder(BorderFactory.createLineBorder(Color.RED));
            return false;
        }
        input.setBorder(BorderFactory.createLineBorder(Color.RED));
        return false;
    }
}
