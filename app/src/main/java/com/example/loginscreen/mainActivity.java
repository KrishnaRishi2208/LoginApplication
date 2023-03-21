package com.example.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity extends Activity {
    Button login,google,fb;
    TextView forgotpass;
    EditText email,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        login=findViewById(R.id.login);
        google=findViewById(R.id.google);
        fb=findViewById(R.id.facebook);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        forgotpass = findViewById(R.id.forgot);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(mainActivity.this,forgotPassword.class);
                if(email.getText().toString().trim().length() > 0) {
                    i.putExtra("email", email.getText().toString());
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter Email Id",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    public void login(View view){
        String em=email.getText().toString();
        String pass=password.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(em.matches(emailPattern)){
        if(em.equals("rishi@gmail.com") && pass.equals("Rishi123")){
            Toast.makeText(getApplicationContext(),"Successful Login",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_LONG).show();
        }}
        else{
            Toast.makeText(getApplicationContext(),"Enter valid Email",Toast.LENGTH_LONG).show();
        }
    }

    public void google(View view){
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com"));
        startActivity(i);
    }
    public void fb(View view){
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.facebook.com"));
        startActivity(i);
    }
}
