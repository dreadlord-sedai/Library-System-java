package lk.jiat.zlibrary.validation;

import javax.swing.JOptionPane;
import lk.jiat.zlibrary.entity.Validation;

/**
 *
 * @author Yashitha
 */
public class Validator {
    public static boolean isEmailValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                    "Email input can't be empty.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!value.matches(Validation.EMAIL.validate())) {
            JOptionPane.showMessageDialog(null, 
                    "Enter valid Email Addresss.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;

    }

    public static boolean isMobileValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                    "Mobile input can't be empty.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!value.matches(Validation.MOBILE.validate())) {
            JOptionPane.showMessageDialog(null, 
                    "Enter valid Mobile Number.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isPasswordValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                    "Password input can't be empty.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!value.matches(Validation.PASSWORD.validate())) {
            JOptionPane.showMessageDialog(null, 
                    "Password must include following characters. \n"
                            + "At least one lowercase \n"
                            + "At least one uppercase \n"
                            + "A special character \n"
                            + "The password must be greater than 4 and less than 8 characters.", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static boolean isInputFieldValid(String value){
        if(value.isBlank()){
            JOptionPane.showMessageDialog(null, 
                    "Input field cannot be empty", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static boolean isIndexValid(int value){
        if (value == 0) {
            JOptionPane.showMessageDialog(null, 
                    "Please Select a valid option", 
                    "Validation Message", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
}
