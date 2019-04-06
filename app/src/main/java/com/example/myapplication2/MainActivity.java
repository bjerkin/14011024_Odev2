package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText password;
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username_input);
        password = (EditText) findViewById(R.id.password_input);

        button = findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if( (username.getText().toString().equals("admin")) && (password.getText().toString().equals("password"))){
                    openUserInfo();
                }
                else{
                    Toast.makeText(MainActivity.this,"Kullanıcı adı ya da şifre hatalı!",Toast.LENGTH_SHORT).show();
                }*/
                openUserInfo();
            }
        });
    }

    public void openUserInfo(){
        Intent intent = new Intent(this, UserInfo.class);
        startActivity(intent);
    }

}
