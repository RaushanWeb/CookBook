package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity
{
    EditText email,password;
    Button signup,alreadyLogin;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.signupEmail);
        password = (EditText)findViewById(R.id.signupPassword);
        signup = (Button)findViewById(R.id.signupButton);
        alreadyLogin  = (Button)findViewById(R.id.alreadyLogin);

       // signup();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                if(Email.isEmpty())
                {
                    email.setError("Please enter email id");
                    email.requestFocus();
                }
                else if(Password.isEmpty())
                {
                    password.setError("Please enter Password");
                    password.requestFocus();
                }
                else if(Email.isEmpty() && Password.isEmpty())
                {
                    Toast.makeText(signupActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(Email.isEmpty() && Password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(signupActivity.this,"Signup Unsucessfull plese try again!",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(signupActivity.this,"Signup Sucessfull !",Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(signupActivity.this,loginActivity.class);
                                startActivity(intent1);

                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(signupActivity.this,"Error occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        alreadyLogin();
    }

    public void alreadyLogin()
    {
        alreadyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });
    }
}