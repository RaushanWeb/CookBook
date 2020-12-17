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
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity
{
    EditText email,password;
    Button login,signup;
    FirebaseAuth mFirebaseAuth;
   private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        login = (Button)findViewById(R.id.button);
        signup  = (Button)findViewById(R.id.button2);

        mAuthStateListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if(user != null)
                {
                    Toast.makeText(loginActivity.this,"You are logged in!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this,ThirdActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(loginActivity.this,"Please login!",Toast.LENGTH_SHORT).show();
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(loginActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(Email.isEmpty() && Password.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(loginActivity.this,"Login error pleaee try again",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"login Succesfull",Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(loginActivity.this,ThirdActivity.class);
                                startActivity(intent1);
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        forSignup();

    }
    public void forSignup()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(loginActivity.this,signupActivity.class);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}