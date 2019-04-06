package com.example.myapplication2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    public String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Intent intent = getIntent();
        String name_str = intent.getStringExtra(UserInfo.EXTRA_NAME);
        String surname_str = intent.getStringExtra(UserInfo.EXTRA_SURNAME);
        final String email_str = intent.getStringExtra(UserInfo.EXTRA_EMAIL);
        String tcNO_str = intent.getStringExtra(UserInfo.EXTRA_TCNO);
        final String phone_str = intent.getStringExtra(UserInfo.EXTRA_PHONE);
        String date_str = intent.getStringExtra(UserInfo.EXTRA_DATE);

        phoneNumber = phone_str;

        TextView name = findViewById(R.id.name_view);
        name.setText(name_str);

        TextView surname = findViewById(R.id.surname_view);
        surname.setText(surname_str);

        TextView email = findViewById(R.id.email_view);
        email.setText(email_str);

        TextView tcNo = findViewById(R.id.tcNo_view);
        tcNo.setText(tcNO_str);

        TextView phone = findViewById(R.id.phone_view);
        phone.setText(phone_str);

        TextView date = findViewById(R.id.date_view);
        date.setText(date_str);

        phone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onCall();
            }
        });


        email.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
                mailIntent.setData( Uri.parse("mailto:"+email_str));

                startActivity(mailIntent);
            }
        });

    }

    public void onCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData( Uri.parse("tel:"+phoneNumber));

            startActivity(callIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 1:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall();
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }

}
