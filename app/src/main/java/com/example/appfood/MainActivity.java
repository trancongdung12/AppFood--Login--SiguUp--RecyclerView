package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email ,password;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        DB = new DBHelper(this);
        setContentView(R.layout.activity_login);

        Button next = (Button) findViewById(R.id.login);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String  emailLo = email.getText().toString();
                String  passwordLo = password.getText().toString();


                if(emailLo.equals("") || passwordLo.equals("")){
                    Toast.makeText(MainActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkLogin = DB.checkUsernamePassword(emailLo,passwordLo);
                    if(emailLo == "1"){
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
//                        Intent myIntent = new Intent(getApplicationContext(), AppActivity.class);
//                        startActivity(myIntent);
                    }else{
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        TextView nextSignUp = (TextView) findViewById(R.id.register_text);
        nextSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SignupActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}