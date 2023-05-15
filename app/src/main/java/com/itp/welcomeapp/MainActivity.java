package com.itp.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login,btn_register;
    EditText et_usename,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_usename=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        //username: itp
        //password: itp1234

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  userAuth();
            }
        });
        //using lamda
        btn_register.setOnClickListener((v)->{
            Toast.makeText(MainActivity.this, "I am register button", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void userAuth() {
        String username= et_usename.getText().toString();
        String password= et_password.getText().toString();
        Toast.makeText(MainActivity.this, "I am login button :"+username+" : "+password, Toast.LENGTH_LONG).show();
        if(password.equals("itp12345"))
//        if(username.equalsIgnoreCase("itp") &&password.equals("itp12345"))
        {
            //calling/opening FirstActivity.
            //Intents.: activity to activity.  Explicit Intent
            Intent intent=new Intent(this, FirstActivity.class);
            //setData
            intent.putExtra("uname",username);  //pasing username to firstActivity
            startActivity(intent);

            Toast.makeText(MainActivity.this, "Welcome:"+username, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainActivity.this, "invalid user", Toast.LENGTH_LONG).show();
        }
    }
}