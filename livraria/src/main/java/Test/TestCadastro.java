package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCadastro {

	public boolean validarUsuario(String email, String password) {
		
        if (email != null && email.length() > 0 && password.length() >= 8) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
		
	}
}
