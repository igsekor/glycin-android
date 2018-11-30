package su.glycin.android.glycin.glycin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = LoginActivity.class.getName();

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
     * Field for saving user's email;
     */
    private String userEmail = "";

    /**
     * Field for saving user's password
     */
    private String userPassword = "";

//    /**
//     * Validation of email field on server side
//     */
//    private boolean isEmailValidOnServer = false;

//    /**
//     * Validation of password field on server side
//     */
//    private boolean isPasswordValidOnServer = false;

    /**
     * Overridden standard activity lifecycle method
     *
     * @param savedInstanceState bundle of the App
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.fieldsInitialization();
    }

    /**
     * Initialization of the Activity's fields
     */
    private void fieldsInitialization() {
        this.emailEditText = findViewById(R.id.login_email_edit_text);
        this.passwordEditText = findViewById(R.id.login_password_edit_text);
        this.loginButton = findViewById(R.id.login_button_login);

        this.emailEditText.setOnFocusChangeListener(this.emailFocusChangingListener);
        this.emailEditText.setOnEditorActionListener(this.emailTextChangingListener);
        this.passwordEditText.setOnFocusChangeListener(this.passwordFocusChangingListener);
        this.passwordEditText.setOnEditorActionListener(this.passwordTextChangingListener);
        this.loginButton.setOnClickListener(this.loginButtonClickListener);
    }

    /**
     * Listener on changing of email TextField's focus
     */
    private View.OnFocusChangeListener emailFocusChangingListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            validateEmailField();
        }
    };

    /**
     * Listener on pressing control buttons of software keyboard for email TextField's
     */
    private TextView.OnEditorActionListener emailTextChangingListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case 5:
                    validateEmailField();
                    break;
                default:
                    Log.d(LoginActivity.TAG, "Action code: " + String.valueOf(actionId));
            }
            return false;
        }
    };

    /**
     * Listener on pressing control buttons of software keyboard for password TextField's
     */
    private TextView.OnEditorActionListener passwordTextChangingListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case 6:
                    validatePasswordField();
                    break;
                default:
                    Log.d(LoginActivity.TAG, "Action code: " + String.valueOf(actionId));
            }
            return false;
        }
    };

    /**
     * Listener on changing of password TextField's focus
     */
    private View.OnFocusChangeListener passwordFocusChangingListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            validatePasswordField();
        }
    };

    /**
     * Listener for clicking on login button
     */
    private View.OnClickListener loginButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isAuthorized()) {
                emailEditText.setTextColor(getResources().getColor(R.color.colorSuccessText));
                passwordEditText.setTextColor(getResources().getColor(R.color.colorSuccessText));
            }
        }
    };

    /**
     * Email validation
     */
    private boolean isEmailValid() {
        if (!this.userEmail.equals("")) {
            String regExEmail = "[0-9A-Za-z.-_]+@[0-9A-Za-z.-_]+";
            return this.userEmail.matches(regExEmail);
        }
        return true;
    }

    /**
     * Validation of the text in email TextField
     */
    private void validateEmailField() {
        userEmail = emailEditText.getText().toString();
        if (!isEmailValid()) {
            emailEditText.setTextColor(getResources().getColor(R.color.colorWrongText));
            loginButton.setEnabled(false);
        } else {
            emailEditText.setTextColor(getResources().getColor(R.color.colorRightText));
            loginButton.setEnabled(true);
        }
    }

    /**
     * Password validation
     */
    private boolean isPasswordValid() {
        if (!this.userPassword.equals("")) {
            String regExPassword = "[0-9A-Za-z.-_]+";
            return this.userPassword.matches(regExPassword);
        }
        return true;
    }

    /**
     * Validation of the text in email TextField
     */
    private void validatePasswordField() {
        userPassword = passwordEditText.getText().toString();
        if (!isPasswordValid()) {
            passwordEditText.setTextColor(getResources().getColor(R.color.colorWrongText));
            loginButton.setEnabled(false);
        } else {
            passwordEditText.setTextColor(getResources().getColor(R.color.colorRightText));
            loginButton.setEnabled(true);
        }
    }

    /**
     * Method for authorization of the user by email and password
     * @return true if user is authorized
     */
    private boolean isAuthorized() {
        return true;
    }
}
