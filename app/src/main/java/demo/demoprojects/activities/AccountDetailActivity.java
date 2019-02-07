package demo.demoprojects.activities;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import demo.demoprojects.R;
import demo.demoprojects.activities.adapters.CarsAdapter;

public class AccountDetailActivity extends AppCompatActivity {
    TextView tv_username;
    TextView tv_password;
    Button bt_ok;
    String username, password;
    RecyclerView rv_cars;
    CarsAdapter carsAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> carNamesArray=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        tv_username = findViewById(R.id.tv_username);
        tv_password = findViewById(R.id.tv_password);
        bt_ok = findViewById(R.id.bt_ok);
        rv_cars = findViewById(R.id.rv_cars);

        Intent intent = getIntent();

        if (intent.getStringExtra("username")!= null) {
            username = intent.getStringExtra("username");
            password = intent.getStringExtra("password");
            tv_username.setText(username);
            tv_password.setText(password);
        } else {
            username = PreferenceManager.getDefaultSharedPreferences(AccountDetailActivity.this).getString("Username", "");

            password = PreferenceManager.getDefaultSharedPreferences(AccountDetailActivity.this).getString("Password", "");
            tv_username.setText(username);
            tv_password.setText(password);
        }

        dummyList();
        setAdapter();
    }

    /*
    *
    * dummy car names
    * */

    public void dummyList(){

        carNamesArray.add("Maruti");
        carNamesArray.add("BMW");
        carNamesArray.add("Ferrari");
        carNamesArray.add("Jaguar");
    }

    /*
    * setAdapter
    *
    * */

    public void setAdapter(){


        linearLayoutManager=new LinearLayoutManager(AccountDetailActivity.this);
        CarsAdapter carsAdapter=new CarsAdapter(AccountDetailActivity.this,carNamesArray);
        rv_cars.setLayoutManager(linearLayoutManager);
        rv_cars.setAdapter(carsAdapter);

    }

    public void ReturnHome(View view) {

        PreferenceManager.getDefaultSharedPreferences(AccountDetailActivity.this).edit().putString("IsLogin", "").apply();
        PreferenceManager.getDefaultSharedPreferences(AccountDetailActivity.this).edit().putString("Username", "").apply();
        PreferenceManager.getDefaultSharedPreferences(AccountDetailActivity.this).edit().putString("Password", "").apply();

        setResult(RESULT_OK);
        Intent intent = new Intent(AccountDetailActivity.this, LoginActivity.class);
        startActivity(intent);

    }
}
