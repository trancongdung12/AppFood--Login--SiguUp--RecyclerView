package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText email ,password,rePassword;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        DB = new DBHelper(this);
        Button signUp = (Button) findViewById(R.id.signUp_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.TextPassword);
        rePassword =(EditText)findViewById(R.id.retypePassword);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUp  = email.getText().toString();
                String passUp  = password.getText().toString();
                String rePassUp  = rePassword.getText().toString();

                if(email.equals("") || password.equals("") || rePassUp.equals("")){
                    Toast.makeText(SignupActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(passUp.equals(rePassUp)){
                        Boolean insert = DB.insertData(emailUp,passUp);
                        if(insert==true){
                            Toast.makeText(SignupActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivityForResult(myIntent, 0);
                        }else{
                            Toast.makeText(SignupActivity.this, "SignUp Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        TextView backLogin = (TextView) findViewById(R.id.back_login);
        backLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}