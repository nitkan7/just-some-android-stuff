package com.example.hello;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity{
    public TextInputLayout username;
    public TextInputLayout password;
    public ProgressBar progressbar;
    public MaterialButton loginButton;
    private BlogPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
       preferences=new BlogPreferences(this);
       if(preferences.isLoggedIn()){
           startMainActivity();
           finish();
           return;
       }
         username= findViewById(R.id.usernameLayout);
         password= findViewById(R.id.passwordLayout);
       loginButton= findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(v->onLoginClicked());
        progressbar=findViewById(R.id.progressbar);
        username.getEditText().addTextChangedListener(createTextWatcher(username));
        password.getEditText().addTextChangedListener(createTextWatcher(password));
    }

    private void onLoginClicked() {
        String usernamevalue= username.getEditText().getText().toString();
        String passwordvalue= password.getEditText().getText().toString();
        if(usernamevalue.isEmpty()){
            username.setError("empty");
        }
      else if(passwordvalue.isEmpty()){
            password.setError("password empty ");
        }
        else if(!usernamevalue.equals("admin")&&!passwordvalue.equals("admin")){
            showErrorDialog();
        }else{
            performLogin();
        }
    }

    private void showErrorDialog() {
        new AlertDialog.Builder(this).setTitle("Login Failed").setMessage("Username password wrong").setPositiveButton("OK",(dialog, which) -> dialog.dismiss()).show();
    }
  private TextWatcher createTextWatcher(TextInputLayout text){
        return  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

  }
  private void performLogin(){
        preferences.setLoggedIn(true);
        username.setEnabled(false);
      password.setEnabled(false);
        loginButton.setVisibility(View.INVISIBLE);
        progressbar.setVisibility(View.VISIBLE);

      Handler handler=new Handler();
      handler.postDelayed(()->{
        startMainActivity();
        finish();
      },2000);

  }
  private  void startMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

  }

}