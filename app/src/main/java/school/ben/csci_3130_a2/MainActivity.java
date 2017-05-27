package school.ben.csci_3130_a2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private int maxStrength = 5;

    public int passwordValidator(String s) {
        int ret = 0;
        if (notPassword(s))
            ret++;
        if (longEnough(s))
            ret++;
        if(hasSpecChar(s))
            ret++;
        if(isNotCommon(s))
            ret++;
        if(hasMixedCase(s))
            ret++;
        return ret;
    }
    boolean notPassword(String s){

        return !s.toLowerCase().equals("password");
    }
    boolean longEnough(String s){

        return s.length()>=8;
    }
    boolean isNotCommon(String s){
        String[] notOK = {"12345678","123456789","1234567890","qwertyuiop","1q2w3e4r",
                "abcd1234","zxcvbnm","football","baseball","letmeinplease" };
        for (String badPass:notOK) {
            if(s.equalsIgnoreCase(badPass))
                return false;
        }
        return true;
    }
    boolean hasSpecChar(String s){
        return !s.matches("[A-Za-z0-9]*");
    }
    boolean hasMixedCase(String s){
        return !s.equals(s.toLowerCase())&&!s.equals(s.toUpperCase());
    }

    public void btn_ValidatePress(View view) {
        EditText passAtmpt = (EditText) findViewById(R.id.txt_input);
        TextView feedback = (TextView) findViewById(R.id.feedback);
        if (passwordValidator(passAtmpt.getText().toString()) == maxStrength)
            feedback.setText("Password Secure");
        else
            feedback.setText("Password Insecure");
    }

}

