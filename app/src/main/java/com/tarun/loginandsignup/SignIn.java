package com.tarun.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    int count=0;
    EditText username,password;
    Button buttonSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username=(EditText)findViewById(R.id.usernameField);
        password=(EditText)findViewById(R.id.passwordField);
        buttonSignin=(Button)findViewById(R.id.buttonSignin);

        Bundle bundle=getIntent().getExtras();

        String uname=bundle.getString("username");
        String pwd=bundle.getString("password");

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals(uname)&&pass.equals(pwd)){
                    Toast.makeText(SignIn.this,"Success!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    count++;
                    if(count>=3)
                    {
                        buttonSignin.setEnabled(false);
                    }
                    Toast.makeText(SignIn.this,"Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}