package com.example.galaxycode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class log_in extends AppCompatActivity {
    EditText nEmail,nPassword;
    Button nLoginButton;
    TextView mCreatBtn,forgotPassword;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        nEmail=findViewById(R.id.email);
        nPassword=findViewById(R.id.Password);
        nLoginButton=findViewById(R.id.button);
        mCreatBtn=findViewById(R.id.textView3);
        forgotPassword=findViewById(R.id.textView4);
        fAuth=FirebaseAuth.getInstance();

        nLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= nEmail.getText().toString().trim();
                String password =nPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    nEmail.setError("يرجى كتابت الايميل");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    nPassword.setError("يرجى كتابة الرقم السري ");
                    return;
                }
                if (password.length() <6){
                    nPassword.setError("يجب الرقم السري ان لايقل عن 6 ارقام");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(log_in.this, "اهلا بكم يا ابطال", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(log_in.this, "ايرور!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mCreatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Rigestr.class));
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText resetMail =new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog =new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("تريد تغيير الرقم السري؟");
                passwordResetDialog.setMessage("اكتب الايميل لتغيير الرقم السري");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //اكمل اذا في وقت هذا علشان يندز ايميل

                    }
                });
                passwordResetDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
            }
        });
    }
}