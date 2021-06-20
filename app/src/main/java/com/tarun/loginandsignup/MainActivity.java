package com.tarun.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.usernameField);
        password=(EditText)findViewById(R.id.passwordField);
        buttonSignUp=(Button)findViewById(R.id.buttonSignin);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String pwd=password.getText().toString();

                if(validatePassword(pwd))
                {

                    Bundle bundle=new Bundle();
                    bundle.putString("username",uname);  //key,value pair
                    bundle.putString("password",pwd);
                    Intent intent=new Intent(MainActivity.this,SignIn.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public boolean validatePassword(String pwd){
        pwd.toLowerCase();
        int count=0;
        if(pwd.length()>=8)
        {
            count++;
        }
       for(int i=0;i<pwd.length();i++)
       {
           if(pwd.charAt(i)>=97 && pwd.charAt(i)<=122)
           {
               count++;
               break;
           }
       }
       if(count>=2)
       {
           return true;
       }
       else
       {
           return false;
       }

    }
}