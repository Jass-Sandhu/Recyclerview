package demo.demoprojects.activities;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import demo.demoprojects.R;

public class SplashActivity extends AppCompatActivity {


    int SPLASH_DISPLAY_LENGTH=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        *
        * handler
        * SPLASH_DISPLAY_LENGTH is miliseconds
        * */
        handler();



    }

    private void handler() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String isLogin= PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).getString("IsLogin", "");

                if(isLogin.equalsIgnoreCase("")){
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{

                    Intent intent=new Intent(SplashActivity.this,AccountDetailActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_DISPLAY_LENGTH);

    }

}
