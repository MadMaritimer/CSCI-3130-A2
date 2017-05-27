package school.ben.csci_3130_a2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int passwordValidator(String s) {
        int ret = 0;
        if (notPassword(s))
            ret++;
        if (longEnough(s))
            ret++;
        return ret;
    }
    boolean notPassword(String s){
        return !s.toLowerCase().equals("password");
    }
    boolean longEnough(String s){
        return s.length()>=8;
    }
}
