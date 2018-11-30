package su.glycin.android.glycin.glycin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    /**
     * Email text field on the Activity
     */
    private EditText emailEditText;

    /**
     * Password text field on the Activity
     */
    private EditText passwordEditText;

    /**
     * Log in button on the Activity
     */
    private Button loginButton;

    /**
     * Overridden standard activity lifecycle method
     *
     * @param savedInstanceState bundle of the App
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialization of the Activity's fields
        this.emailEditText = findViewById(R.id.login_email_edit_text);
        this.passwordEditText = findViewById(R.id.login_password_edit_text);
        this.loginButton = findViewById(R.id.login_button_login);
    }
}
