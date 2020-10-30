package com.example.uberclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;

import com.example.uberclone.R;
import com.example.uberclone.activities.client.RegisterActivity;
import com.example.uberclone.activities.driver.RegisterDriverActivity;
import com.example.uberclone.includes.MyToolbar;

public class SelectOptionAuthActivity extends AppCompatActivity {

    //Toolbar mToolbar;
    Button mButtonGoToLogin;
    Button mButtonGoToRegister;

    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);

        MyToolbar.show(this, "Seleccion de usuario", true);
        //mToolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle("Seleccionar opcion");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mButtonGoToLogin = findViewById(R.id.btngotologin);
        mButtonGoToRegister = findViewById(R.id.btngotoregister);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });
        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });

    }

    public void goToLogin() {
        Intent intent = new Intent(SelectOptionAuthActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToRegister() {
        String typeUser = mPref.getString("user", "");
        if (typeUser.equals("client")) {
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterDriverActivity.class);
            startActivity(intent);
        }
    }
}
