package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.myapplication2.EXTRA_NAME";
    public static final String EXTRA_SURNAME = "com.example.myapplication2.EXTRA_SURNAME";
    public static final String EXTRA_EMAIL = "com.example.myapplication2.EXTRA_EMAIL";
    public static final String EXTRA_TCNO = "com.example.myapplication2.EXTRA_TCNO";
    public static final String EXTRA_PHONE = "com.example.myapplication2.EXTRA_PHONE";
    public static final String EXTRA_DATE = "com.example.myapplication2.EXTRA_DATE";

    private Button clear;
    private Button save;
    private EditText surname;
    private EditText name;
    private EditText email;
    private EditText tcNo;
    private EditText phone;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        name = (EditText) findViewById(R.id.editText_name);
        surname = (EditText) findViewById(R.id.editText_surname);
        email = (EditText) findViewById(R.id.editText_email);
        tcNo = (EditText) findViewById(R.id.editText_tcNo);
        phone = (EditText) findViewById(R.id.editText_phone);
        date = (EditText) findViewById(R.id.editText_date);

        save = findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( (name.getText().toString()).equals("") || (surname.getText().toString()).equals("") ||  (email.getText().toString()).equals("") || (tcNo.getText().toString()).equals("") || (phone.getText().toString()).equals("") || (date.getText().toString()).equals("")){
                    Toast.makeText(UserInfo.this, "Bütün alanlar doldurulmalıdır!", Toast.LENGTH_SHORT).show();
                }
                else{
                    openProfilePage();
                }
            }
        });


        clear = findViewById(R.id.button_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                surname.setText("");
                email.setText("");
                tcNo.setText("");
                phone.setText("");
                date.setText("");
            }
        });
    }

    public void openProfilePage(){
        String name_str = name.getText().toString();
        String surname_str = surname.getText().toString();
        String email_str = email.getText().toString();
        String tcNo_str = tcNo.getText().toString();
        String phone_str = phone.getText().toString();
        String date_str = date.getText().toString();

        Intent intent = new Intent(this, ProfilePage.class);
        intent.putExtra(EXTRA_NAME, name_str);
        intent.putExtra(EXTRA_SURNAME, surname_str);
        intent.putExtra(EXTRA_EMAIL, email_str);
        intent.putExtra(EXTRA_TCNO, tcNo_str);
        intent.putExtra(EXTRA_PHONE, phone_str);
        intent.putExtra(EXTRA_DATE, date_str);

        startActivity(intent);
    }
}
