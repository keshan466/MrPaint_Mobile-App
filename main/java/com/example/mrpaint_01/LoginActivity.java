package com.example.mrpaint_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mrpaint_01.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;

    Button btnLogin;

    UserService userService;

    String responseBody;

    User user = new User();

    private String UserName;
    String userid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        userService = ApiUtils.getUserService();

        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (validateLogin(username, password)) {
                    Login(username, password);
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void Login(String username, String password) {
        Call<String> call = userService.AuthenticateEmployee(username, password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                responseBody = response.body();
                Log.d("response", responseBody.toString());
                DataFetch();
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void DataFetch() {
        try {
            JSONObject obj = new JSONObject(responseBody);
            Log.d("JSONOBJ",obj.getString("UserName"));
            if(obj!=null) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("stuff", String.valueOf(obj));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        } catch ( JSONException e) {
            e.printStackTrace();
        }
    }

}
