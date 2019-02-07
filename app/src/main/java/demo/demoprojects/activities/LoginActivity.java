package demo.demoprojects.activities;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import demo.demoprojects.R;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button bt_signin;
    private final int REQUEST_CODE=1122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        init();
        onClicks();

        Toast.makeText(this, "onCreate method is called", Toast.LENGTH_LONG).show();
    }


    /*
    * initization
    * */

    public void init(){

        et_username=findViewById(R.id.et_username);

        et_password=findViewById(R.id.et_password);

        bt_signin=findViewById(R.id.bt_signin);

    }


    /*
    *
    * Clicks

    * */


    public void onClicks(){

        bt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=et_username.getText().toString();

                String password=et_password.getText().toString();

                if(username.equalsIgnoreCase("")){

                    Toast.makeText(LoginActivity.this, getString(R.string.empty_username), Toast.LENGTH_SHORT).show();
                }
                else if(password.equalsIgnoreCase("")){

                    Toast.makeText(LoginActivity.this, getString(R.string.empty_password), Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(LoginActivity.this,AccountDetailActivity.class);

                    intent.putExtra("username",username);

                    intent.putExtra("password",password);

                    startActivityForResult(intent,REQUEST_CODE);


                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("IsLogin", "islogin").apply();
                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("Username",username).apply();
                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("Password",password).apply();

                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart method is called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume method is called", Toast.LENGTH_LONG).show();

        et_username.setText("");
        et_password.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause method is called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop method is called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy method is called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onrestart method is called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE){

            et_username.setText("");
            et_password.setText("");
        }

    }


    public static void hideKeyboard(Activity activity) {


        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
