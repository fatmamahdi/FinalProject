package com.example.galaxycode;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Rigestr extends AppCompatActivity {
    EditText fullName,memail,mPassword,Phone2;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigestr);

        fullName = findViewById(R.id.fullName);
        memail = findViewById(R.id.email);
        mPassword =findViewById(R.id.Password);
        Phone2 =findViewById(R.id.Phone2);
        mRegisterBtn =findViewById(R.id.buttonR);
        mLoginBtn =findViewById(R.id.textView3);

        fAuth =FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= memail.getText().toString().trim();
                String password =mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    memail.setError("يرجى كتابت الايميل");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("يرجى كتابة الرقم السري ");
                    return;
                }
                if (password.length() <6){
                    mPassword.setError("يجب الرقم السري ان لايقل عن 6 ارقام");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Rigestr.this, "تم الانشاء", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Rigestr.this, "ايرور!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Rigestr.this,log_in.class);
                startActivity(intent);
            }
        });
    }
}
